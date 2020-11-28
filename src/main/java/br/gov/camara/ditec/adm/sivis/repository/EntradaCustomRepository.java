package br.gov.camara.ditec.adm.sivis.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.gov.camara.ditec.adm.sivis.repository.model.Entrada;
import br.gov.camara.ditec.adm.sivis.service.dto.DestinoDTO;
import br.gov.camara.ditec.adm.sivis.service.dto.PortariaDTO;
import br.gov.camara.ditec.adm.sivis.service.dto.ResultadoPesquisaVisitanteEntradaDTO;
import br.gov.camara.ditec.adm.sivis.service.dto.TipoRestricaoDTO;

@Repository
public interface EntradaCustomRepository {

	PageImpl<Entrada> findAllFilter(Pageable pageable, String nome, String documento, String pontoCadastrador);

	List<ResultadoPesquisaVisitanteEntradaDTO> pesquisarVisitantesEntradas(String nomeVisitante, String numeroDocumentoVisitante,
			TipoRestricaoDTO tipoRestricaoDTO, LocalDate dataEntradaInicial, LocalDate dataEntradaFinal,
			LocalTime horaEntradaInicial, LocalTime horaEntradaFinal, PortariaDTO portariaDTO,
			DestinoDTO destinoDTO, String checkEntradas);
}
