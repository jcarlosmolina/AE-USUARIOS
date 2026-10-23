package com.keralty.aeusuarios.security;

import java.util.Base64;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
 
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.filters.SesionUnicaFilter;
import com.keralty.aeusuarios.global.AdminConstants;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.GestorConstants;
import com.keralty.aeusuarios.global.MesaDeApoyoConstants;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.global.SuperAdminConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.service.FuncionarioService;
import com.keralty.aeusuarios.service.GlobalServicesService;
import com.keralty.aeusuarios.viewmodel.UserInfoViewModel;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGVERIFICARUSUARIORequest;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Objects;
import java.util.Optional;

import com.keralty.aeusuarios.utils.Utilities;
import com.keralty.aeusuarios.viewmodel.LoginRequest;

@ApplicationScoped
public class TokenAuthenticationService implements UserAuthenticationService {

    TokenService tokens;

    UserCrudService users;

    UserFunctions userFunctions;
    
    GlobalServicesService globalServicesService;

    FuncionarioService funcionarioService;

    SesionUnicaFilter sesionUnicaFilter;

    @Inject
    public TokenAuthenticationService(TokenService tokens, UserCrudService users, UserFunctions userFunctions, GlobalServicesService globalServicesService, SesionUnicaFilter sesionUnicaFilter,
    		FuncionarioService funcionarioService) {
        this.tokens = tokens;
        this.users = users;
        this.userFunctions = userFunctions;
        this.globalServicesService = globalServicesService;
        this.sesionUnicaFilter = sesionUnicaFilter;
        this.funcionarioService = funcionarioService;
    }

