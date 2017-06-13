package com.heroku.advocacia.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroku.advocacia.model.Cidade;
import com.heroku.advocacia.repository.Cidades;
import com.heroku.advocacia.service.exception.NomeCidadeJaCadastradaException;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Cidade cidade) {
		Optional<Cidade> clienteExistente = cidades.findByNomeAndEstado(cidade.getNome(), cidade.getEstado());
		if (clienteExistente.isPresent()) {
			throw new NomeCidadeJaCadastradaException("Nome da cidade já cadastrado");
		}
		
		cidades.save(cidade);
	}


}
