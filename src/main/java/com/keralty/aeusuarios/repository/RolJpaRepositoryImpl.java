package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class RolJpaRepositoryImpl extends AbstractRepository implements RolJpaRepositoryCustom {

    @Inject
    public RolJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Rol> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Rol> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Rol> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Rol> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Rol.class);
    }

    @Override	
    public List<Rol> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<Rol> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000(Rol instance) throws SystemException {
        try {
            // EXIST (Agentes)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Rol, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 (Rol instance) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance);
        return !new TypedQueryBuilder<Rol>(em, Rol.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (Rol instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(RolConstants.CLASS_NAME, RolConstants.ROLE_NAME_AGENTES, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Rol, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Boolean assocOperator001(Dominio dominioInsRolDominiopthisDominio) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios = pthisDominio)
            return assocOperator001Range1(dominioInsRolDominiopthisDominio);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Rol, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator001
	@Override
    public Boolean assocOperator001Range1 (Dominio dominioInsRolDominiopthisDominio) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(dominioInsRolDominiopthisDominio, null);
        return !new TypedQueryBuilder<Rol>(em, Rol.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator001
	@Override
    public SQLExists assocOperator001Range1Query (Dominio dominioInsRolDominiopthisDominio, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, RolConstants.CLASS_NAME, RolConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios = pthisDominio
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(RolConstants.ROLE_NAME_DOMINIOS, DominioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.ARG_NAME_INSROLDOMINIO_DOMINIOINSROLDOMINIOPTHISDOMINIO, DominioConstants.CLASS_NAME, DominioConstants.CLASS_NAME, dominioInsRolDominiopthisDominio.getOid(), DominioConstants.ARG_NAME_INSROLDOMINIO_DOMINIOINSROLDOMINIOPTHISDOMINIO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Rol, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(Dominio dominioDelRollDominiopthisDominio) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios = pthisDominio)
            return assocOperator002Range1(dominioDelRollDominiopthisDominio);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Rol, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (Dominio dominioDelRollDominiopthisDominio) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(dominioDelRollDominiopthisDominio, null);
        return !new TypedQueryBuilder<Rol>(em, Rol.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (Dominio dominioDelRollDominiopthisDominio, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, RolConstants.CLASS_NAME, RolConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios = pthisDominio
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(RolConstants.ROLE_NAME_DOMINIOS, DominioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.ARG_NAME_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPTHISDOMINIO, DominioConstants.CLASS_NAME, DominioConstants.CLASS_NAME, dominioDelRollDominiopthisDominio.getOid(), DominioConstants.ARG_NAME_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPTHISDOMINIO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Rol, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
