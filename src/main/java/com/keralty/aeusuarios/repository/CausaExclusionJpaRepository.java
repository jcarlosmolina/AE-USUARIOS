package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.CausaExclusion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CausaExclusionJpaRepository extends JpaRepository<CausaExclusion, Long>, CausaExclusionJpaRepositoryCustom {
}
