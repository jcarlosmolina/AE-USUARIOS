package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.EstadoContrato;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoContratoJpaRepository extends JpaRepository<EstadoContrato, Long>, EstadoContratoJpaRepositoryCustom {

    List<EstadoContrato> findByContratosC(ContratoC contratosC);

    List<EstadoContrato> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);
}
