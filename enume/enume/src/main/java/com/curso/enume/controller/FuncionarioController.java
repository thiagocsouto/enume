package com.curso.enume.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.curso.enume.entity.Funcionario;
import com.curso.enume.exception.NegocioExcpetion;
import com.curso.enume.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/listar")
	public ModelAndView listarFuncionario() {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/funcionarios/lista");
	      mv.addObject("listaFuncionarios", funcionarioService.listarFuncionarios());
	      return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarFuncionario(Funcionario funcionario) {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/funcionarios/cadastro");
	      mv.addObject("funcionario", new Funcionario());
	      return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView salvarFuncionario(@Valid Funcionario funcionario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			  mv.setViewName("/administrativo/funcionarios/cadastro");
			  mv.addObject(funcionario);
		      return mv;
		}
			funcionarioService.salvarFuncionarios(funcionario);
			mv.setViewName("redirect:/funcionarios/listar");
			return mv;  
     }
	
	@GetMapping("/editar/{id}") 
	public ModelAndView alterarFuncionario(@PathVariable("id") Integer id) throws Exception {
		 ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/funcionarios/cadastro");
	      Optional<Funcionario> funcionario = funcionarioService.listarFuncionariosId(id);
	      mv.addObject("funcionario", funcionario);
	      return mv;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editarFuncionario(@Valid Funcionario funcionario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			  mv.setViewName("/administrativo/funcionarios/cadastro");
			  mv.addObject(funcionario);
		      return mv;
		}
			funcionarioService.salvarFuncionarios(funcionario);
			mv.setViewName("redirect:/funcionarios/listar");
			return mv;  
     }
	
	@GetMapping("/excluir/{id}")
	public String deletarrFuncionario(@PathVariable("id") Integer id) {
	      funcionarioService.deletarFuncionarios(id);
	      return "redirect:/funcionarios/listar"; 
	}
}
