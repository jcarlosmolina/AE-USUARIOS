package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.CausaExclusion;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface CausaExclusionJpaRepositoryCustom {

    List<CausaExclusion> solveQuery(SQLSelect query);
    
    List<CausaExclusion> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<CausaExclusion> executeQuery(String query);

    public List<CausaExclusion> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
