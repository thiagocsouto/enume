package com.curso.enume.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.enume.dto.CursoDto;
import com.curso.enume.entity.Curso;
import com.curso.enume.exception.NegocioExcpetion;
import com.curso.enume.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public Curso salvarCurso(@Valid CursoDto cursoDto) {	
		
		var curso = new Curso();
		curso.setId(cursoDto.id());
		curso.setNome(cursoDto.nome());
		curso.setDescricao(cursoDto.descricao());
		curso.setQuantidadeVaga(cursoDto.quantidadeVaga());
		curso.setCargaHoraria(cursoDto.cargaHoraria());
        curso.setValor(cursoDto.valor());
		
		return cursoRepository.save(curso);
	}

	public List<Curso> listarCurso() {
		return cursoRepository.findAll(); 
	}
	
	public Optional<Curso> listarCursoId(@Valid @PathVariable("id") Integer id) throws Exception {
		
		if (id <=0) {
			throw new NegocioExcpetion("Id não pode ser menor ou igual a zero.");
		}
		
		Optional<Curso> cursoid = cursoRepository.findById(id);
		
		if (cursoid.isPresent()) {
			return cursoid;
		}
		throw new NegocioExcpetion("Id não encontrado.");
	}
	
	public void deletarCurso( Integer id ) {
			cursoRepository.deleteById(id);
	}
	
}
