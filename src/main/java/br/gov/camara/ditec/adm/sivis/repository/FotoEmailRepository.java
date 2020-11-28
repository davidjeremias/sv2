package br.gov.camara.ditec.adm.sivis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

import br.gov.camara.ditec.adm.sivis.repository.model.FotoEmail;

@Eager
public interface FotoEmailRepository extends JpaRepository<FotoEmail, Integer>{

}
