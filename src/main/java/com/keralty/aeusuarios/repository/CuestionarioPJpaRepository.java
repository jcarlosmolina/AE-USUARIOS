package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.CuestionarioP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuestionarioPJpaRepository extends JpaRepository<CuestionarioP, Long>, CuestionarioPJpaRepositoryCustom {
}
