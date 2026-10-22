package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSistemaExternoJpaRepository extends JpaRepository<UsuarioSistemaExterno, String>, UsuarioSistemaExternoJpaRepositoryCustom {
}
