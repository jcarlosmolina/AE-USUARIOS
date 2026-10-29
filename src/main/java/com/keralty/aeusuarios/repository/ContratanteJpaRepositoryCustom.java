package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Contratante;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface ContratanteJpaRepositoryCustom {

    List<Contratante> solveQuery(SQLSelect query);
    
    List<Contratante> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Contratante> executeQuery(String query);

    public List<Contratante> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
