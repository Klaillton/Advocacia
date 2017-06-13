package com.heroku.advocacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroku.advocacia.model.ContraParte;
import com.heroku.advocacia.repository.helper.contraparte.ContraPartesQueries;

@Repository
public interface ContraPartes extends JpaRepository<ContraParte, Long>, ContraPartesQueries {
	
	public Optional<ContraParte> findByCpfOuCnpj(String cpfOuCnpj);

}
