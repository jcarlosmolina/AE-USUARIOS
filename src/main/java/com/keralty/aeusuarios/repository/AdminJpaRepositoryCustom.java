package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Admin;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface AdminJpaRepositoryCustom {

    List<Admin> solveQuery(SQLSelect query);
    
    List<Admin> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Admin> executeQuery(String query);

    public List<Admin> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
