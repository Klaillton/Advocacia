package com.heroku.advocacia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.heroku.advocacia.controller.page.PageWrapper;
import com.heroku.advocacia.model.ContraParte;
import com.heroku.advocacia.model.TipoPessoa;
import com.heroku.advocacia.repository.ContraPartes;
import com.heroku.advocacia.repository.Estados;
import com.heroku.advocacia.repository.filter.contraparte.ContraParteFilter;
import com.heroku.advocacia.service.cadastroContraParteService;
import com.heroku.advocacia.service.exception.CpfCnpjClienteJaCadastradoException;

@Controller
@RequestMapping("/contrapartes")
public class ContraParteController {
	
	@Autowired
	private Estados estados;
	
	@Autowired
	private ContraPartes contraPartes;
	
	@Autowired
	private cadastroContraParteService cadastroContraParteService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(ContraParte contraParte) {
		ModelAndView mv = new ModelAndView("contraparte/CadastroContraParte");
		mv.addObject("estados", estados.findAll());
		mv.addObject("tipoPessoa", TipoPessoa.values());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid ContraParte contraParte, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()) {
			return novo(contraParte);
		}
		

		try {
			cadastroContraParteService.salvar(contraParte);
		} catch (CpfCnpjClienteJaCadastradoException e) {
			result.rejectValue("cpfOuCnpj", e.getMessage(), e.getMessage());
			return novo(contraParte);
		}
		
		attributes.addFlashAttribute("mensagem", "ContraParte salvo com sucesso!");
		
		return new ModelAndView("redirect:/contrapartes/novo");

	}
	
	@GetMapping
	public ModelAndView pesquisar(ContraParteFilter contraParteFilter, BindingResult result
			, @PageableDefault(size = 3) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("contraparte/PesquisaContraParte");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		
		PageWrapper<ContraParte> paginaWrapper = new PageWrapper<>(contraPartes.filtrar(contraParteFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}

}
