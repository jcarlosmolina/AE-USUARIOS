package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportesProcAlmJpaRepository extends JpaRepository<ReportesProcAlm, Long>, ReportesProcAlmJpaRepositoryCustom {

    List<ReportesProcAlm> findByFuncionarios(Funcionario funcionarios);
}
