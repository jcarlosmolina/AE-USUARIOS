package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLMax;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.slf4j.LoggerFactory;

public class AgentexProductoJpaRepositoryImpl extends AbstractRepository implements AgentexProductoJpaRepositoryCustom {

    @Inject
    public AgentexProductoJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<AgentexProducto> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<AgentexProducto> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<AgentexProducto> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<AgentexProducto> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, AgentexProducto.class);
    }

    @Override	
    public List<AgentexProducto> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<AgentexProducto> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public Long nextAgentexProductoId(Long funcionarioAsesorId) {
        try {
            SQLMax sql = new SQLMax(null, AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME + "." + AgentexProductoConstants.ATTR_FIELD_AGENTEXPRODUCTOID);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_ASESOR + "." + AsesorConstants.ATTR_FIELD_FUNCIONARIOID, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(funcionarioAsesorId, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(AgentexProducto.class).error(e.getMessage());
            return 1L;
        }
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000(AgentexProducto instance, Dominio agentexProductoTADDDOMINIOptpevcDominio) throws SystemException {
        try {
            // EXIST (ProductoT.Dominios) WHERE (ProductoT.Dominios = ptpevcDominio)
            return assocOperator000Range1(instance, agentexProductoTADDDOMINIOptpevcDominio);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 (AgentexProducto instance, Dominio agentexProductoTADDDOMINIOptpevcDominio) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance, agentexProductoTADDDOMINIOptpevcDominio);
        return !new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (AgentexProducto instance, Dominio agentexProductoTADDDOMINIOptpevcDominio) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ProductoT.Dominios = ptpevcDominio
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(AgentexProductoConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, DominioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AgentexProductoConstants.ARG_NAME_TADDDOMINIO_AGENTEXPRODUCTOTADDDOMINIOPTPEVCDOMINIO, DominioConstants.CLASS_NAME, DominioConstants.CLASS_NAME, agentexProductoTADDDOMINIOptpevcDominio.getOid(), AgentexProductoConstants.ARG_NAME_TADDDOMINIO_AGENTEXPRODUCTOTADDDOMINIOPTPEVCDOMINIO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Long assocOperator001(AgentexProducto instance) throws SystemException {
        try {
            // COUNT (Dominios)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Long assocOperator001Range1 (AgentexProducto instance) throws SystemException {
        SQLCount sql = assocOperator001Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLCount assocOperator001Range1Query (AgentexProducto instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.ROLE_NAME_DOMINIOS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Collection<Dominio> assocOperator003(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {
        try {
            // FOR ALL ProductoT.Dominios WHERE (ProductoT.Dominios.PlanT.CodigoLegal = ptCodLegalPlan) DO TADDDOMINIO(this, ProductoT.Dominios)
        return assocOperator003Range1(instance, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Collection<Dominio> assocOperator003Range1 (AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {

        SQLSelect sql = assocOperator003Range1Query(instance, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan);
        return new TypedQueryBuilder<Dominio>(em, Dominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLPopulation assocOperator003Range1Query (AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(AgentexProductoConstants.CLASS_NAME, DominioConstants.CLASS_NAME, instance.getOid(), AgentexProductoConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ProductoT.Dominios.PlanT.CodigoLegal = ptCodLegalPlan
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ATTR_NAME_PLANESCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(agentexProductoTCARGARDOMINIOPLANptCodLegalPlan, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Collection<Dominio> assocOperator004(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {
        try {
            // FOR ALL Dominios WHERE (Dominios.PlanT.CodigoLegal = ptCodLegalPlan) DO TDELDOMINIO(this, Dominios)
        return assocOperator004Range1(instance, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Collection<Dominio> assocOperator004Range1 (AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {

        SQLSelect sql = assocOperator004Range1Query(instance, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan);
        return new TypedQueryBuilder<Dominio>(em, Dominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLPopulation assocOperator004Range1Query (AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(AgentexProductoConstants.CLASS_NAME, DominioConstants.CLASS_NAME, instance.getOid(), AgentexProductoConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.PlanT.CodigoLegal = ptCodLegalPlan
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ATTR_NAME_PLANESCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(agentexProductoTCARGARDOMINIOPLANptCodLegalPlan, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Boolean assocOperator005(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios.PlanT.CodigoLegal = ptCodLegalPlan)
            return assocOperator005Range1(instance, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Boolean assocOperator005Range1 (AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(instance, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan);
        return !new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLExists assocOperator005Range1Query (AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.PlanT.CodigoLegal = ptCodLegalPlan
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ATTR_NAME_PLANESCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(agentexProductoTCARGARDOMINIOPLANptCodLegalPlan, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: AgentexProducto, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
