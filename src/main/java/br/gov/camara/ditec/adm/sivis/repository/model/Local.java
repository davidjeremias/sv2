package br.gov.camara.ditec.adm.sivis.repository.model;

import br.gov.camara.ditec.adm.sivis.repository.model.impl.Entidade;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@Table(name = "Local")
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Local extends Entidade{

	private static final long serialVersionUID = -7993322746650507586L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ide_local")
	private Integer id;

	@Column(name = "nom_local")
	private String nomeLocal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ide_local_superior")
	private Local localSuperior;

	@Tolerate
	public Local() {
		super();
	}

}
