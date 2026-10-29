package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.GrupoAsociado;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface GrupoAsociadoJpaRepositoryCustom {

    List<GrupoAsociado> solveQuery(SQLSelect query);
    
    List<GrupoAsociado> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<GrupoAsociado> executeQuery(String query);

    public List<GrupoAsociado> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
