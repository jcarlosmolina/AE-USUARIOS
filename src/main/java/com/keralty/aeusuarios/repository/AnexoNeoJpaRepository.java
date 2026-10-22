package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.AnexoNeo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoNeoJpaRepository extends JpaRepository<AnexoNeo, Long>, AnexoNeoJpaRepositoryCustom {
}
