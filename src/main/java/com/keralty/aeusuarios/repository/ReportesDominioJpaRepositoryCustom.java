package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.ReportesDominio;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLMin;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.sql.Date;
import java.util.List;

public interface ReportesDominioJpaRepositoryCustom {

    List<ReportesDominio> solveQuery(SQLSelect query);
    
    List<ReportesDominio> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Long assocOperator000(ReportesDominio instance) throws SystemException;

    Long assocOperator000Range1(ReportesDominio instance) throws SystemException;
    
    SQLCount assocOperator000Range1Query(ReportesDominio instance) throws SystemException;

    Date assocOperator001(ReportesDominio instance) throws SystemException;

    Date assocOperator001Range1(ReportesDominio instance) throws SystemException;
    
    SQLMin assocOperator001Range1Query(ReportesDominio instance) throws SystemException;

    public List<ReportesDominio> executeQuery(String query);

    public List<ReportesDominio> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
