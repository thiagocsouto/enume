package com.curso.enume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
	
	
	@GetMapping("/home")
	public ModelAndView index() {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("home/index");
	      return mv;
	}
	      

}
