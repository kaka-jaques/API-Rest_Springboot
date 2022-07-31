package br.com.attornatus.kalil.clientapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.kalil.clientapi.database.PessoaData;
import br.com.attornatus.kalil.clientapi.template.Pessoa;
import br.com.attornatus.kalil.clientapi.template.PessoaEndereco;

@RestController
@RequestMapping("/mgr")
public class APIController {

	@Autowired
	private PessoaData pessoaData;

	private Pessoa pessoa;

	// LISTAR TODOS OS USUÁRIOS
	@GetMapping(value = "/all")
	public List<Pessoa> getAll() {
		return pessoaData.findAll();
	}

	// ENCONTRAR DADOS DE USUÁRIO POR ID
	@GetMapping(value = "/id/{id}")
	public Optional<Pessoa> getById(@PathVariable Long id) {
		return pessoaData.findById(id);
	}
	
	// EXIBE OS ENDEREÇOS DO USUÁRIO
	@GetMapping(value = "/end/{id}")
	public PessoaEndereco myEnderecos(@PathVariable Long id) {
		
		PessoaEndereco pessoaForm = new PessoaEndereco();
		pessoaForm.setNome(pessoaData.getReferenceById(id).getNome());
		pessoaForm.setEndereco(pessoaData.getReferenceById(id).getEndereco());
		
		return pessoaForm;
	}

	// ADICIONAR TODOS OS DADOS POR JSON
	@PostMapping(value = "/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pessoa post(@RequestBody Pessoa pessoa) {
		return pessoaData.save(pessoa);
	}

	// ATUALIZA ALGUNS DADOS POR JSON
	@PatchMapping(value = "/att/{id}")
	public Pessoa patch(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return pessoaData.save(attForm(id, pessoa));
	}

	// ATUALIZAR TODOS DADOS POR JSON
	@PutMapping(value = "/att/{id}")
	public Pessoa put(@PathVariable Long id, @RequestBody(required = true) Pessoa pessoa) {
		return pessoaData.save(pessoa);
	}
	
	// INSERE QUAL O ENDERECO PRINCIPAL
	@PutMapping(value = "/end/{id}/{enderecoPrincipal}")
	public Pessoa selectEndereco(@PathVariable Long id, @PathVariable byte enderecoPrincipal) {
		pessoaData.getReferenceById(id).setEnderecoPrincipal(enderecoPrincipal);
		return pessoaData.getReferenceById(id);
	}

	// DELETA DADOS DE USUÁRIO POR ID
	@DeleteMapping(value = "/del/{id}")
	public void delete(@PathVariable Long id) {

		System.out.println("DADOS DO USUÁRIO" + pessoaData.getReferenceById(id).getNome() + " DELETADOS COM SUCESSO!");
		pessoaData.deleteById(id);

	}

	// FUNÇÃO PARA ATUALIZAR DADOS PARCIALMENTE (método patch())
	public Pessoa attForm(Long id, Pessoa body) {

		pessoa = pessoaData.getReferenceById(id);

		Pessoa pessoaBody = body;

		if (pessoaBody.getNome() != null)
			pessoa.setNome(pessoaBody.getNome());
		if (pessoaBody.getAniversario() != null)
			pessoa.setAniversario(pessoaBody.getAniversario());
		if (pessoaBody.getEndereco() != null)
			pessoa.setEnderecoString(pessoaBody.getEndereco().toString().replace("[", "").replace("]", ""));
		if (pessoaBody.getEnderecoPrincipal() > 0)
			pessoa.setEnderecoPrincipal(pessoaBody.getEnderecoPrincipal());

		return pessoa;
	}

}
