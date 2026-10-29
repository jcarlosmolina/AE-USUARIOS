package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalJpaRepository extends JpaRepository<Sucursal, Long>, SucursalJpaRepositoryCustom {

    List<Sucursal> findByAgentes(Funcionario agentes);

    List<Sucursal> findByContratosC(ContratoC contratosC);

    List<Sucursal> findByRegional(Regional regional);
}
