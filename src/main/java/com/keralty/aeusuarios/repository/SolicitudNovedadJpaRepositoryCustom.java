package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLGetOne;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface SolicitudNovedadJpaRepositoryCustom {

    List<SolicitudNovedad> solveQuery(SQLSelect query);
    
    List<SolicitudNovedad> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000() throws SystemException;

    Boolean assocOperator000Range1() throws SystemException;
    
    SQLExists assocOperator000Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator001() throws SystemException;

    Long assocOperator001Range1() throws SystemException;
    
    SQLCount assocOperator001Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator002(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator002Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator003(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator003Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator004(SolicitudNovedad instance) throws SystemException;

    Long assocOperator004Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator004Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator005(SolicitudNovedad instance) throws SystemException;

    Long assocOperator005Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLCount assocOperator005Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator006(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator006Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator007(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator007Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator007Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator008(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator008Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator008Range1Query(SolicitudNovedad instance) throws SystemException;

    String assocOperator009(SolicitudNovedad instance) throws SystemException;

    String assocOperator009Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLGetOne assocOperator009Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator010(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator010Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(SolicitudNovedad instance) throws SystemException;

    String assocOperator011(SolicitudNovedad instance) throws SystemException;

    String assocOperator011Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLGetOne assocOperator011Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator012(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator012Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(SolicitudNovedad instance) throws SystemException;

    String assocOperator013(SolicitudNovedad instance) throws SystemException;

    String assocOperator013Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLGetOne assocOperator013Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator014(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator014Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator015(SolicitudNovedad instance) throws SystemException;

    Boolean assocOperator015Range1(SolicitudNovedad instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(SolicitudNovedad instance) throws SystemException;

    Long assocOperator016(String vfTipoIdent, String vfNumIdent) throws SystemException;

    Long assocOperator016Range1(String vfTipoIdent, String vfNumIdent) throws SystemException;
    
    SQLCount assocOperator016Range1Query(String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException;

    Long assocOperator017(String vfTipoIdent, String vfNumIdent) throws SystemException;

    Long assocOperator017Range1(String vfTipoIdent, String vfNumIdent) throws SystemException;
    
    SQLCount assocOperator017Range1Query(String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException;

    public List<SolicitudNovedad> executeQuery(String query);

    public List<SolicitudNovedad> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
