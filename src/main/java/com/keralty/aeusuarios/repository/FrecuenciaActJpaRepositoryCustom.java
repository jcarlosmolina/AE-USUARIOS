package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.FrecuenciaAct;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface FrecuenciaActJpaRepositoryCustom {

    List<FrecuenciaAct> solveQuery(SQLSelect query);
    
    List<FrecuenciaAct> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<FrecuenciaAct> executeQuery(String query);

    public List<FrecuenciaAct> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
