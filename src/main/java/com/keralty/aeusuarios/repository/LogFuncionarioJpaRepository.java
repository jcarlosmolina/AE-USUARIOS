package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogFuncionarioJpaRepository extends JpaRepository<LogFuncionario, Long>, LogFuncionarioJpaRepositoryCustom {

    List<LogFuncionario> findByFuncionario(Funcionario funcionario);
}
