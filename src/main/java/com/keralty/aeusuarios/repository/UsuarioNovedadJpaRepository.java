package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.persistence.UsuarioNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioNovedadJpaRepository extends JpaRepository<UsuarioNovedad, Long>, UsuarioNovedadJpaRepositoryCustom {

    List<UsuarioNovedad> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<UsuarioNovedad> findByTipoIdentificacionCD(TipoIdentificacion tipoIdentificacionCD);
}
