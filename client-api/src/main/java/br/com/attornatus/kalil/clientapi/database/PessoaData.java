package br.com.attornatus.kalil.clientapi.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.kalil.clientapi.template.Pessoa;

@Repository
public interface PessoaData extends JpaRepository<Pessoa, Long> {
	
	
	
}
