package com.curso.enume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.enume.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}