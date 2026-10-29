package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.FrecuenciaAct;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalServicesJpaRepository {

    Collection<Productos> assocOperator001(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException;

    Boolean assocOperator002(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException;

    Collection<Regional> assocOperator025(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException;

    Boolean assocOperator026(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException;

    Collection<Sucursal> assocOperator028(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException;

    Boolean assocOperator029(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException;

    Collection<Sucursal> assocOperator041(Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException;

    Collection<Asesor> assocOperator043(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException;

    Collection<Asesor> assocOperator044(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException;

    Boolean assocOperator045(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException;

    Collection<TipoIdentificacion> assocOperator062(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException;

    Boolean assocOperator063(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException;

    Collection<Sucursal> assocOperator091() throws SystemException;

    Collection<Funcionario> assocOperator092(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException;

    Boolean assocOperator093(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException;

    Collection<Productos> assocOperator097(String tGSINC1AGENTEXPRODpProducto) throws SystemException;

    Boolean assocOperator098(String tGSINC1AGENTEXPRODpProducto) throws SystemException;

    Collection<AgentexProducto> assocOperator100(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException;

    Boolean assocOperator101(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException;

    Collection<Asesor> assocOperator116(String tGPOSPROCESS1ASESORpUsuario) throws SystemException;

    Collection<Asesor> assocOperator117() throws SystemException;

    Boolean assocOperator118() throws SystemException;

    Collection<Asesor> assocOperator119() throws SystemException;

    Boolean assocOperator120() throws SystemException;

    Boolean assocOperator121(String tCREARAGENTEptpatrUsuarioLDAP) throws SystemException;

    Long assocOperator122(String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente) throws SystemException;

    Collection<Funcionario> assocOperator129(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException;

    Long assocOperator130(String tGNEWASESORAGENCIAptpatrUsuarioLDAP) throws SystemException;

    Long assocOperator131(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException;

    Collection<Funcionario> assocOperator132(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException;

    Long assocOperator133(String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor) throws SystemException;

    Long assocOperator134(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException;

    Collection<FrecuenciaAct> assocOperator159(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException;

    Collection<FrecuenciaAct> assocOperator160(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException;

    Collection<FrecuenciaAct> assocOperator161(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException;

    void refreshEntity(Object object);
}
