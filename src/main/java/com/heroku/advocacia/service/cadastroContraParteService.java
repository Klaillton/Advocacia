package com.heroku.advocacia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heroku.advocacia.model.ContraParte;
import com.heroku.advocacia.repository.ContraPartes;
import com.heroku.advocacia.service.exception.CpfCnpjClienteJaCadastradoException;

@Service
public class cadastroContraParteService {
	
	@Autowired
	private ContraPartes contraPartes;
	
	@Transactional
	public void salvar(ContraParte contraParte) {
		Optional<ContraParte> contraParteExistente = contraPartes.findByCpfOuCnpj(contraParte.getCpfOuCnpjSemFormatacao());
		if (contraParteExistente.isPresent()) {
			throw new CpfCnpjClienteJaCadastradoException("CPF/CNPJ já cadastrado");
		}
		
		contraPartes.save(contraParte);
	}

}
