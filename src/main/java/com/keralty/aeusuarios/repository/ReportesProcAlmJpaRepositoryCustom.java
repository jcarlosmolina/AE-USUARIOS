package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface ReportesProcAlmJpaRepositoryCustom {

    List<ReportesProcAlm> solveQuery(SQLSelect query);
    
    List<ReportesProcAlm> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Long assocOperator000() throws SystemException;

    Long assocOperator000Range1() throws SystemException;
    
    SQLCount assocOperator000Range1Query(SQLSelect superQuery) throws SystemException;

    public List<ReportesProcAlm> executeQuery(String query);

    public List<ReportesProcAlm> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
