package com.curso.enume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	@Size(min=3, max=60, message="O nome deverá conter entre 3 e no máximo 50 caracteres para continuar.")
	@Pattern(regexp = "^[A-Z][a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O nome não deve começar com uma letra minúscula, número ou caractere especial.")
	private String nome;
	
	@Column(name="descrição")
//	@Size(min=10, max=200, message="A descrição do curso deverá conter pelo menos 10 para continuar.")
	@NotNull
	private String descricao;
	 
    @Column(name="quantidade_vagas")
	@Pattern(regexp = "\\d+", message="Somente números.")
	private String quantidadeVaga;
    
    @Column(name="carga_horaria")
	@Pattern(regexp = "\\d+", message="Somente números.") 
	private String cargaHoraria;
    
	@Column(name="valor")
	@NotNull
	private String valor;

	public Curso(
			@Size(min = 3, max = 60, message = "O nome deverá conter entre 3 e no máximo 50 caracteres para continuar.") @Pattern(regexp = "^[A-Z][a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message = "O nome não deve começar com uma letra minúscula, número ou caractere especial.") String nome,
			@Size(min = 10, max = 200, message = "A descrição do curso deverá conter pelo menos 10 para continuar.") String descricao,
			@Pattern(regexp = "\\d+", message = "Somente números.") String quantidadeVaga,
			@Pattern(regexp = "\\d+", message = "Somente números.") String cargaHoraria, String valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeVaga = quantidadeVaga;
		this.cargaHoraria = cargaHoraria;
		this.valor = valor;
	} 
	
	
	
}
