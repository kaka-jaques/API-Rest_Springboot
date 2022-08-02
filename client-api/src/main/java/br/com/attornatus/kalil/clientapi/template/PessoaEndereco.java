package br.com.attornatus.kalil.clientapi.template;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PessoaEndereco {
	
	@Id
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private ArrayList<String> endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getEndereco() {
		return endereco;
	}

	public void setEndereco(ArrayList<String> endereco) {
		this.endereco = endereco;
	}
	
}