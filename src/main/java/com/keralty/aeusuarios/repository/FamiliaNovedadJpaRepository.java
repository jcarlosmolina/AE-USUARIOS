package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.FamiliaNovedad;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaNovedadJpaRepository extends JpaRepository<FamiliaNovedad, Long>, FamiliaNovedadJpaRepositoryCustom {

    List<FamiliaNovedad> findBySolicitud(SolicitudNovedad solicitud);

    List<FamiliaNovedad> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<FamiliaNovedad> findByFirma(Firma firma);
}
