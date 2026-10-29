package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.RespRegional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespRegionalJpaRepository extends JpaRepository<RespRegional, Long>, RespRegionalJpaRepositoryCustom {

    List<RespRegional> findByFirma(Firma firma);

    List<RespRegional> findByRegional(Regional regional);
}
