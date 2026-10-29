package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.DireccionC;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface DireccionCJpaRepositoryCustom {

    List<DireccionC> solveQuery(SQLSelect query);
    
    List<DireccionC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(DireccionC instance) throws SystemException;

    Boolean assocOperator000Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator001(DireccionC instance) throws SystemException;

    Boolean assocOperator001Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(DireccionC instance) throws SystemException;

    public List<DireccionC> executeQuery(String query);

    public List<DireccionC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
