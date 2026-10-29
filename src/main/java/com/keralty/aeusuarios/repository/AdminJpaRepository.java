package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpaRepository extends JpaRepository<Admin, Long>, AdminJpaRepositoryCustom {
}
