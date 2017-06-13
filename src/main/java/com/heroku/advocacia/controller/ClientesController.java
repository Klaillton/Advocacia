package com.heroku.advocacia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.heroku.advocacia.controller.page.PageWrapper;
import com.heroku.advocacia.model.Cliente;
import com.heroku.advocacia.model.TipoPessoa;
import com.heroku.advocacia.repository.Clientes;
import com.heroku.advocacia.repository.Estados;
import com.heroku.advocacia.repository.filter.cliente.ClienteFilter;
import com.heroku.advocacia.service.CadastroClienteService;
import com.heroku.advocacia.service.exception.CpfCnpjClienteJaCadastradoException;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Estados estados;	
	
	@Autowired
	private CadastroClienteService cadastroClienteService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("estados", estados.findAll());
		mv.addObject("tipoPessoa", TipoPessoa.values());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()) {
			return novo(cliente);
		}
		

		try {
			cadastroClienteService.salvar(cliente);
		} catch (CpfCnpjClienteJaCadastradoException e) {
			result.rejectValue("cpfOuCnpj", e.getMessage(), e.getMessage());
			return novo(cliente);
		}
		
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		
		return new ModelAndView("redirect:/clientes/novo");

	}
	
	@GetMapping
	public ModelAndView pesquisar(ClienteFilter clienteFilter, BindingResult result
			, @PageableDefault(size = 3) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cliente/PesquisaCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		
		PageWrapper<Cliente> paginaWrapper = new PageWrapper<>(clientes.filtrar(clienteFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	////////////////////////////////////////
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo, BindingResult result){
		Cliente cliente = clientes.findOne(codigo);
		System.out.println("cliente codigo: "+cliente.getCodigo());
		ModelAndView mv = new ModelAndView("cliente/VisualizarCliente");
		mv.addObject(cliente);
		return mv;
		
	}


}
