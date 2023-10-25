package com.curso.enume.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public record FuncionarioDto(

		@Positive
		Integer id,
		
		@Column(name="nome")
		@Size(min=3, max=60, message="O nome deve conter entre 3 e no máximo 50 caracteres.")
		@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O nome não deve começar com número ou caractere especial.")
		@NotBlank
		String nome,
		
		@NotBlank
		String cargo,
		
		@Column(name="matrícula")
		@NotBlank
		String matricula,
		
		@Column(name="salário_bruto")
		@Pattern(regexp = "^\\d{1,3}(\\.\\d{3})*,\\d{2}$", message="Digite um salário válido.")
		@NotBlank
		String salarioBruto,
		
		@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="naõ deve conter número ou caractere especial.")
		@NotBlank
		String cidade,
		
		@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="naõ deve conter número ou caractere especial.")
		@NotBlank
		String logradouro,
		
		@Column(name="número")
		@Pattern(regexp = "\\d+", message="Somente números válidos no campo.")
		@NotBlank
		String numero,
		
		String complemento,
		
		String bairro,
		
		String uf,
		
		@Pattern(regexp = "\\d{5}-\\d{3}", message="deve corresponder ao exemplo: 00000-000")
		@NotBlank
		@Size(max=9)
		String cep
		
) {}
