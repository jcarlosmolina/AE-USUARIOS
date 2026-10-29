package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.oid.PreexistenciaOid;
import com.keralty.aeusuarios.persistence.Preexistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreexistenciaJpaRepository extends JpaRepository<Preexistencia, PreexistenciaOid>, PreexistenciaJpaRepositoryCustom {
}
