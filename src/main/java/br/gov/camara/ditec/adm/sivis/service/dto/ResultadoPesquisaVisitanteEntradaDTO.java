package br.gov.camara.ditec.adm.sivis.service.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
public class ResultadoPesquisaVisitanteEntradaDTO {

	// visitantes
	private Integer id;
	private String fotoVisitante;
	private String nomeVisitante;
	private String numeroDocumentoVisitante;
	private String tipoRestricao;
	// Entradas
	private Integer idEntrada;
	private LocalDateTime dataVisita;
	private String dataEntrada;
	private String horaEntrada;
	private String portaria;
	private String destino;

	public ResultadoPesquisaVisitanteEntradaDTO() {
		super();
	}

	public ResultadoPesquisaVisitanteEntradaDTO(Integer idEntrada,Integer id, String nomeVisitante, String numeroDocumentoVisitante, String tipoRestricao, LocalDateTime dataVisita, String portaria,
			String destino) {
		super();
		this.idEntrada = idEntrada;
		this.id = id;
		this.nomeVisitante = nomeVisitante;
		this.numeroDocumentoVisitante = numeroDocumentoVisitante;
		this.tipoRestricao = tipoRestricao;
		this.dataVisita = dataVisita;
		this.portaria = portaria;
		this.destino = destino;
	}
	public ResultadoPesquisaVisitanteEntradaDTO(Integer idEntrada,Integer id, String nomeVisitante, String numeroDocumentoVisitante,  LocalDateTime dataVisita, String portaria,
			String destino) {
		super();
		this.idEntrada = idEntrada;
		this.id = id;
		this.nomeVisitante = nomeVisitante;
		this.numeroDocumentoVisitante = numeroDocumentoVisitante;
		
		this.dataVisita = dataVisita;
		this.portaria = portaria;
		this.destino = destino;
	}

}
