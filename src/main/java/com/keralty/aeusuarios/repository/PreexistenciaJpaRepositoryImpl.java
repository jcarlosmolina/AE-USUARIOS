package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.global.AesolicitudesConstants;
import com.keralty.aeusuarios.global.PreexistenciaConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.global.UsuarioConstants;
import com.keralty.aeusuarios.persistence.Preexistencia;
import com.keralty.aeusuarios.sqlutils.SQLMax;
import com.keralty.aeusuarios.sqlutils.SQLParam;
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
import org.slf4j.LoggerFactory;

public class PreexistenciaJpaRepositoryImpl extends AbstractRepository implements PreexistenciaJpaRepositoryCustom {

    @Inject
    public PreexistenciaJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Preexistencia> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Preexistencia> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Preexistencia> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Preexistencia> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Preexistencia.class);
    }

    @Override	
    public List<Preexistencia> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<Preexistencia> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public Long nextPreexistenciaIdentificador(Long aesolicitudesidsolicitud, Long usuarioUsuarioIdentificador) {
        try {
            SQLMax sql = new SQLMax(null, PreexistenciaConstants.CLASS_NAME, PreexistenciaConstants.CLASS_NAME + "." + PreexistenciaConstants.ATTR_FIELD_PREEXISTENCIAIDENTIFICADOR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PreexistenciaConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(aesolicitudesidsolicitud, "Autonumerico"));
            conjunction.addComparison(comparison1);

            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(PreexistenciaConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ATTR_FIELD_USUARIOIDENTIFICADOR, "Autonumerico"));
            comparison2.setOperator("=");
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(usuarioUsuarioIdentificador, "Autonumerico"));
            conjunction.addComparison(comparison2);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(Preexistencia.class).error(e.getMessage());
            return 1L;
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
