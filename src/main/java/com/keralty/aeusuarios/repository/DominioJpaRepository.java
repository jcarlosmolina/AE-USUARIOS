package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DominioJpaRepository extends JpaRepository<Dominio, Long>, DominioJpaRepositoryCustom {

    List<Dominio> findByDominiosConIncompatibilidad(Dominio dominiosConIncompatibilidad);

    List<Dominio> findByAgentexProducto(AgentexProducto agentexProducto);

    List<Dominio> findByPlanT(Planes planT);

    List<Dominio> findByProductoT(Productos productoT);

    List<Dominio> findByRoles(Rol roles);

    List<Dominio> findByGrupoAsesores(GrupoAsignacion grupoAsesores);

    List<Dominio> findByGrupoAreaMedica(GrupoAsignacion grupoAreaMedica);

    List<Dominio> findByDominiosIncompatibles(Dominio dominiosIncompatibles);
}
