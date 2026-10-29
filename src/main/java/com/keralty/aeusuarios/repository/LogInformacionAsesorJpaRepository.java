package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInformacionAsesorJpaRepository extends JpaRepository<LogInformacionAsesor, Long>, LogInformacionAsesorJpaRepositoryCustom {

    List<LogInformacionAsesor> findByAsesor(Asesor asesor);
}
