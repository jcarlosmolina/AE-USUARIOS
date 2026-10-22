package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogHistoricoPlanesJpaRepository extends JpaRepository<LogHistoricoPlanes, Long>, LogHistoricoPlanesJpaRepositoryCustom {

    List<LogHistoricoPlanes> findByAsesor(Asesor asesor);
}
