package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoAsignacionJpaRepository extends JpaRepository<GrupoAsignacion, Long>, GrupoAsignacionJpaRepositoryCustom {

    List<GrupoAsignacion> findByDominioAsesores(Dominio dominioAsesores);

    List<GrupoAsignacion> findByDominioAreaMedica(Dominio dominioAreaMedica);

    List<GrupoAsignacion> findByFuncionario(Funcionario funcionario);
}
