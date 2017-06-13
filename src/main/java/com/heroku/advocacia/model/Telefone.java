package com.heroku.advocacia.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String telefoneFixo;
	
	private String celular1;
	
	private String celular2;
	
	private String telefoneRecado;
	
	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getCelular1() {
		return celular1;
	}

	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	public String getTelefoneRecado() {
		return telefoneRecado;
	}

	public void setTelefoneRecado(String telefoneRecado) {
		this.telefoneRecado = telefoneRecado;
	}
	

}
