package com.curso.enume;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.enume.entity.Curso;
import com.curso.enume.exception.NegocioExcpetion;
import com.curso.enume.repository.CursoRepository;
import com.curso.enume.service.CursoService;


@SpringBootTest
public class CursoServiceTest {
	
	@Autowired
	private CursoService cursoService;

	@Mock
	private CursoRepository cursoRepository;
	
	@Test
	void salvarCursoTeste() {
		Curso curso = new Curso("Java", "teste", "10", "160", "200.00");
		when(cursoRepository.save(any(Curso.class))).thenReturn(curso);
		
		Curso salvarCurso = cursoService.salvarCurso(curso);
		
		assertNotNull(salvarCurso);
		
	}
	
	
//	@Test
//	void testeIdNaoEncontradoCurso() throws Exception {
//		   doReturn(Optional.empty()).when(cursoRepository).findById(1);
//
//	        Exception exception = assertThrows(NegocioExcpetion.class, ()-> cursoService.listarCursoId(1)); 
//
//	        Assertions.assertEquals("Id não encontrado.", exception.getMessage());
//	}
	
	@Test
	void testeIdNaoPodeSerMenorIgualQueZeroCurso(){
		  Exception exception = assertThrows(NegocioExcpetion.class, ()-> cursoService.listarCursoId(0)); 

	      Assertions.assertEquals("Id não pode ser menor ou igual a zero.", exception.getMessage());
		
	}
	
//	@Test
//	void testeEncontrarTodosOsIdFuncionario() {
//		Curso curso1 = new Curso("Java", "Um curso bom de programação Java", "10", "160", "200.00");
//		Curso curso2 = new Curso("Html", "Um curso bom de html", "10", "160", "200.00");
//		Curso curso3 = new Curso("Linux", "Um curso bom de linux", "10", "160", "200.00");
//        doReturn(Arrays.asList(curso1, curso2, curso3)).when(cursoRepository).findAll();
//        
//        List<Curso> cursos = cursoService.listarCurso();
//        
//        Assertions.assertEquals(3, cursos.size()); 
//        
//	}	
	
}
