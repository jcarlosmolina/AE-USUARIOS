package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.oid.UsuarioRegOid;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.UsuarioReg;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRegJpaRepository extends JpaRepository<UsuarioReg, UsuarioRegOid>, UsuarioRegJpaRepositoryCustom {

    List<UsuarioReg> findBySolicitud(Solicitud solicitud);
}
