package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.CuestionarioP;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface CuestionarioPJpaRepositoryCustom {

    List<CuestionarioP> solveQuery(SQLSelect query);
    
    List<CuestionarioP> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<CuestionarioP> executeQuery(String query);

    public List<CuestionarioP> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
