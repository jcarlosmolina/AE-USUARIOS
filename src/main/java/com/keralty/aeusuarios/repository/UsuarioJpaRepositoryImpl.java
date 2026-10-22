package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AesolicitudesConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.CuestionarioPConstants;
import com.keralty.aeusuarios.global.DetalleTarifaConstants;
import com.keralty.aeusuarios.global.DireccionConstants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.global.MunicipioConstants;
import com.keralty.aeusuarios.global.ParentescoConstants;
import com.keralty.aeusuarios.global.ParentescoDomConstants;
import com.keralty.aeusuarios.global.PersonaConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.PreguntaConstants;
import com.keralty.aeusuarios.global.PreguntaPConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.SeccionPConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.global.TarifaConstants;
import com.keralty.aeusuarios.global.TipoDireccionConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.global.UsuarioConstants;
import com.keralty.aeusuarios.global.UsuarioRegConstants;
import com.keralty.aeusuarios.persistence.Usuario;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLGetOne;
import com.keralty.aeusuarios.sqlutils.SQLMax;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLSum;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandNull;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Agent;
import jakarta.inject.Inject;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import org.slf4j.LoggerFactory;

public class UsuarioJpaRepositoryImpl extends AbstractRepository implements UsuarioJpaRepositoryCustom {

