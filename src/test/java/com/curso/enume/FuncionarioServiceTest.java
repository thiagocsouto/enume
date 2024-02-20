package com.curso.enume;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.enume.dto.FuncionarioDto;
import com.curso.enume.entity.Funcionario;
import com.curso.enume.exception.NegocioExcpetion;
import com.curso.enume.service.FuncionarioService;


@SpringBootTest
public class FuncionarioServiceTest {

	@Autowired  
	private FuncionarioService funcionarioService;  
	
	
	@Test
	void testeSalvarFuncionario() throws Exception {
		FuncionarioDto funcionario = new FuncionarioDto(1, "Thiago Antonio", "Rh", "F005425", "2.000,00", "manaus", "thi", "11", "rua baixo", "lirios", "AM", "69038-050");
		
		Funcionario funcionarioSalvar = funcionarioService.salvarFuncionarios(funcionario);
		
		assertNotNull(funcionarioSalvar);		    
		
	}
	
	@Test 
	void testeIdNaoPodeSerMenorIgualQueZeroAutor(){
		  Exception exception = assertThrows(NegocioExcpetion.class, ()-> funcionarioService.listarFuncionariosId(0)); 

	      Assertions.assertEquals("Id não pode ser menor ou igual a zero.", exception.getMessage());
		
	}
	
}
