package com.curso.enume.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.curso.enume.entity.Funcionario;
import com.curso.enume.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarFuncionario(Funcionario funcionario) {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/funcionarios/cadastro");
	      mv.addObject("funcionario", funcionario);
	      return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarFuncionario() {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/funcionarios/lista");
	      mv.addObject("listaFuncionarios", funcionarioService.listarFuncionarios());
	      return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarFuncionario(@Valid Funcionario funcionario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			  mv.setViewName("/administrativo/funcionarios/lista");
		      
		      return mv;
		}
		
		funcionarioService.salvarFuncionarios(funcionario);
		mv.setViewName("redirect:/funcionarios/listar");
		mv.addObject("funcionario", new Funcionario());
		return mv; 
	}
 
	
}
