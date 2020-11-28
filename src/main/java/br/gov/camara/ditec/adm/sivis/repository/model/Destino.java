package br.gov.camara.ditec.adm.sivis.repository.model;

import javax.persistence.*;

import br.gov.camara.ditec.adm.sivis.repository.model.impl.Entidade;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "Destino")
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Destino extends Entidade{

	private static final long serialVersionUID = -7993322746650507586L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ide_destino")
	private Integer id;
	
	@Column(name = "nom_destino")
	private String nomeDestino;
	
	@Column(name = "ind_habilitado")
	private Boolean isHabilitado;

	@Column(name = "sigla_destino")
	private String siglaDestino;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ide_local", nullable = true)
	private Local local;
	
	@Tolerate
	public Destino() {
		super();
	}

}
