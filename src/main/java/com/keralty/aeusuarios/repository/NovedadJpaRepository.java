package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Novedad;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadJpaRepository extends JpaRepository<Novedad, Long>, NovedadJpaRepositoryCustom {

    List<Novedad> findByDominios(Dominio dominios);

    List<Novedad> findBySolicitudes(SolicitudNovedad solicitudes);
}
