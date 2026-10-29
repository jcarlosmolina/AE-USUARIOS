package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.BeneficiarioC;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLGetOne;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface ContratoCJpaRepositoryCustom {

    List<ContratoC> solveQuery(SQLSelect query);
    
    List<ContratoC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Double assocOperator000(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator000Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator000Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator001(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator001Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator001Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator002(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator002Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator002Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator003(ContratoC instance) throws SystemException;

    Boolean assocOperator003Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator004(ContratoC instance) throws SystemException;

    Boolean assocOperator004Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator005(ContratoC instance) throws SystemException;

    Boolean assocOperator005Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator005Range1Query(ContratoC instance) throws SystemException;

    String assocOperator006(ContratoC instance) throws SystemException;

    String assocOperator006Range1(ContratoC instance) throws SystemException;
    
    SQLGetOne assocOperator006Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator007(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator007Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator007Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator008(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator008Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator008Range1Query(ContratoC instance) throws SystemException;

    public List<ContratoC> executeQuery(String query);

    public List<ContratoC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
