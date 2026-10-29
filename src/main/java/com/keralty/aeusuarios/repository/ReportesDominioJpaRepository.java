package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.ReportesDominioOid;
import com.keralty.aeusuarios.persistence.ReportesDominio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportesDominioJpaRepository extends JpaRepository<ReportesDominio, ReportesDominioOid>, ReportesDominioJpaRepositoryCustom {

    List<ReportesDominio> findByDominio(Dominio dominio);
}
