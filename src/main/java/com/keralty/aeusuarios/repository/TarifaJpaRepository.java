package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Tarifa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifaJpaRepository extends JpaRepository<Tarifa, Long>, TarifaJpaRepositoryCustom {

    List<Tarifa> findByContratosC(ContratoC contratosC);

    List<Tarifa> findByProductoT(Productos productoT);

    List<Tarifa> findByPlanT(Planes planT);
}
