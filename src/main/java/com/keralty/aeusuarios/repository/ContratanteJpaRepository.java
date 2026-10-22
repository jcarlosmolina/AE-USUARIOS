package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Contratante;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteJpaRepository extends JpaRepository<Contratante, Long>, ContratanteJpaRepositoryCustom {

    List<Contratante> findBySolicitud(Solicitud solicitud);

    List<Contratante> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);
}
