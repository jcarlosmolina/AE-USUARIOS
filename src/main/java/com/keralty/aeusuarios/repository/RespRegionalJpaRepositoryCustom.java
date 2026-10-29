package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.RespRegional;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface RespRegionalJpaRepositoryCustom {

    List<RespRegional> solveQuery(SQLSelect query);
    
    List<RespRegional> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    Boolean assocOperator001(RespRegional instance) throws SystemException;

    Boolean assocOperator001Range1(RespRegional instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(RespRegional instance) throws SystemException;

    Boolean assocOperator003(RespRegional instance) throws SystemException;

    Boolean assocOperator003Range1(RespRegional instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(RespRegional instance) throws SystemException;

    public List<RespRegional> executeQuery(String query);

    public List<RespRegional> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
