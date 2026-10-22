package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface LogFuncionarioJpaRepositoryCustom {

    List<LogFuncionario> solveQuery(SQLSelect query);
    
    List<LogFuncionario> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogFuncionario> executeQuery(String query);

    public List<LogFuncionario> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
