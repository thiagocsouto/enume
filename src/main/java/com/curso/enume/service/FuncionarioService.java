package com.curso.enume.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.curso.enume.dto.FuncionarioDto;
import com.curso.enume.entity.Funcionario;
import com.curso.enume.exception.NegocioExcpetion;
import com.curso.enume.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario salvarFuncionarios(@RequestBody @Valid FuncionarioDto funcionarioDto) throws Exception {
	
        var existeMatricula = funcionarioRepository.findByMatricula(funcionarioDto.matricula());
        
        if (existeMatricula != null) {
			throw new NegocioExcpetion("Matrícula cadastrada no sistema.");
		}
		
		var funcionario = new Funcionario();
		funcionario.setId(funcionarioDto.id());
		funcionario.setNome(funcionarioDto.nome());
		funcionario.setCargo(funcionarioDto.cargo());
		funcionario.setMatricula(funcionarioDto.matricula());
        funcionario.setSalarioBruto(funcionarioDto.salarioBruto());		
        funcionario.setCidade(funcionarioDto.cidade());
        funcionario.setLogradouro(funcionarioDto.logradouro());
        funcionario.setNumero(funcionarioDto.numero());
        funcionario.setComplemento(funcionarioDto.complemento());
        funcionario.setBairro(funcionarioDto.bairro());
        funcionario.setUf(funcionarioDto.uf());
        funcionario.setCep(funcionarioDto.cep());

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
