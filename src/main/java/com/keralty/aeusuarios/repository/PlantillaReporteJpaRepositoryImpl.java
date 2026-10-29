package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.PlantillaReporte;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class PlantillaReporteJpaRepositoryImpl extends AbstractRepository implements PlantillaReporteJpaRepositoryCustom {

    @Inject
    public PlantillaReporteJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<PlantillaReporte> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<PlantillaReporte> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<PlantillaReporte> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<PlantillaReporte> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, PlantillaReporte.class);
    }

    @Override	
    public List<PlantillaReporte> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<PlantillaReporte> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
