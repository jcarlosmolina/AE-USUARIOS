package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.GrupoAsociado;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoAsociadoJpaRepository extends JpaRepository<GrupoAsociado, Long>, GrupoAsociadoJpaRepositoryCustom {

    List<GrupoAsociado> findBySolicitudes(Solicitud solicitudes);

    List<GrupoAsociado> findByContratosC(ContratoC contratosC);

    List<GrupoAsociado> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<GrupoAsociado> findByProductoT(Productos productoT);

    List<GrupoAsociado> findByPlanT(Planes planT);
}
