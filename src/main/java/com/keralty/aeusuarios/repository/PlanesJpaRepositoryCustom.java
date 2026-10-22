package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface PlanesJpaRepositoryCustom {

    List<Planes> solveQuery(SQLSelect query);
    
    List<Planes> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Long assocOperator000(Afiliaciones afiliacionesInsPlanpthisAfiliaciones) throws SystemException;

    Long assocOperator000Range1(Afiliaciones afiliacionesInsPlanpthisAfiliaciones) throws SystemException;
    
    SQLCount assocOperator000Range1Query(Afiliaciones afiliacionesInsPlanpthisAfiliaciones, SQLSelect superQuery) throws SystemException;

    Long assocOperator001(Afiliaciones afiliacionesDelPlanpthisAfiliaciones) throws SystemException;

    Long assocOperator001Range1(Afiliaciones afiliacionesDelPlanpthisAfiliaciones) throws SystemException;
    
    SQLCount assocOperator001Range1Query(Afiliaciones afiliacionesDelPlanpthisAfiliaciones, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator006(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto) throws SystemException;

    Boolean assocOperator006Range1(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto) throws SystemException;
    
    SQLExists assocOperator006Range1Query(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator007(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto) throws SystemException;

    Long assocOperator007Range1(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto) throws SystemException;
    
    SQLCount assocOperator007Range1Query(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator008(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto) throws SystemException;

    Long assocOperator008Range1(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto) throws SystemException;
    
    SQLCount assocOperator008Range1Query(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator009(Productos aesolicitudesTINCLUSIONSCptpagrProducto) throws SystemException;

    Boolean assocOperator009Range1(Productos aesolicitudesTINCLUSIONSCptpagrProducto) throws SystemException;
    
    SQLExists assocOperator009Range1Query(Productos aesolicitudesTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator010(Productos aesolicitudesTINCLUSIONSCptpagrProducto) throws SystemException;

    Long assocOperator010Range1(Productos aesolicitudesTINCLUSIONSCptpagrProducto) throws SystemException;
    
    SQLCount assocOperator010Range1Query(Productos aesolicitudesTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator011(Productos aesolicitudesTINCLUSIONSCptpagrProducto) throws SystemException;

    Long assocOperator011Range1(Productos aesolicitudesTINCLUSIONSCptpagrProducto) throws SystemException;
    
    SQLCount assocOperator011Range1Query(Productos aesolicitudesTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator012(Productos solicitudNovedadTCREARptProducto) throws SystemException;

    Boolean assocOperator012Range1(Productos solicitudNovedadTCREARptProducto) throws SystemException;
    
    SQLExists assocOperator012Range1Query(Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator013(Productos solicitudNovedadTCREARptProducto) throws SystemException;

    Long assocOperator013Range1(Productos solicitudNovedadTCREARptProducto) throws SystemException;
    
    SQLCount assocOperator013Range1Query(Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator014(Productos solicitudNovedadTCREARptProducto) throws SystemException;

    Long assocOperator014Range1(Productos solicitudNovedadTCREARptProducto) throws SystemException;
    
    SQLCount assocOperator014Range1Query(Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator015(Productos solicitudNovedadTCREAREXCEPCIONptProducto) throws SystemException;

    Boolean assocOperator015Range1(Productos solicitudNovedadTCREAREXCEPCIONptProducto) throws SystemException;
    
    SQLExists assocOperator015Range1Query(Productos solicitudNovedadTCREAREXCEPCIONptProducto, SQLSelect superQuery) throws SystemException;

    public List<Planes> executeQuery(String query);

    public List<Planes> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
