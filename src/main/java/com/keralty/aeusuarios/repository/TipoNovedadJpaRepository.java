package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.TipoNovedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoNovedadJpaRepository extends JpaRepository<TipoNovedad, Long>, TipoNovedadJpaRepositoryCustom {
}
