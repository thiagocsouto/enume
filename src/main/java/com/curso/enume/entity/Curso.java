package com.curso.enume.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="curso")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Builder
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	@NotBlank
	@Size(min=3, max=60, message="O nome deve conter entre 3 e no máximo 60 caracteres.")
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O nome não deve começar com número ou caractere especial.")
	private String nome;
	
	@Column(name="descrição")
	@Size( max=200, message="A descrição do curso deve conter no maxímo 200 caracteres.")
	private String descricao;
	 
    @Column(name="quantidade_vagas")
	@Pattern(regexp = "\\d+|", message="Somente números.")
    @NotBlank
	private String quantidadeVaga;
    
    @Column(name="carga_horaria")
	@Pattern(regexp = "\\d+|", message="Somente números.")
    @Size( max=3, message="A Carga horária não pode ultrapassar 999 horas.")
    @NotBlank
	private String cargaHoraria;
    
	@Column(name="valor")
	@NotBlank
	private String valor;

	
}
