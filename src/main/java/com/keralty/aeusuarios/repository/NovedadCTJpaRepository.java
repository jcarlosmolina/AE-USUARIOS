package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.NovedadCT;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadCTJpaRepository extends JpaRepository<NovedadCT, Long>, NovedadCTJpaRepositoryCustom {

    List<NovedadCT> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<NovedadCT> findByFirma(Firma firma);
}
