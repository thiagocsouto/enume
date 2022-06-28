package com.curso.enume.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.curso.enume.service.CursoService;

@RestController
@RequestMapping("/cursos/")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	
	@GetMapping
	public List<Curso> lista(){
		return cursoService.listarCurso();
	}
	
	@GetMapping("/{id}")
	public Optional<Curso> listaId(@Valid @PathVariable("id") Integer id) throws Exception{
		return cursoService.listarCursoId(id); 
	}
	
	@DeleteMapping("/{id}")
	public void deletarCurso(@PathVariable("id") Integer id) throws Exception{
		cursoService.deletarCurso(id);
	}
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Curso cadastrar(@RequestBody Curso curso) {
        return cursoService.salvarCurso(curso);
    }
}
