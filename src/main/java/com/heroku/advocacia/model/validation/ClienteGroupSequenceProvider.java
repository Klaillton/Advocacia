package com.heroku.advocacia.model.validation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.heroku.advocacia.model.Cliente;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente> {

	@Override
	public List<Class<?>> getValidationGroups(Cliente cliente) {
		List<Class<?>> grupos = new ArrayList<>();
		grupos.add(Cliente.class);
		
		if(isPessoaSelecionada(cliente)) {
			grupos.add(cliente.getTipoPessoa().getGrupo());
		}
		
		
		return grupos;
	}

	private boolean isPessoaSelecionada(Cliente cliente) {
		return cliente != null && cliente.getTipoPessoa() != null;
	}

}
