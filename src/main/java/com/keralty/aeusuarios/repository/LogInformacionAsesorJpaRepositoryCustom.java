package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface LogInformacionAsesorJpaRepositoryCustom {

    List<LogInformacionAsesor> solveQuery(SQLSelect query);
    
    List<LogInformacionAsesor> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogInformacionAsesor> executeQuery(String query);

    public List<LogInformacionAsesor> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
