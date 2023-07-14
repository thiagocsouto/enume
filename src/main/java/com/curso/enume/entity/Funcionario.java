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
@Table(name="funcionario")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Builder
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	@Size(min=3, max=60, message="O nome deve conter entre 3 e no máximo 50 caracteres.")
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O nome não deve começar com número ou caractere especial.")
	@NotBlank
	private String nome;
	
//	@Temporal(TemporalType.DATE) 
//	@Column(name="data_entrada")
//	private Date dataEntrada;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name="data_saída")
//	private Date dataSaida;
	
	@NotBlank
	private String cargo;
	
	@Column(name="matrícula")
	@NotBlank
	private String matricula;
	
	@Column(name="salário_bruto")
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{3})*,\\d{2}$", message="Digite um salário válido.")
	@NotBlank
	private String salarioBruto;
	
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="naõ deve conter número ou caractere especial.")
	@NotBlank
	private String cidade;
	
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="naõ deve conter número ou caractere especial.")
	@NotBlank
	private String logradouro;
	
	@Column(name="número")
	@Pattern(regexp = "\\d+", message="Somente números válidos no campo.")
	@NotBlank
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String uf;
	
	@Pattern(regexp = "\\d{5}-\\d{3}", message="deve corresponder ao exemplo: 00000-000")
	@NotBlank
	@Size(max=9)
	private String cep;
	
}
