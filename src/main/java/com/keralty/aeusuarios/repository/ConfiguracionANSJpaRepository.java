package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.ConfiguracionANS;
import com.keralty.aeusuarios.persistence.Dominio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracionANSJpaRepository extends JpaRepository<ConfiguracionANS, Long>, ConfiguracionANSJpaRepositoryCustom {

    List<ConfiguracionANS> findByDominio(Dominio dominio);
}
