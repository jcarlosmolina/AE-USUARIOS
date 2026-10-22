package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface RolJpaRepositoryCustom {

    List<Rol> solveQuery(SQLSelect query);
    
    List<Rol> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(Rol instance) throws SystemException;

    Boolean assocOperator000Range1(Rol instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(Rol instance) throws SystemException;

    Boolean assocOperator001(Dominio dominioInsRolDominiopthisDominio) throws SystemException;

    Boolean assocOperator001Range1(Dominio dominioInsRolDominiopthisDominio) throws SystemException;
    
    SQLExists assocOperator001Range1Query(Dominio dominioInsRolDominiopthisDominio, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator002(Dominio dominioDelRollDominiopthisDominio) throws SystemException;

    Boolean assocOperator002Range1(Dominio dominioDelRollDominiopthisDominio) throws SystemException;
    
    SQLExists assocOperator002Range1Query(Dominio dominioDelRollDominiopthisDominio, SQLSelect superQuery) throws SystemException;

    public List<Rol> executeQuery(String query);

    public List<Rol> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
