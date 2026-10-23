package com.keralty.aeusuarios.api;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import com.keralty.aeusuarios.security.UserAuthenticationService;
import com.keralty.aeusuarios.security.User;
import com.keralty.aeusuarios.viewmodel.LoginRequest;
import com.keralty.aeusuarios.viewmodel.UserInfoViewModel;
import io.quarkus.security.UnauthorizedException;

import com.google.gson.JsonObject;
import com.keralty.aeusuarios.global.AdminConstants;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.GestorConstants;
import com.keralty.aeusuarios.global.MesaDeApoyoConstants;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.global.SuperAdminConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.security.User;
import com.keralty.aeusuarios.service.AsesorService;
import com.keralty.aeusuarios.service.FuncionarioService;
import com.keralty.aeusuarios.utils.TokenUtilities;

@Path("/")
@RequestScoped
public class AccountApiController {

    UserAuthenticationService authenticationService;

    JsonWebToken jwt; 

    AsesorService asesorSrv;

    UserFunctions userFunctions;

    FuncionarioService funcionarioService;
    
    public AccountApiController(UserAuthenticationService authenticationService, JsonWebToken jwt, UserFunctions userFunctions, AsesorService asesorSrv, FuncionarioService funcionarioService) {
    	this.authenticationService = authenticationService;
    	this.jwt = jwt;
    	this.userFunctions= userFunctions; 
    	this.asesorSrv = asesorSrv;
    	this.funcionarioService = funcionarioService;
    	TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @POST
    @Path("/Token")
    @Produces(MediaType.TEXT_PLAIN)
    public RestResponse<String> login(LoginRequest loginRequest) {
        Optional<String> token = authenticationService.login(loginRequest);
        if (token.isPresent()) {
            return ResponseBuilder.ok("\"" + token.get() + "\"", MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new UnauthorizedException();
        }
    }

    @POST
    @Path("/TokenAzure")
    public UserInfoViewModel loginAzure(LoginRequest loginRequest) {
        return authenticationService.loginAzure(loginRequest);
    }

    @POST
    @Path("/api/Account/Logout")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo","UsuarioSistemaExterno"})
    public boolean logout(User user) {
        authenticationService.logout(user);
        return true;
    }

    @POST
    @Path("/api/Account/UserInfo")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public UserInfoViewModel getUserInfo(@Context SecurityContext sec) {
        UserInfoViewModel userInfo = new UserInfoViewModel();
        Principal principal = sec.getUserPrincipal();
        if (principal != null){
            String userRoles = jwt.getGroups().stream().collect(Collectors.joining(","));
            userInfo = new UserInfoViewModel(principal.getName(), userRoles);
            userInfo.setGridPreferences(new ArrayList<>());
        }
        try {
        	cargarCache(userInfo);
        } catch (Exception e) {
        	org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Loading user cache. " + e.getMessage());
        }
        return userInfo;
    }
    
    public void cargarCache(UserInfoViewModel userInfo) {

    	// Metemos todos los datos que queramos tener en cache en un JSON
    	
    	JsonObject cacheJson = new JsonObject();

    	// Devolvemos en al cache el nombre del usuario para utilizarlo en llamadas a BH y logs
    	Funcionario funcionario = funcionarioService.getById(Long.valueOf(userInfo.getEmail()));
    	if (funcionario != null && !funcionario.isNull()) {
    		cacheJson.addProperty("userName", funcionario.getFuncionarioUsuarioLDAP());
    	}
    	
    	// --------------------------------------------------------------------------------------
    	// fechaInicioConsultaSolicitudes : Fecha de inicio a utilizar en consulta de solicitudes 
    	// --------------------------------------------------------------------------------------

    	// Cargamos el periodo maximo de busqueda de solicitudes
    	// Por defecto 90 dias
    	int periodoConsultaSolicitudes = 90;
    	// En funcion del rol buscamos un paraemtros u otro
		//    	PERCON_ADMIN: Para rol Admin y SuperAdmin
		//    	PERCON_ASESOR: Para rol Asesor
		//    	PERCON_AREAMEDICA: Para rol area Medica
		//    	PERCON_AFILIACIONES: Para rol Afiliaciones
		//    	PERCON_RESPREGIONAL: Para rol RespRegional
		//    	PERCON_GESTOR: Para rol Gestor
		//    	PERCON_MESADEAPOYO: Para rol Mesa de Apoyo
		//    	PERCON_TODOS: Valor por defecto para todos los roles
    	String valor = userFunctions.fugetValorParametroConfFun("PERCON_TODOS");
    	if (valor != null && !valor.isEmpty()){
    		try {
    			periodoConsultaSolicitudes = Integer.parseInt(valor);
    		} catch (Exception e) {
			}
    	}
    	// Utilizamos un parametro u otro en funcion del agente
    	valor = null;
    	if (userInfo.getRoles().contains(SuperAdminConstants.CLASS_NAME) || userInfo.getRoles().contains(AdminConstants.CLASS_NAME)){
        	valor = userFunctions.fugetValorParametroConfFun("PERCON_ADMIN");
    	}    	
    	if (userInfo.getRoles().contains(AsesorConstants.CLASS_NAME)){
        	valor = userFunctions.fugetValorParametroConfFun("PERCON_ASESOR");
    	}
    	if (userInfo.getRoles().contains(AreaMedicaConstants.CLASS_NAME)){
        	valor = userFunctions.fugetValorParametroConfFun("PERCON_AREAMEDICA");
    	}
    	if (userInfo.getRoles().contains(AfiliacionesConstants.CLASS_NAME)){
        	valor = userFunctions.fugetValorParametroConfFun("PERCON_AFILIACIONES");
    	}
    	if (userInfo.getRoles().contains(RespRegionalConstants.CLASS_NAME)){
        	valor = userFunctions.fugetValorParametroConfFun("PERCON_RESPREGIONAL");
    	}
    	if (userInfo.getRoles().contains(GestorConstants.CLASS_NAME)){
        	valor = userFunctions.fugetValorParametroConfFun("PERCON_GESTOR");
    	}
    	if (userInfo.getRoles().contains(MesaDeApoyoConstants.CLASS_NAME)){
        	valor = userFunctions.fugetValorParametroConfFun("PERCON_MESADEAPOYO");
    	}
    	if (valor != null && !valor.isEmpty()){
    		try {
    			periodoConsultaSolicitudes = Integer.parseInt(valor);    			
    		} catch (Exception e) {
    			// Dejamos el de por defecto
    		}
    	}
    	cacheJson.addProperty("periodoConsultaSolicitudes", periodoConsultaSolicitudes);
    	
    	
    	// --------------------------------------------------------------------------------------
    	// maxReintentosCORE : Num. de reintentos en las llamadas a servicios del CORE 
    	// --------------------------------------------------------------------------------------
    	valor = userFunctions.fugetValorParametroConfFun("WS_MAXREINTENTOS");
    	if (valor != null && !valor.isEmpty()){
    		cacheJson.addProperty("maxReintentosCORE", valor);    		
    	}

    	// --------------------------------------------------------------------------------------
    	// timeoutCORE : Tiempo en segundos de timeout para las llamadas al CORE 
    	// --------------------------------------------------------------------------------------
    	valor = userFunctions.fugetValorParametroConfFun("WS_TIMEOUT");
    	if (valor != null && !valor.isEmpty()){
    		cacheJson.addProperty("timeoutCORE", valor);
    	}
    	
    	// --------------------------------------------------------------------------------------
    	// sizeAdjuntos : Tamanyo maximo de los adjuntos, expresado en MB 
    	// --------------------------------------------------------------------------------------
    	valor = userFunctions.fugetValorParametroConfFun("TAMANYOMAX_ADJUNTOS");
    	Integer size = 0;
    	if (valor != null && !valor.isEmpty() && AccountApiController.esEntero(valor)){
    		size = Integer.valueOf(valor);
    	}
    	Integer sizeSIS = 0;
    	// Tamanyo maximo de los adjuntos, expresado en MB, fijado por sistemas
    	valor = userFunctions.fugetValorParametroConfFun("TAMANYOMAX_ADJUNTOS_SIS");
    	if (valor != null && !valor.isEmpty() && AccountApiController.esEntero(valor)){
    		sizeSIS = Integer.valueOf(valor);
    	}
    	if (sizeSIS != 0 && sizeSIS < size) {
    		cacheJson.addProperty("sizeAdjuntos", sizeSIS);
    	} else {
    		cacheJson.addProperty("sizeAdjuntos", size);
    	}
    	
    	// --------------------------------------------------------------------------------------
    	// Datos de Asesor 
    	// --------------------------------------------------------------------------------------
    	Asesor asesor = this.asesorSrv.getById(Long.valueOf(this.jwt.getName()));
    	if (asesor != null && !asesor.isNull()) {
    		cacheJson.addProperty("modDBasicosPersona", asesor.getAsesorModDBasicosPersona());
    		cacheJson.addProperty("esIntegral", asesor.getAsesorEsIntegral());
    		cacheJson.addProperty("verContratoNovedad", asesor.getAsesorVerContratoNovedad());
    		cacheJson.addProperty("verDBasicosPersona", asesor.getAsesorVerDBasicosPersona());
    		cacheJson.addProperty("verDocIdentificacionPersona", asesor.getAsesorVerDocIdentificacionPersona());
    		cacheJson.addProperty("accesoValidadorUsuarios", asesor.getAsesorAccesoValidadorUsuarios());
    	} else {
    		cacheJson.addProperty("modDBasicosPersona", true);
    		cacheJson.addProperty("esIntegral", true);
    		cacheJson.addProperty("verContratoNovedad", true);
    		cacheJson.addProperty("verDBasicosPersona", true);
    		cacheJson.addProperty("verDocIdentificacionPersona", true);
    		cacheJson.addProperty("accesoValidadorUsuarios", true);
    	}
    	
    	// --------------------------------------------------------------------------------------
    	// Valores de exportacion a Excel 
    	// --------------------------------------------------------------------------------------
    	valor = userFunctions.fugetValorParametroConfFun("EXP_EXCEL_BLOCKSIZE");
    	if (valor != null && !valor.isEmpty() && AccountApiController.esEntero(valor)){
    		cacheJson.addProperty("expExcelBlockSize", Integer.valueOf(valor));    		
    	} else {
    		cacheJson.addProperty("expExcelBlockSize", 40);
    	}
    	valor = userFunctions.fugetValorParametroConfFun("EXP_EXCEL_TIMEOUT");
    	if (valor != null && !valor.isEmpty() && AccountApiController.esEntero(valor)){
    		cacheJson.addProperty("expExcelTimeout", Integer.valueOf(valor));    		
    	} else {
    		cacheJson.addProperty("expExcelTimeout", 0);
    	}

    	
    	userInfo.setUserCache(cacheJson.toString());
	}
    
    private static boolean esEntero(String valor) {
    	Integer in = 0;
    	try {
    		in = Integer.parseInt(valor);
    	} catch (Exception e) {
    		org.slf4j.LoggerFactory.getLogger("AccountApiController").error("Valor '" + valor + "' no es numerico");
    		return false;
    	}
    	return in >= 0;
    }    

    
    @POST
    @Path("/api/Account/AnonymousUserInfo")
    @Operation(hidden = true)
    public UserInfoViewModel getAnonymousUserInfo() {
        return new UserInfoViewModel("", "");
    }
}
