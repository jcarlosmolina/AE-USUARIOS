package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanesJpaRepository extends JpaRepository<Planes, Long>, PlanesJpaRepositoryCustom {

    List<Planes> findByDominios(Dominio dominios);

    List<Planes> findByContratosC(ContratoC contratosC);

    List<Planes> findByAfiliaciones(Afiliaciones afiliaciones);

    List<Planes> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Planes> findByProductoT(Productos productoT);
}