    @Override
    public Optional<String> login(String username, String password) {
        Optional<User> user = users.findByUsername(username);
        if (user.isPresent()) {
            return user.filter(u -> Objects.equals(Utilities.encrypt(password), u.getPassword()))
                    .map(u -> tokens.issue(u));
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> login(LoginRequest loginRequest){
    	// Solo para los sistemas externos
    	Optional<User> user = users.findByFacetAndUsername(Constants.USUARIOSISTEMAEXTERNO , "{ \"login\": \"" + loginRequest.getUsername() + "\" }");
        if (user.isPresent()) {
            return user.filter(u -> Objects.equals(Utilities.encrypt(loginRequest.getPassword()), u.getPassword()))
                    .map(u -> tokens.issue(u));
        }
    	return Optional.empty();
    }

    @Override
    public UserInfoViewModel loginAzure(LoginRequest loginRequest){
    	
    	// Recibimos el token de Entra Id
    	// Extraemos la informacion del token
    	
    	UserInfoViewModel userInfo = new UserInfoViewModel();
    	// Si no ha llegado la informacion del token Entra ID
    	if (loginRequest.getUsername() == null || loginRequest.getUsername().isEmpty()) {
    		userInfo.setErrorCode("001");
    		return userInfo; 
    	}
    	
    	// Validamos el token recibido
    	if (!TokenAuthenticationService.validateIDToken(loginRequest.getUsername())) {
    		userInfo.setErrorCode("010");
    		return userInfo;
    	}
    	
    	String[] trozos = loginRequest.getUsername().split("\\.");
    	
    	// Si no tiene las 3 partes ...
    	if (trozos.length != 3) {
    		userInfo.setErrorCode("020");
    		return userInfo;
    	}
    	
    	Base64.Decoder decoder = Base64.getUrlDecoder();

    	// String header = new String(decoder.decode(trozos[0]));
    	String payload = new String(decoder.decode(trozos[1]));
    	// String signature = new String(decoder.decode(trozos[2]));
    	
    	
    	JsonObject payloadJson = new Gson().fromJson(payload, JsonObject.class);
		if (payloadJson == null) {
    		userInfo.setErrorCode("030");
			return userInfo;
		}
    	
		JsonArray roles = payloadJson.getAsJsonArray("roles");
    	if (roles == null || roles.size() == 0) {
    		userInfo.setErrorCode("040");
    		return userInfo;
    	}
    	
        boolean esSuperAdmin = false;
        boolean esAdmin = false;
        String role = "";
        for(JsonElement rol : roles) {
        	String rolString = rol.getAsString();
            if (rolString.equals("SUPERADMINISTRADOR")){
            	esSuperAdmin= true;
            	break;
            }
            if (rolString.equals("ADMIN")){
            	esAdmin= true;
            }                    	
         }
        if (esSuperAdmin)
        	role = "SUPERADMIN";
        else if (esAdmin)
        	role = "ADMIN";
        else
        	role = roles.get(0).getAsString();
    
        if ("ASESOR".equalsIgnoreCase(role) || "ASESORCOMERCIAL".equalsIgnoreCase(role)) {
        	role = "ASESOR COMERCIAL";
        }
        if ("MESADEAPOYO".equalsIgnoreCase(role)) {
        	role = "MESA DE APOYO";
        }
        
        // En el claims "prefered_username" encontraremos el valor a utiilzar para localizar al usuario en AE. 
        // Lo que era en la anterior versión el campo "UsuarioLDAP"
        
        String usuarioLDAP = payloadJson.get("preferred_username") == null ? null : payloadJson.get("preferred_username").getAsString();
        if (usuarioLDAP == null) {
    		userInfo.setErrorCode("050");
    		return userInfo;
        }
        // Pasamos a mayusculas
        usuarioLDAP = usuarioLDAP.toUpperCase();
        
        String agentJsonOid = "";
        String agentId = "";
        String agentRole = "";
        String idSesion = "";
        
        // Si NO es asesor, verificamos o creamos al usuario 
        if (!"ASESOR COMERCIAL".equalsIgnoreCase(role) && !"JEFEASESORES".equalsIgnoreCase(role)) {
            String primerNombre = "COMPLETAR";
            String segundoNombre = null;
            String primerApellido = "COMPLETAR";
            String segundoApellido = null;
            String email = usuarioLDAP;

            // Obtenemos nombre y correo electrónico de los claims
            String nombre = payloadJson.get("name") == null ? null : payloadJson.get("name").getAsString();
            if (nombre != null) {
    	        String[] partesNombre = nombre.split("\\s+");
    	        primerNombre = (partesNombre.length > 0 ? (partesNombre[0]).toUpperCase() : "COMPLETAR");
    	        segundoNombre = (partesNombre.length > 1 ? (partesNombre[1]).toUpperCase() : "");
    	        primerApellido = (partesNombre.length > 2 ? (partesNombre[2]).toUpperCase() : "COMPLETAR");
    	        segundoApellido = (partesNombre.length > 3 ? (partesNombre[3]).toUpperCase() : "");
            }
            
            // Llamamos al servicio global que verifica o inserta al usuario
            
            TGVERIFICARUSUARIORequest request = new TGVERIFICARUSUARIORequest();
            request.setTGVERIFICARUSUARIOpEmail(email);
            request.setTGVERIFICARUSUARIOpPrimerApellido(primerApellido);
            request.setTGVERIFICARUSUARIOpPrimerNombre(primerNombre);
            request.setTGVERIFICARUSUARIOpSegundoNombre(segundoNombre);
            request.setTGVERIFICARUSUARIOpSegundoApellido(segundoApellido);
            request.setTGVERIFICARUSUARIOptpagrRol(role.toUpperCase());
            request.setTGVERIFICARUSUARIOptpatrUsuario(usuarioLDAP);
            
            try {
            	ServiceResponse respuestaVerificar = globalServicesService.tGVERIFICARUSUARIO(request);
            	if (!respuestaVerificar.isOk()) {
            		org.slf4j.LoggerFactory.getLogger("TokenAuthenticationService").error("TokenAzure: 055. " + respuestaVerificar.getResultCode() + " - " + respuestaVerificar.getResultDescription());
            		userInfo.setErrorCode("055");
            		return userInfo;
            	}
            } catch(Exception e) {
            	
            }
            
        	Funcionario funcionario = userFunctions.fugetFuncionarioPorLDAPFun(usuarioLDAP);
        	if (funcionario == null || funcionario.isNull()) {
        		userInfo.setErrorCode("060");
        		return userInfo;
        	}
        	// Comprobamos que NO es un asesor
        	if (funcionario.getRol() == null || funcionario.getRol().isNull() || 
        		"ASESOR COMERCIAL".equalsIgnoreCase(funcionario.getRol().getRolNombre()) || 
        		"JEFEASESORES".equalsIgnoreCase(funcionario.getRol().getRolNombre())) {
        		userInfo.setErrorCode("070");
        		return userInfo;
        	}
        	agentJsonOid = funcionario.getOid().toJson();
        	agentId = funcionario.getFuncionarioId().toString();
        	
        	// El rol es el ultimo que tanga asignado
        	agentRole = "";
        	List<String> facetas = funcionario.getActiveFacets();
        	if (facetas.contains(SuperAdminConstants.CLASS_NAME)) {
        		agentRole = SuperAdminConstants.CLASS_NAME;
        	}
        	if (agentRole.isEmpty() && facetas.contains(AdminConstants.CLASS_NAME)) {
        		agentRole = AdminConstants.CLASS_NAME;
        	}
        	if (agentRole.isEmpty() && facetas.contains(AreaMedicaConstants.CLASS_NAME)) {
        		agentRole = AreaMedicaConstants.CLASS_NAME;
        	}
        	if (agentRole.isEmpty() && facetas.contains(RespRegionalConstants.CLASS_NAME)) {
        		agentRole = RespRegionalConstants.CLASS_NAME;
        	}
        	if (agentRole.isEmpty() && facetas.contains(AfiliacionesConstants.CLASS_NAME)) {
        		agentRole = AfiliacionesConstants.CLASS_NAME;
        	}
        	if (agentRole.isEmpty() && facetas.contains(GestorConstants.CLASS_NAME)) {
        		agentRole = GestorConstants.CLASS_NAME;
        	}
        	if (agentRole.isEmpty() && facetas.contains(MesaDeApoyoConstants.CLASS_NAME)) {
        		agentRole = MesaDeApoyoConstants.CLASS_NAME;
        	}

        	// Recuperamos el Id de sesion recien asignado
        	idSesion = (String) funcionario.getFuncionarioIdSesion();
        } else {
        	
        	// Los asesores comerciales deben existir, porque se sincroniza. 
        	// Si no figura en la BBDD como asesor no le permitimos el asesor
        	Funcionario funcionario = userFunctions.fugetFuncionarioPorLDAPFun(usuarioLDAP);
        	if (funcionario == null || funcionario.isNull()) {
        		userInfo.setErrorCode("080");
        		return userInfo;
        	}
        	
        	// Comprobamos si realmente tenga ese rol
        	if ((funcionario.getRol() == null || funcionario.getRol().isNull()) || 
        		(!"ASESOR COMERCIAL".equalsIgnoreCase(funcionario.getRol().getRolNombre()) && !"JEFEASESORES".equalsIgnoreCase(funcionario.getRol().getRolNombre()))) {
        		userInfo.setErrorCode("090");
        		return userInfo;
        	}
        	
        	Asesor asesor = funcionario.getAsesorFacet();
        	if (asesor == null || asesor.isNull()) {
        		userInfo.setErrorCode("085");
        		return userInfo;
        	}

        	agentJsonOid = asesor.getOid().toJson();
        	agentId = asesor.getFuncionarioId().toString();
        	agentRole = AsesorConstants.CLASS_NAME;
        	
        	// Llamamos para asignar el Id de sesion
        	SetIdSesionRequest setIdSesionRequest = new SetIdSesionRequest();
        	setIdSesionRequest.setFuncionariosetIdSesionpthisFuncionarioInstance(funcionario);
			ServiceResponse response = funcionarioService.setIdSesionImplementation(setIdSesionRequest);
			idSesion = (String) response.getInstance().getAttribute("IdSesion");
        }
        
    	Optional<User> user = users.findByFacetAndUsername("Funcionario", agentId);
  	
    	// Obtenemos el token y lo devolvemos
    	if (user.isPresent()) {
    		final String ids = new String(idSesion);
    		Optional<String> token =  user.map(u -> tokens.issue(u, ids));
    		if (!token.isPresent()) {
        		userInfo.setErrorCode("100");
    			return userInfo;
    		}
    		userInfo.setToken(token.get());
    	} else {
    		userInfo.setErrorCode("110");
    		return userInfo;
    	}

        userInfo.setOidJson(agentJsonOid);
    	userInfo.setRoles(agentRole);
    	userInfo.setHasRegistered(true);

    	return userInfo;
    }
    
    private String insertarIdSesionUsuario(String agentId) {
    	// Inserta o actualiza el id de sesion para el usuario
    	String id = String.valueOf(System.currentTimeMillis());
		return id;
	}
    
    public static boolean validateIDToken(String idToken) {
        DecodedJWT jwt = JWT.decode(idToken);
 
        try {
            JwkProvider provider = new UrlJwkProvider(
                new URL("https://login.microsoftonline.com/common/discovery/v2.0/keys"));
            Jwk jwk = provider.get(jwt.getKeyId());
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
             
            //Invalid token will throw SignatureVerificationException
            algorithm.verify(jwt);
 
            //Validate expiry (not shown here)
            //...
 
            return true;
        } catch (MalformedURLException | JwkException e) {
            throw new SystemException(e);
        } catch (SignatureVerificationException e) {
            return false;
        }
    }

    @Override
    public void logout(User user) {
        if (user != null) {
            throw new IllegalArgumentException("User must not be null");
        }
        // No additional logic
    }

}
