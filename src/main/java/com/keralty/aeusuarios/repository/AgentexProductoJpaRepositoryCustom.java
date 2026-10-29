package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface AgentexProductoJpaRepositoryCustom {

    List<AgentexProducto> solveQuery(SQLSelect query);
    
    List<AgentexProducto> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextAgentexProductoId(Long funcionarioAsesorId);

    Boolean assocOperator000(AgentexProducto instance, Dominio agentexProductoTADDDOMINIOptpevcDominio) throws SystemException;

    Boolean assocOperator000Range1(AgentexProducto instance, Dominio agentexProductoTADDDOMINIOptpevcDominio) throws SystemException;
    
    SQLExists assocOperator000Range1Query(AgentexProducto instance, Dominio agentexProductoTADDDOMINIOptpevcDominio) throws SystemException;

    Long assocOperator001(AgentexProducto instance) throws SystemException;

    Long assocOperator001Range1(AgentexProducto instance) throws SystemException;
    
    SQLCount assocOperator001Range1Query(AgentexProducto instance) throws SystemException;

    Collection<Dominio> assocOperator003(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;

    Collection<Dominio> assocOperator003Range1(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;
    
    SQLPopulation assocOperator003Range1Query(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;

    Collection<Dominio> assocOperator004(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;

    Collection<Dominio> assocOperator004Range1(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;
    
    SQLPopulation assocOperator004Range1Query(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;

    Boolean assocOperator005(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;

    Boolean assocOperator005Range1(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;
    
    SQLExists assocOperator005Range1Query(AgentexProducto instance, String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) throws SystemException;

    public List<AgentexProducto> executeQuery(String query);

    public List<AgentexProducto> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
