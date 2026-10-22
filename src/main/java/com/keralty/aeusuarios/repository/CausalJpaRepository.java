package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Causal;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CausalJpaRepository extends JpaRepository<Causal, Long>, CausalJpaRepositoryCustom {

    List<Causal> findBySolicitudes(SolicitudNovedad solicitudes);
}
