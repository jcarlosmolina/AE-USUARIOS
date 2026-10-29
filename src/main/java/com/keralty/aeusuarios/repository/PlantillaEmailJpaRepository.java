package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.PlantillaEmail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantillaEmailJpaRepository extends JpaRepository<PlantillaEmail, Long>, PlantillaEmailJpaRepositoryCustom {

    List<PlantillaEmail> findByDominios(Dominio dominios);
}
