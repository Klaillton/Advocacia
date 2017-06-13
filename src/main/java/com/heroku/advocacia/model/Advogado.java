package com.heroku.advocacia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Email;

@Embeddable
public class Advogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome_advogado")
	private String nomeAdvogado;
	
	@Email(message = "E-mail inválido")
	@Column(name = "email_advogado")
	private String emailAdvogado;
		
	@Column(name = "telefone_advogado")
	private String telefoneAdvogado;
	
	@Column(name = "celular_advogado")
	private String celularAdvogado;

	public String getNomeAdvogado() {
		return nomeAdvogado;
	}

	public void setNomeAdvogado(String nomeAdvogado) {
		this.nomeAdvogado = nomeAdvogado;
	}

	public String getEmailAdvogado() {
		return emailAdvogado;
	}

	public void setEmailAdvogado(String emailAdvogado) {
		this.emailAdvogado = emailAdvogado;
	}

	public String getTelefoneAdvogado() {
		return telefoneAdvogado;
	}

	public void setTelefoneAdvogado(String telefoneAdvogado) {
		this.telefoneAdvogado = telefoneAdvogado;
	}

	public String getCelularAdvogado() {
		return celularAdvogado;
	}

	public void setCelularAdvogado(String celularAdvogado) {
		this.celularAdvogado = celularAdvogado;
	}	

}
