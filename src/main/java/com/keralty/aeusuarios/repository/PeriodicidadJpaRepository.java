package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Periodicidad;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodicidadJpaRepository extends JpaRepository<Periodicidad, Long>, PeriodicidadJpaRepositoryCustom {

    List<Periodicidad> findByDominios(Dominio dominios);

    List<Periodicidad> findBySolicitudes(Solicitud solicitudes);

    List<Periodicidad> findByContratosC(ContratoC contratosC);

    List<Periodicidad> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Periodicidad> findBySolicitudesNovedadNueva(SolicitudNovedad solicitudesNovedadNueva);
}
