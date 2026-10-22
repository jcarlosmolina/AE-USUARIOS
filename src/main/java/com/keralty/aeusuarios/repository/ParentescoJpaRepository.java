package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentescoJpaRepository extends JpaRepository<Parentesco, Long>, ParentescoJpaRepositoryCustom {
}