    @Inject
    public UsuarioJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Usuario> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Usuario> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Usuario> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Usuario> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Usuario.class);
    }

    @Override	
    public List<Usuario> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<Usuario> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public Long nextUsuarioIdentificador(Long aesolicitudesidsolicitud) {
        try {
            SQLMax sql = new SQLMax(null, UsuarioConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME + "." + UsuarioConstants.ATTR_FIELD_USUARIOIDENTIFICADOR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(aesolicitudesidsolicitud, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(Usuario.class).error(e.getMessage());
            return 1L;
        }
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000(Usuario instance) throws SystemException {
        try {
            // EXIST (Parentesco)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_PARENTESCO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Boolean assocOperator001(Usuario instance) throws SystemException {
        try {
            // EXIST (CuestionarioP)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Boolean assocOperator001Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLExists assocOperator001Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_CUESTIONARIOP, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(Usuario instance) throws SystemException {
        try {
            // EXIST (Solicitud.Aesolicitudes.ProductoT.Dominios) WHERE (Solicitud.Aesolicitudes.ProductoT.Dominios.PlanT = Solicitud.Aesolicitudes.PlanT AND Solicitud.Aesolicitudes.ProductoT.Dominios.AcepCuesMat = true)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.ProductoT.Dominios.PlanT = Solicitud.Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getSolicitud().isNull() || instance.getSolicitud().getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getSolicitud().getAesolicitudes().getPlanT().getOid(), UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Solicitud.Aesolicitudes.ProductoT.Dominios.AcepCuesMat = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOACEPCUESMAT, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Boolean assocOperator003(Usuario instance) throws SystemException {
        try {
            // EXIST (Solicitud.Aesolicitudes.ProductoT.Dominios) WHERE (Solicitud.Aesolicitudes.ProductoT.Dominios.PlanT = Solicitud.Aesolicitudes.PlanT AND Solicitud.Aesolicitudes.ProductoT.Dominios.AcepCuesNeo = true)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Boolean assocOperator003Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLExists assocOperator003Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.ProductoT.Dominios.PlanT = Solicitud.Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getSolicitud().isNull() || instance.getSolicitud().getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getSolicitud().getAesolicitudes().getPlanT().getOid(), UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Solicitud.Aesolicitudes.ProductoT.Dominios.AcepCuesNeo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOACEPCUESNEO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Boolean assocOperator004(Usuario instance) throws SystemException {
        try {
            // EXIST (AnexoMat)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Boolean assocOperator004Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLExists assocOperator004Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ANEXOMAT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Boolean assocOperator005(Usuario instance) throws SystemException {
        try {
            // EXIST (CuestionarioP)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Boolean assocOperator005Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLExists assocOperator005Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_CUESTIONARIOP, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Boolean assocOperator006(Usuario instance) throws SystemException {
        try {
            // EXIST (CuestionarioP) WHERE (CuestionarioP.YaDiligenciado = true)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Boolean assocOperator006Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLExists assocOperator006Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_CUESTIONARIOP, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // CuestionarioP.YaDiligenciado = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    if (instance.getCuestionarioP().getCuestionarioPYaDiligenciado()!= null){
                    comparison1.setFirstOperand(new SQLWhereOperandLiteral(instance.getCuestionarioP().getCuestionarioPYaDiligenciado(), Constants.Type.BOOL.getTypeName()));
                    } else {
                    comparison1.setFirstOperand(new SQLWhereOperandNull());
                    }
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Boolean assocOperator007(Usuario instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiario)
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Boolean assocOperator007Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator007Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLExists assocOperator007Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Boolean assocOperator008(Usuario instance) throws SystemException {
        try {
            // EXIST (CuestionarioP.Secciones.Preguntas) WHERE (CuestionarioP.Secciones.Preguntas.Pregunta.Numero = StrToInt(fugetValorParametroConf("PREGUNTAEMBARAZO")) AND CuestionarioP.Secciones.Preguntas.RespuestaSiNo = true AND CuestionarioP.Secciones.Preguntas.ValoresRespuestas <> NULL)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Boolean assocOperator008Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator008Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLExists assocOperator008Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // CuestionarioP.Secciones.Preguntas.Pregunta.Numero = StrToInt(fugetValorParametroConf("PREGUNTAEMBARAZO"))
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ROLE_NAME_PREGUNTA + "." + PreguntaConstants.ATTR_NAME_PREGUNTANUMERO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                            if (STDFunctions.strToIntFun(userFunctionsSrv.fugetValorParametroConfFun("PREGUNTAEMBARAZO")) != null) {
                                comparison1.setSecondOperand(new SQLWhereOperandLiteral(STDFunctions.strToIntFun(userFunctionsSrv.fugetValorParametroConfFun("PREGUNTAEMBARAZO")), Constants.Type.INT.getTypeName()));
                            } else {
                                comparison1.setSecondOperand(new SQLWhereOperandNull());
                                }
                    conjunction.addOperand(comparison1);


            // CuestionarioP.Secciones.Preguntas.RespuestaSiNo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ATTR_NAME_PREGUNTAPRESPUESTASINO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);


            // CuestionarioP.Secciones.Preguntas.ValoresRespuestas <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ATTR_NAME_PREGUNTAPVALORESRESPUESTAS, Constants.Type.STRING.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public String assocOperator009(Usuario instance) throws SystemException {
        try {
            // GETONE (CuestionarioP.Secciones.Preguntas.ValoresRespuestas) WHERE (CuestionarioP.Secciones.Preguntas.Pregunta.Numero = StrToInt(fugetValorParametroConf("PREGUNTAEMBARAZO")) AND CuestionarioP.Secciones.Preguntas.RespuestaSiNo = true)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public String assocOperator009Range1 (Usuario instance) throws SystemException {
        SQLGetOne sql = assocOperator009Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLGetOne assocOperator009Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ATTR_NAME_PREGUNTAPVALORESRESPUESTAS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // CuestionarioP.Secciones.Preguntas.Pregunta.Numero = StrToInt(fugetValorParametroConf("PREGUNTAEMBARAZO"))
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ROLE_NAME_PREGUNTA + "." + PreguntaConstants.ATTR_NAME_PREGUNTANUMERO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                            if (STDFunctions.strToIntFun(userFunctionsSrv.fugetValorParametroConfFun("PREGUNTAEMBARAZO")) != null) {
                                comparison1.setSecondOperand(new SQLWhereOperandLiteral(STDFunctions.strToIntFun(userFunctionsSrv.fugetValorParametroConfFun("PREGUNTAEMBARAZO")), Constants.Type.INT.getTypeName()));
                            } else {
                                comparison1.setSecondOperand(new SQLWhereOperandNull());
                                }
                    conjunction.addOperand(comparison1);


            // CuestionarioP.Secciones.Preguntas.RespuestaSiNo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ATTR_NAME_PREGUNTAPRESPUESTASINO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
	@Override
    public Boolean assocOperator010(Usuario instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiario)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
	@Override
    public Boolean assocOperator010Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
	@Override
    public SQLExists assocOperator010Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public Boolean assocOperator011(Usuario instance) throws SystemException {
        try {
            // EXIST (Parentesco)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public Boolean assocOperator011Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLExists assocOperator011Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_PARENTESCO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator012
	@Override
    public Boolean assocOperator012(Usuario instance) throws SystemException {
        try {
            // EXIST (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom) WHERE (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT AND Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco AND Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.EdadMaximaA <> NULL)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator012, Method: assocOperator012";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator012
	@Override
    public Boolean assocOperator012Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
	@Override
    public SQLExists assocOperator012Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getSolicitud().getAesolicitudes().getProductoT().getOid(), UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, instance.getParentesco().getOid(), UsuarioConstants.ROLE_NAME_PARENTESCO);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.EdadMaximaA <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ATTR_NAME_PARENTESCODOMEDADMAXIMAA, Constants.Type.INT.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator013
	@Override
    public Long assocOperator013(Usuario instance) throws SystemException {
        try {
            // SUM (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.EdadMaximaA) WHERE (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT AND Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator013, Method: assocOperator013";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator013
	@Override
    public Long assocOperator013Range1 (Usuario instance) throws SystemException {
        SQLSum sql = assocOperator013Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator013
	@Override
    public SQLSum assocOperator013Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ATTR_NAME_PARENTESCODOMEDADMAXIMAA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getSolicitud().getAesolicitudes().getProductoT().getOid(), UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, instance.getParentesco().getOid(), UsuarioConstants.ROLE_NAME_PARENTESCO);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Boolean assocOperator014(Usuario instance) throws SystemException {
        try {
            // EXIST (Parentesco)
            return assocOperator014Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Boolean assocOperator014Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator014Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLExists assocOperator014Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_PARENTESCO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(Usuario instance) throws SystemException {
        try {
            // EXIST (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom) WHERE (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT AND Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco AND Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.EdadMaximaP <> NULL)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getSolicitud().getAesolicitudes().getProductoT().getOid(), UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, instance.getParentesco().getOid(), UsuarioConstants.ROLE_NAME_PARENTESCO);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.EdadMaximaP <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ATTR_NAME_PARENTESCODOMEDADMAXIMAP, Constants.Type.INT.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Long assocOperator016(Usuario instance) throws SystemException {
        try {
            // SUM (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.EdadMaximaP) WHERE (Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT AND Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco)
            return assocOperator016Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator016
	@Override
    public Long assocOperator016Range1 (Usuario instance) throws SystemException {
        SQLSum sql = assocOperator016Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator016
	@Override
    public SQLSum assocOperator016Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ATTR_NAME_PARENTESCODOMEDADMAXIMAP, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Dominio.ProductoT = Solicitud.Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getSolicitud().getAesolicitudes().getProductoT().getOid(), UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Solicitud.Aesolicitudes.PlanT.Dominios.ParentescosDom.Parentesco = Parentesco
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, instance.getParentesco().getOid(), UsuarioConstants.ROLE_NAME_PARENTESCO);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator017
	@Override
    public Boolean assocOperator017(Usuario instance) throws SystemException {
        try {
            // EXIST (AnexoMat)
            return assocOperator017Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator017, Method: assocOperator017";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator017
	@Override
    public Boolean assocOperator017Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator017Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator017
	@Override
    public SQLExists assocOperator017Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ANEXOMAT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Boolean assocOperator018(Usuario instance) throws SystemException {
        try {
            // EXIST (AnexoNeo)
            return assocOperator018Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Boolean assocOperator018Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator018Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLExists assocOperator018Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ANEXONEO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator019
	@Override
    public Boolean assocOperator019(Usuario instance) throws SystemException {
        try {
            // EXIST (AnexoMat)
            return assocOperator019Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator019, Method: assocOperator019";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator019
	@Override
    public Boolean assocOperator019Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator019Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator019
	@Override
    public SQLExists assocOperator019Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ANEXOMAT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator020
	@Override
    public Boolean assocOperator020(Usuario instance) throws SystemException {
        try {
            // EXIST (AnexoNeo)
            return assocOperator020Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator020, Method: assocOperator020";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator020
	@Override
    public Boolean assocOperator020Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator020Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator020
	@Override
    public SQLExists assocOperator020Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ANEXONEO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator020, Method: assocOperator020Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator021
	@Override
    public Boolean assocOperator021(Usuario instance) throws SystemException {
        try {
            // EXIST (AnexoMat)
            return assocOperator021Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator021, Method: assocOperator021";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator021
	@Override
    public Boolean assocOperator021Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator021Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator021
	@Override
    public SQLExists assocOperator021Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ANEXOMAT, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Boolean assocOperator022(Usuario instance) throws SystemException {
        try {
            // EXIST (AnexoNeo)
            return assocOperator022Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Boolean assocOperator022Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator022Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLExists assocOperator022Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_ANEXONEO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator023
	@Override
    public Boolean assocOperator023(Usuario instance) throws SystemException {
        try {
            // EXIST (Eps) WHERE (Eps.EpsSanitas = true)
            return assocOperator023Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator023, Method: assocOperator023";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator023
	@Override
    public Boolean assocOperator023Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator023Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator023
	@Override
    public SQLExists assocOperator023Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_EPS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Eps.EpsSanitas = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    if (instance.getEps().getEpsEpsSanitas()!= null){
                    comparison1.setFirstOperand(new SQLWhereOperandLiteral(instance.getEps().getEpsEpsSanitas(), Constants.Type.BOOL.getTypeName()));
                    } else {
                    comparison1.setFirstOperand(new SQLWhereOperandNull());
                    }
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator023, Method: assocOperator023Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator024
	@Override
    public Boolean assocOperator024(Usuario instance) throws SystemException {
        try {
            // EXIST (Parentesco)
            return assocOperator024Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator024, Method: assocOperator024";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator024
	@Override
    public Boolean assocOperator024Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator024Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator024
	@Override
    public SQLExists assocOperator024Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_PARENTESCO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Long assocOperator025(Usuario instance) throws SystemException {
        try {
            // COUNT (Solicitud.Usuarios) WHERE (Solicitud.Usuarios.Identificador <> Identificador AND Solicitud.Usuarios.Parentesco.EsTitular = true)
            return assocOperator025Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Long assocOperator025Range1 (Usuario instance) throws SystemException {
        SQLCount sql = assocOperator025Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLCount assocOperator025Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Usuarios.Identificador <> Identificador
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOIDENTIFICADOR, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(instance.getUsuarioIdentificador(), Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Solicitud.Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator026
	@Override
    public Long assocOperator026(Usuario instance) throws SystemException {
        try {
            // COUNT (Solicitud.UsuariosRegistrados) WHERE (Solicitud.UsuariosRegistrados.EstadoBeneficiario.EsActivo = true AND Solicitud.UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator026Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator026
	@Override
    public Long assocOperator026Range1 (Usuario instance) throws SystemException {
        SQLCount sql = assocOperator026Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator026
	@Override
    public SQLCount assocOperator026Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Solicitud.UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator027
	@Override
    public Boolean assocOperator027(Usuario instance) throws SystemException {
        try {
            // EXIST (CuestionarioP)
            return assocOperator027Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator027, Method: assocOperator027";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator027
	@Override
    public Boolean assocOperator027Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator027Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator027
	@Override
    public SQLExists assocOperator027Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_CUESTIONARIOP, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator027, Method: assocOperator027Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Double assocOperator028(Usuario instance) throws SystemException {
        try {
            // SUM (Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Valor) WHERE (Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Tarifa.TipoContrato = Solicitud.tipoContrato AND Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(Solicitud.Aesolicitudes.Fechaasignacion) AND drvEdad >= Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.LimInferiorEdad AND drvEdad <= Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.LimSuperiorEdad)
            return assocOperator028Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator028
	@Override
    public Double assocOperator028Range1 (Usuario instance) throws SystemException {
        SQLSum sql = assocOperator028Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator028
	@Override
    public SQLSum assocOperator028Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ATTR_NAME_DETALLETARIFAVALOR, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Tarifa.TipoContrato = Solicitud.tipoContrato
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ROLE_NAME_TARIFA + "." + TarifaConstants.ATTR_NAME_TARIFATIPOCONTRATO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitud().getSolicitudtipoContrato(), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(Solicitud.Aesolicitudes.Fechaasignacion)
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ATTR_NAME_DETALLETARIFAANYO, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                            if (STDFunctions.getYearFun(instance.getSolicitud().getAesolicitudes().getAesolicitudesFechaasignacion()) != null) {
                                comparison2.setSecondOperand(new SQLWhereOperandLiteral(STDFunctions.getYearFun(instance.getSolicitud().getAesolicitudes().getAesolicitudesFechaasignacion()), Constants.Type.INT.getTypeName()));
                            } else {
                                comparison2.setSecondOperand(new SQLWhereOperandNull());
                                }
                    conjunction.addOperand(comparison2);


            // drvEdad >= Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.LimInferiorEdad
                    // '>=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator(">=");
                    
                    // Operand 1
                    comparison3.setFirstOperand(new SQLWhereOperandLiteral(instance.getUsuariodrvEdad(), Constants.Type.INT.getTypeName()));
                    
                    // Operand 2
                    SQLWhereOperandPathAttribute operand225 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ATTR_NAME_DETALLETARIFALIMINFERIOREDAD, Constants.Type.INT.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    conjunction.addOperand(comparison3);


            // drvEdad <= Solicitud.Aesolicitudes.PlanT.Tarifas.DetallesTarifa.LimSuperiorEdad
                    // '<=' Comparison
                    SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
                    comparison4.setOperator("<=");
                    
                    // Operand 1
                    comparison4.setFirstOperand(new SQLWhereOperandLiteral(instance.getUsuariodrvEdad(), Constants.Type.INT.getTypeName()));
                    
                    // Operand 2
                    SQLWhereOperandPathAttribute operand226 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ATTR_NAME_DETALLETARIFALIMSUPERIOREDAD, Constants.Type.INT.getTypeName());
                    comparison4.setSecondOperand(operand226);
                    conjunction.addOperand(comparison4);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator029
	@Override
    public Boolean assocOperator029(Usuario instance) throws SystemException {
        try {
            // EXIST (UsuarioPersona.Direcciones) WHERE (UsuarioPersona.Direcciones.TipoDireccion = fugetTipoDirResidencial() AND UsuarioPersona.Direcciones.Municipio.EsValidoEPS = false)
            return assocOperator029Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator029, Method: assocOperator029";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator029
	@Override
    public Boolean assocOperator029Range1 (Usuario instance) throws SystemException {
        SQLExists sql = assocOperator029Range1Query(instance);
        return !new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator029
	@Override
    public SQLExists assocOperator029Range1Query (Usuario instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(UsuarioConstants.CLASS_NAME, UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuarioPersona.Direcciones.TipoDireccion = fugetTipoDirResidencial()
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION, TipoDireccionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (userFunctionsSrv.fugetTipoDirResidencialFun() == null ||
                        userFunctionsSrv.fugetTipoDirResidencialFun().isNull())
                    {
                        SQLWhereOperandNull operand = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand);
                    } else {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.UF_NAME_FUGETTIPODIRRESIDENCIAL, TipoDireccionConstants.CLASS_NAME, TipoDireccionConstants.CLASS_NAME, userFunctionsSrv.fugetTipoDirResidencialFun().getOid(), Constants.UF_NAME_FUGETTIPODIRRESIDENCIAL);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // UsuarioPersona.Direcciones.Municipio.EsValidoEPS = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_MUNICIPIO + "." + MunicipioConstants.ATTR_NAME_MUNICIPIOESVALIDOEPS, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Usuario, Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
