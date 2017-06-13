package com.heroku.advocacia.repository.filter.cidade;

import com.heroku.advocacia.model.Estado;

public class CidadeFilter {
	
	private Estado estado;
	
	private String nome;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
