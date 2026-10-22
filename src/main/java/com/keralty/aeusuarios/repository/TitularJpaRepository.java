package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.persistence.Titular;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitularJpaRepository extends JpaRepository<Titular, Long>, TitularJpaRepositoryCustom {

    List<Titular> findBySolicitud(Solicitud solicitud);

    List<Titular> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);
}
