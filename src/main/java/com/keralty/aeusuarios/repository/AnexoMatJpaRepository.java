package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.AnexoMat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoMatJpaRepository extends JpaRepository<AnexoMat, Long>, AnexoMatJpaRepositoryCustom {
}
