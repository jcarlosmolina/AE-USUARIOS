package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.PlantillaReporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantillaReporteJpaRepository extends JpaRepository<PlantillaReporte, Long>, PlantillaReporteJpaRepositoryCustom {
}
