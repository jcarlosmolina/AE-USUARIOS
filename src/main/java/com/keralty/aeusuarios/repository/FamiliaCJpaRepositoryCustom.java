package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.FamiliaC;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface FamiliaCJpaRepositoryCustom {

    List<FamiliaC> solveQuery(SQLSelect query);
    
    List<FamiliaC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextFamiliaCID(Long contratoCContratoCID);

    public List<FamiliaC> executeQuery(String query);

    public List<FamiliaC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
