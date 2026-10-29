package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoCJpaRepository extends JpaRepository<ContratoC, Long>, ContratoCJpaRepositoryCustom {

    List<ContratoC> findBySolicitud(Solicitud solicitud);

    List<ContratoC> findByProductoC(Productos productoC);

    List<ContratoC> findByPlanC(Planes planC);

    List<ContratoC> findBySucursalC(Sucursal sucursalC);

    List<ContratoC> findByAsesorC(Asesor asesorC);
}
