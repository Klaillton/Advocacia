package com.heroku.advocacia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.heroku.advocacia.service.CadastroClienteService;



@Configuration
@ComponentScan(basePackageClasses = {CadastroClienteService.class})
public class ServiceConfig {
	
//	@Bean
//	public FotoStorage fotoStorage(){
//		return new FotoStorageLocal();
//	}

}
