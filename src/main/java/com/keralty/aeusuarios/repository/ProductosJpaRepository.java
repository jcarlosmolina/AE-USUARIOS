package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosJpaRepository extends JpaRepository<Productos, Long>, ProductosJpaRepositoryCustom {

    List<Productos> findByPlanes(Planes planes);

    List<Productos> findByDominios(Dominio dominios);

    List<Productos> findByContratosC(ContratoC contratosC);

    List<Productos> findByAgentexProducto(AgentexProducto agentexProducto);
}
