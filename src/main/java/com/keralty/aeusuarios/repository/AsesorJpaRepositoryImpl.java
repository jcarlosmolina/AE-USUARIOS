package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.LogInformacionAsesorConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLJoin;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class AsesorJpaRepositoryImpl extends AbstractRepository implements AsesorJpaRepositoryCustom {

    @Inject
    public AsesorJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Asesor> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Asesor> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Asesor> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Asesor> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Asesor.class);
    }

    @Override	
    public List<Asesor> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<Asesor> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public Funcionario findParent(Long oid) {
        return em.find(Funcionario.class, oid);
    }

    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param parentAlias Alias of the parent entity.
     */
    public void addFacetWhereparentfuncionario (String myAlias, SQLJoin join, String parentAlias) {
        join.addWhere(myAlias + "." + AsesorConstants.FLD_FUNCIONARIOID + " = " + parentAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID);
    }

    // AssocOperator: AssocOperator000
	@Override
    public Long assocOperator000(Asesor instance) throws SystemException {
        try {
            // COUNT (Solicitudes)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Long assocOperator000Range1 (Asesor instance) throws SystemException {
        SQLCount sql = assocOperator000Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLCount assocOperator000Range1Query (Asesor instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(AsesorConstants.CLASS_NAME, AsesorConstants.ROLE_NAME_SOLICITUDES, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(Asesor instance) throws SystemException {
        try {
            // EXIST (TipoIdentificacion)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (Asesor instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (Asesor instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(AsesorConstants.CLASS_NAME, AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Boolean assocOperator004(Asesor instance) throws SystemException {
        try {
            // EXIST (TipoIdentificacion)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Boolean assocOperator004Range1 (Asesor instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLExists assocOperator004Range1Query (Asesor instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(AsesorConstants.CLASS_NAME, AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Collection<AgentexProducto> assocOperator005(Asesor instance) throws SystemException {
        try {
            // FOR ALL AgentexProducto DO AgentexProducto.eliminar(AgentexProducto)
        return assocOperator005Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Collection<AgentexProducto> assocOperator005Range1 (Asesor instance) throws SystemException {

        SQLSelect sql = assocOperator005Range1Query(instance);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLPopulation assocOperator005Range1Query (Asesor instance) throws SystemException {
        try {
            return new SQLPopulation(AsesorConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, instance.getOid(), AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Collection<LogInformacionAsesor> assocOperator006(Asesor instance) throws SystemException {
        try {
            // FOR ALL LogInformacionAsesor DO LogInformacionAsesor.eliminar(LogInformacionAsesor)
        return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Collection<LogInformacionAsesor> assocOperator006Range1 (Asesor instance) throws SystemException {

        SQLSelect sql = assocOperator006Range1Query(instance);
        return new TypedQueryBuilder<LogInformacionAsesor>(em, LogInformacionAsesor.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLPopulation assocOperator006Range1Query (Asesor instance) throws SystemException {
        try {
            return new SQLPopulation(AsesorConstants.CLASS_NAME, LogInformacionAsesorConstants.CLASS_NAME, instance.getOid(), AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Collection<AgentexProducto> assocOperator007(Asesor instance, String asesorTCARGARDOMINIOPLANptCodLegalProducto) throws SystemException {
        try {
            // FOR ALL AgentexProducto WHERE (AgentexProducto.ProductoT.CodigoLegal = ptCodLegalProducto) DO AgentexProducto.TCARGARDOMINIOPLAN(AgentexProducto, ptCodLegalPlan, ptAccion)
        return assocOperator007Range1(instance, asesorTCARGARDOMINIOPLANptCodLegalProducto);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Collection<AgentexProducto> assocOperator007Range1 (Asesor instance, String asesorTCARGARDOMINIOPLANptCodLegalProducto) throws SystemException {

        SQLSelect sql = assocOperator007Range1Query(instance, asesorTCARGARDOMINIOPLANptCodLegalProducto);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLPopulation assocOperator007Range1Query (Asesor instance, String asesorTCARGARDOMINIOPLANptCodLegalProducto) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(AsesorConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, instance.getOid(), AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.ProductoT.CodigoLegal = ptCodLegalProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(asesorTCARGARDOMINIOPLANptCodLegalProducto, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Asesor, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
