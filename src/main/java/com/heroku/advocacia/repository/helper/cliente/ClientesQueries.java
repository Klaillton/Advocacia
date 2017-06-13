package com.heroku.advocacia.repository.helper.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.heroku.advocacia.model.Cliente;
import com.heroku.advocacia.repository.filter.cliente.ClienteFilter;


public interface ClientesQueries {

	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);
	
}
