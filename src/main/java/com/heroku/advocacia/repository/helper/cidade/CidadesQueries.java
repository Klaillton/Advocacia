package com.heroku.advocacia.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.heroku.advocacia.model.Cidade;
import com.heroku.advocacia.repository.filter.cidade.CidadeFilter;


public interface CidadesQueries {
	

	public Page<Cidade> filtrar(CidadeFilter cidadeFilter, Pageable pageable);

}
