package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoJpaRepository extends JpaRepository<Departamento, Long>, DepartamentoJpaRepositoryCustom {
}
