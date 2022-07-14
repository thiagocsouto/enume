package com.curso.enume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.enume.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	Funcionario findByMatricula(String matricula);

}
