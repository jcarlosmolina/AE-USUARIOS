package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsesorJpaRepository extends JpaRepository<Asesor, Long>, AsesorJpaRepositoryCustom {

    List<Asesor> findByContratosC(ContratoC contratosC);

    List<Asesor> findByAgentexProducto(AgentexProducto agentexProducto);

    List<Asesor> findByLogInformacionAsesor(LogInformacionAsesor logInformacionAsesor);

    List<Asesor> findByLogHistoricoPlanes(LogHistoricoPlanes logHistoricoPlanes);

    List<Asesor> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);
}
