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

    Collection<Asesor> assocOperator110(String tGPOSPROCESS1ASESORpUsuario) throws SystemException;

    Collection<Asesor> assocOperator111() throws SystemException;

    Boolean assocOperator112() throws SystemException;

    Collection<Asesor> assocOperator113() throws SystemException;

    Boolean assocOperator114() throws SystemException;

    Boolean assocOperator115(String tCREARAGENTEptpatrUsuarioLDAP) throws SystemException;

    Long assocOperator116(String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente) throws SystemException;

    Collection<Funcionario> assocOperator123(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException;

    Long assocOperator124(String tGNEWASESORAGENCIAptpatrUsuarioLDAP) throws SystemException;

    Long assocOperator125(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException;

    Collection<Funcionario> assocOperator126(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException;

    Long assocOperator127(String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor) throws SystemException;

    Long assocOperator128(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException;

    Collection<FrecuenciaAct> assocOperator153(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException;

    Collection<FrecuenciaAct> assocOperator154(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException;

    Collection<FrecuenciaAct> assocOperator155(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException;

    void refreshEntity(Object object);
}
