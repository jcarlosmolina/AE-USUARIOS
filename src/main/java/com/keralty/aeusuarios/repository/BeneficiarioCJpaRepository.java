package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.BeneficiarioC;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.oid.BeneficiarioCOid;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioCJpaRepository extends JpaRepository<BeneficiarioC, BeneficiarioCOid>, BeneficiarioCJpaRepositoryCustom {

    List<BeneficiarioC> findByContratoC(ContratoC contratoC);
}
