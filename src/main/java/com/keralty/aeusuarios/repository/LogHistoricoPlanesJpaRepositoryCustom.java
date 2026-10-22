package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface LogHistoricoPlanesJpaRepositoryCustom {

    List<LogHistoricoPlanes> solveQuery(SQLSelect query);
    
    List<LogHistoricoPlanes> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogHistoricoPlanes> executeQuery(String query);

    public List<LogHistoricoPlanes> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
