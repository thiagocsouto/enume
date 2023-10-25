package com.curso.enume.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Builder;

@Builder
public record CursoDto(
	
		@Positive
		Integer id,
		
		@NotBlank
		@Size(min=3, max=60, message="O nome deve conter entre 3 e no máximo 60 caracteres.")
		@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O nome não deve começar com número ou caractere especial.")
		String nome,
		
		@Size( max=200, message="A descrição do curso deve conter no maxímo 200 caracteres.")
		String descricao,
		 
		@Pattern(regexp = "\\d+|", message="Somente números.")
	    @NotBlank
		String quantidadeVaga,
	    
		@Pattern(regexp = "\\d+|", message="Somente números.")
	    @Size( max=3, message="A Carga horária não pode ultrapassar 999 horas.")
	    @NotBlank
		String cargaHoraria,
	    
		@NotBlank
		String valor
		
) {}
