package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Parentesco;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface ParentescoJpaRepositoryCustom {

    List<Parentesco> solveQuery(SQLSelect query);
    
    List<Parentesco> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Parentesco> executeQuery(String query);

    public List<Parentesco> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
