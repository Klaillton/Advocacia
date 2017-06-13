package com.heroku.advocacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroku.advocacia.model.Cliente;
import com.heroku.advocacia.repository.helper.cliente.ClientesQueries;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {
	
	public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

	

}
