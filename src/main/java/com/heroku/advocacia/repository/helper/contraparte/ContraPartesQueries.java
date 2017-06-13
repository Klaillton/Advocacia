package com.heroku.advocacia.repository.helper.contraparte;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.heroku.advocacia.model.ContraParte;
import com.heroku.advocacia.repository.filter.contraparte.ContraParteFilter;

public interface ContraPartesQueries {
	
	public Page<ContraParte> filtrar(ContraParteFilter filtro, Pageable pageable);

}
