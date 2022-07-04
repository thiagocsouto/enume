package com.curso.enume;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.curso.enume.entity.Funcionario;
import com.curso.enume.exception.NegocioExcpetion;
import com.curso.enume.repository.FuncionarioRepository;
import com.curso.enume.service.FuncionarioService;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {

	@InjectMocks
	private FuncionarioService funcionarioService;
	
	@Mock
	private FuncionarioRepository funcionarioRepository;
	
	@Test
	void testeSalvarFuncionario() throws Exception {
		Funcionario funcionario = new Funcionario("Thiago Antonio", "RH", "F0054253", "2.000,00", "manaus", "thi", "11", "rua baixo", "lirios", "AM", "69038-050");
		
		when(funcionarioRepository.save(any())).thenReturn(funcionario);
		
		Funcionario funcionarioSalvar = funcionarioService.salvarFuncionarios(funcionario);
		
		assertNotNull(funcionarioSalvar);		
		
	}
	
	@Test
	void testeIdNaoEncontradoFuncionario() throws Exception {
		   doReturn(Optional.empty()).when(funcionarioRepository).findById(1);

	        Exception exception = assertThrows(NegocioExcpetion.class, ()-> funcionarioService.listarFuncionariosId(1)); 

	        Assertions.assertEquals("Id não encontrado.", exception.getMessage());
	}
	
	@Test
	void testeIdNaoPodeSerMenorIgualQueZeroAutor(){
		  Exception exception = assertThrows(NegocioExcpetion.class, ()-> funcionarioService.listarFuncionariosId(0)); 

	      Assertions.assertEquals("Id não pode ser menor ou igual a zero.", exception.getMessage());
		
	}
	
	@Test
	void testeEncontrarTodosOsIdFuncionario() {
		Funcionario funcionario1 = new Funcionario("Thiago Antonio", "RH", "F005453", "2.000,00", "manaus", "thi", "11", "rua baixo", "altos", "AM", "69045-040");
		Funcionario funcionario2 = new Funcionario("Antonio Nunes", "TI", "F0050213", "8.000,00", "manaus", "cloves", "11", "rua manus", "lirios", "AM", "69018-052");
		Funcionario funcionario3 = new Funcionario("Carlos Lucca", "RH", "F0054253", "2.000,00", "manaus", "bweteer", "12", "rua silveira", "redendeção", "AM", "69038-012");
        doReturn(Arrays.asList(funcionario1, funcionario2, funcionario3)).when(funcionarioRepository).findAll();
        
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        
        Assertions.assertEquals(3, funcionarios.size());
        
	}	
	
	@Test
	void testeMatriculaFuncionario() {
		Funcionario funcionario1 = new Funcionario("Thiago Antonio", "RH", "F0050213", "2.000,00", "manaus", "thi", "11", "rua baixo", "altos", "AM", "69045-040");
		Funcionario funcionario2 = new Funcionario("Antonio Nunes", "TI", "F0050213", "8.000,00", "manaus", "cloves", "11", "rua manus", "lirios", "AM", "69018-052");
		
		Exception exception = assertThrows(NegocioExcpetion.class, ()-> funcionarioService.salvarFuncionarios(funcionario1)); 

	      Assertions.assertEquals("Matrícula já cadastrada no sistema.", exception.getMessage());
		
	     
		
	}
	
}
