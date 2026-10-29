package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.repository.AnexoMatJpaRepository;
import com.keralty.aeusuarios.repository.AnexoNeoJpaRepository;
import com.keralty.aeusuarios.repository.BeneficiarioCJpaRepository;
import com.keralty.aeusuarios.repository.ConfiguracionANSJpaRepository;
import com.keralty.aeusuarios.repository.DireccionCJpaRepository;
import com.keralty.aeusuarios.repository.FamiliaNovedadJpaRepository;
import com.keralty.aeusuarios.repository.NovedadJpaRepository;
import com.keralty.aeusuarios.repository.PersonaCJpaRepository;
import com.keralty.aeusuarios.repository.PersonaJpaRepository;
import com.keralty.aeusuarios.repository.ReportesDominioJpaRepository;
import com.keralty.aeusuarios.repository.UsuarioJpaRepository;
import com.keralty.aeusuarios.repository.UsuarioNovedadJpaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class GenericService {

    private PersonaJpaRepository personaJpaRepository;

    private PersonaCJpaRepository personaCJpaRepository;

    private DireccionCJpaRepository direccionCJpaRepository;

    private UsuarioJpaRepository usuarioJpaRepository;

    private AnexoMatJpaRepository anexoMatJpaRepository;

    private AnexoNeoJpaRepository anexoNeoJpaRepository;

    private BeneficiarioCJpaRepository beneficiarioCJpaRepository;

    private NovedadJpaRepository novedadJpaRepository;

    private FamiliaNovedadJpaRepository familiaNovedadJpaRepository;

    private UsuarioNovedadJpaRepository usuarioNovedadJpaRepository;

    private ConfiguracionANSJpaRepository configuracionANSJpaRepository;

    private ReportesDominioJpaRepository reportesDominioJpaRepository;
	
	@Inject
	public GenericService(
            PersonaJpaRepository personaJpaRepository,
            PersonaCJpaRepository personaCJpaRepository,
            DireccionCJpaRepository direccionCJpaRepository,
            UsuarioJpaRepository usuarioJpaRepository,
            AnexoMatJpaRepository anexoMatJpaRepository,
            AnexoNeoJpaRepository anexoNeoJpaRepository,
            BeneficiarioCJpaRepository beneficiarioCJpaRepository,
            NovedadJpaRepository novedadJpaRepository,
            FamiliaNovedadJpaRepository familiaNovedadJpaRepository,
            UsuarioNovedadJpaRepository usuarioNovedadJpaRepository,
            ConfiguracionANSJpaRepository configuracionANSJpaRepository,
            ReportesDominioJpaRepository reportesDominioJpaRepository
			) {
        this.personaJpaRepository = personaJpaRepository;
        this.personaCJpaRepository = personaCJpaRepository;
        this.direccionCJpaRepository = direccionCJpaRepository;
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.anexoMatJpaRepository = anexoMatJpaRepository;
        this.anexoNeoJpaRepository = anexoNeoJpaRepository;
        this.beneficiarioCJpaRepository = beneficiarioCJpaRepository;
        this.novedadJpaRepository = novedadJpaRepository;
        this.familiaNovedadJpaRepository = familiaNovedadJpaRepository;
        this.usuarioNovedadJpaRepository = usuarioNovedadJpaRepository;
        this.configuracionANSJpaRepository = configuracionANSJpaRepository;
        this.reportesDominioJpaRepository = reportesDominioJpaRepository;
	}

	public PersonaJpaRepository getPersonaJpaRepository() {
		return this.personaJpaRepository;
	}
	public PersonaCJpaRepository getPersonaCJpaRepository() {
		return this.personaCJpaRepository;
	}
	public DireccionCJpaRepository getDireccionCJpaRepository() {
		return this.direccionCJpaRepository;
	}
	public UsuarioJpaRepository getUsuarioJpaRepository() {
		return this.usuarioJpaRepository;
	}
	public AnexoMatJpaRepository getAnexoMatJpaRepository() {
		return this.anexoMatJpaRepository;
	}
	public AnexoNeoJpaRepository getAnexoNeoJpaRepository() {
		return this.anexoNeoJpaRepository;
	}
	public BeneficiarioCJpaRepository getBeneficiarioCJpaRepository() {
		return this.beneficiarioCJpaRepository;
	}
	public NovedadJpaRepository getNovedadJpaRepository() {
		return this.novedadJpaRepository;
	}
	public FamiliaNovedadJpaRepository getFamiliaNovedadJpaRepository() {
		return this.familiaNovedadJpaRepository;
	}
	public UsuarioNovedadJpaRepository getUsuarioNovedadJpaRepository() {
		return this.usuarioNovedadJpaRepository;
	}
	public ConfiguracionANSJpaRepository getConfiguracionANSJpaRepository() {
		return this.configuracionANSJpaRepository;
	}
	public ReportesDominioJpaRepository getReportesDominioJpaRepository() {
		return this.reportesDominioJpaRepository;
	}
}
