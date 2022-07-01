package com.curso.enume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.curso.enume.entity.Curso;
import com.curso.enume.service.FuncionarioService;

@Controller
public class UsuarioController {
	
	
	@GetMapping("/home")
	public ModelAndView index() {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("home/index");
	      return mv;
	}
	      

}
