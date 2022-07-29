package br.com.attornatus.kalil.clientapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.kalil.clientapi.database.PessoaData;
import br.com.attornatus.kalil.clientapi.template.Pessoa;

@RestController
@RequestMapping("/mgr")
public class APIController {
	
	@Autowired
	private PessoaData pessoaData;
	
	@GetMapping
	public List<Pessoa> get() {
		return pessoaData.findAll();
	}
	
	@PostMapping
	public Pessoa post(@RequestBody Pessoa pessoa) {
		return pessoaData.save(pessoa);
	}
	
}
