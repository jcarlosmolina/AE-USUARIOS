package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.EstadoBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoBeneficiarioJpaRepository extends JpaRepository<EstadoBeneficiario, Long>, EstadoBeneficiarioJpaRepositoryCustom {
}
