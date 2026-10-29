package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Direccion;
import com.keralty.aeusuarios.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionJpaRepository extends JpaRepository<Direccion, Long>, DireccionJpaRepositoryCustom {

    List<Direccion> findByContrato(Solicitud contrato);
}
