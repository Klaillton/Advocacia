package com.heroku.advocacia.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.heroku.advocacia.model.validation.group.CnpjGroup;
import com.heroku.advocacia.model.validation.group.CpfGroup;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	private String rg;
	
	@NotNull(message = "Tipo pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;

	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@Column(name = "cpf_cnpj")
	private String cpfOuCnpj;
	
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Column(name = "data_nascimento")
//	private Date dataNascimento;
	
	private String paiNome;
	
	
	private String maeNome;
	
	@Embedded
	private Endereco endereco;

	@Column(name="local_nascimento")
	private String localNascimento;
	
	@Embedded
	private Telefone telefones;
	
	private String profissao;
	
	private BigDecimal rendaMensal;
	
	@Email(message = "E-mail inválido")
	private String email;
	
	@PrePersist @PreUpdate
	private void prePersistPreUpdate() {
		this.cpfOuCnpj = TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}

	@PostLoad
	private void postLoad(){
		this.cpfOuCnpj = this.tipoPessoa.formatar(this.cpfOuCnpj);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}



	public String getPaiNome() {
		return paiNome;
	}

	public void setPaiNome(String paiNome) {
		this.paiNome = paiNome;
	}

	public String getMaeNome() {
		return maeNome;
	}

	public void setMaeNome(String maeNome) {
		this.maeNome = maeNome;
	}

	

	public void setTelefones(Telefone telefones) {
		this.telefones = telefones;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
	
	public String getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	

	public Telefone getTelefones() {
		return telefones;
	}
	
	public String getCpfOuCnpjSemFormatacao() {
		return TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
	

}
