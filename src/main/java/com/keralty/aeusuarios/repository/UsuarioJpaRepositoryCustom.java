package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.Usuario;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLGetOne;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLSum;
import java.sql.Date;
import java.util.List;

public interface UsuarioJpaRepositoryCustom {

    List<Usuario> solveQuery(SQLSelect query);
    
    List<Usuario> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextUsuarioIdentificador(Long aesolicitudesidsolicitud);

    Boolean assocOperator000(Usuario instance) throws SystemException;

    Boolean assocOperator000Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator001(Usuario instance) throws SystemException;

    Boolean assocOperator001Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator002(Usuario instance) throws SystemException;

    Boolean assocOperator002Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator003(Usuario instance) throws SystemException;

    Boolean assocOperator003Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator004(Usuario instance) throws SystemException;

    Boolean assocOperator004Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator005(Usuario instance) throws SystemException;

    Boolean assocOperator005Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator005Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator006(Usuario instance) throws SystemException;

    Boolean assocOperator006Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator007(Usuario instance) throws SystemException;

    Boolean assocOperator007Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator007Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator008(Usuario instance) throws SystemException;

    Boolean assocOperator008Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator008Range1Query(Usuario instance) throws SystemException;

    String assocOperator009(Usuario instance) throws SystemException;

    String assocOperator009Range1(Usuario instance) throws SystemException;
    
    SQLGetOne assocOperator009Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator010(Usuario instance) throws SystemException;

    Boolean assocOperator010Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator011(Usuario instance) throws SystemException;

    Boolean assocOperator011Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator012(Usuario instance) throws SystemException;

    Boolean assocOperator012Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(Usuario instance) throws SystemException;

    Long assocOperator013(Usuario instance) throws SystemException;

    Long assocOperator013Range1(Usuario instance) throws SystemException;
    
    SQLSum assocOperator013Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator014(Usuario instance) throws SystemException;

    Boolean assocOperator014Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator015(Usuario instance) throws SystemException;

    Boolean assocOperator015Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(Usuario instance) throws SystemException;

    Long assocOperator016(Usuario instance) throws SystemException;

    Long assocOperator016Range1(Usuario instance) throws SystemException;
    
    SQLSum assocOperator016Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator017(Usuario instance) throws SystemException;

    Boolean assocOperator017Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator017Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator018(Usuario instance) throws SystemException;

    Boolean assocOperator018Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator018Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator019(Usuario instance) throws SystemException;

    Boolean assocOperator019Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator019Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator020(Usuario instance) throws SystemException;

    Boolean assocOperator020Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator020Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator021(Usuario instance) throws SystemException;

    Boolean assocOperator021Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator021Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator022(Usuario instance) throws SystemException;

    Boolean assocOperator022Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator022Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator023(Usuario instance) throws SystemException;

    Boolean assocOperator023Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator023Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator024(Usuario instance) throws SystemException;

    Boolean assocOperator024Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator024Range1Query(Usuario instance) throws SystemException;

    Long assocOperator025(Usuario instance) throws SystemException;

    Long assocOperator025Range1(Usuario instance) throws SystemException;
    
    SQLCount assocOperator025Range1Query(Usuario instance) throws SystemException;

    Long assocOperator026(Usuario instance) throws SystemException;

    Long assocOperator026Range1(Usuario instance) throws SystemException;
    
    SQLCount assocOperator026Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator027(Usuario instance) throws SystemException;

    Boolean assocOperator027Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator027Range1Query(Usuario instance) throws SystemException;

    Double assocOperator028(Usuario instance) throws SystemException;

    Double assocOperator028Range1(Usuario instance) throws SystemException;
    
    SQLSum assocOperator028Range1Query(Usuario instance) throws SystemException;

    Boolean assocOperator029(Usuario instance) throws SystemException;

    Boolean assocOperator029Range1(Usuario instance) throws SystemException;
    
    SQLExists assocOperator029Range1Query(Usuario instance) throws SystemException;

    public List<Usuario> executeQuery(String query);

    public List<Usuario> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
