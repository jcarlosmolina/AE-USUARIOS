package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpaRepository extends JpaRepository<Rol, Long>, RolJpaRepositoryCustom {

    List<Rol> findByAgentes(Funcionario agentes);

    List<Rol> findByDominios(Dominio dominios);
}
