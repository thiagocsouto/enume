package com.curso.enume.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.curso.enume.entity.Curso;
import com.curso.enume.entity.Curso;
import com.curso.enume.service.CursoService;

@Controller 
@RequestMapping("/cursos/")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	

	@GetMapping("/listar")
	public ModelAndView listarCurso() {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/cursos/listaCurso");
	      mv.addObject("listaCursos", cursoService.listarCurso());
	      return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCurso(Curso curso) {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/cursos/cadastroCurso");
	      mv.addObject("curso", new Curso());
	      return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView salvarCurso(@Valid Curso curso, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			  mv.setViewName("/administrativo/cursos/cadastro");
			  mv.addObject(curso);
		      return mv;
		}
			cursoService.salvarCurso(curso);
			mv.setViewName("redirect:/cursos/listar");
			return mv;  
     }
	
	@GetMapping("/editar/{id}") 
	public ModelAndView alterarCurso(@PathVariable("id") Integer id) throws Exception {
		 ModelAndView mv = new ModelAndView();
	      mv.setViewName("/administrativo/cursos/cadastro");
	      Optional<Curso> curso = cursoService.listarCursoId(id);
	      mv.addObject("curso", curso);
	      return mv;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editarCursos(@Valid Curso curso, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			  mv.setViewName("/administrativo/cursos/cadastro");
			  mv.addObject(curso);
		      return mv;
		}
			cursoService.salvarCurso(curso);
			mv.setViewName("redirect:/cursos/listar");
			return mv;  
     }
	
	@GetMapping("/excluir/{id}")
	public String deletarCurso(@PathVariable("id") Integer id) {
	      cursoService.deletarCurso(id);
	      return "redirect:/cursos/listar"; 
	}
	
}
