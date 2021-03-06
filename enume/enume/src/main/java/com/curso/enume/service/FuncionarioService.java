package com.curso.enume.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.curso.enume.entity.Funcionario;
import com.curso.enume.exception.NegocioExcpetion;
import com.curso.enume.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario salvarFuncionarios(@RequestBody @Valid Funcionario funcionario) throws Exception {
	
        Funcionario existeMatricula = funcionarioRepository.findByMatricula(funcionario.getMatricula());
        
        if (existeMatricula != null) {
			throw new NegocioExcpetion("Matrícula já cadastrada no sistema.");
		}
		
		return funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> listarFuncionarios() {
		return funcionarioRepository.findAll(); 
	}
	
	public Optional<Funcionario> listarFuncionariosId(@Valid @PathVariable("id") Integer id) throws Exception {
		
		if (id <=0) {
			throw new NegocioExcpetion("Id não pode ser menor ou igual a zero.");
		}
		
		Optional<Funcionario> funcionarioid = funcionarioRepository.findById(id);
		
		if (funcionarioid.isPresent()) {
			return funcionarioid;
		}
		throw new NegocioExcpetion("Id não encontrado.");
		
	}
	
	public void deletarFuncionarios(@PathVariable("id") Integer id) {
			funcionarioRepository.deleteById(id);
		
	}
	

}
