package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.FrecuenciaAct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrecuenciaActJpaRepository extends JpaRepository<FrecuenciaAct, Long>, FrecuenciaActJpaRepositoryCustom {
}
