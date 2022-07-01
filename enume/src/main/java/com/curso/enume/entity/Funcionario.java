package com.curso.enume.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.curso.enume.enuns.Cargo;
import com.curso.enume.enuns.Uf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="funcionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	@Size(min=3, max=60, message="O nome deverá conter entre 3 e no máximo 50 caracteres para continuar.")
	@Pattern(regexp = "^[A-Z][a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O nome não deve começar com uma letra minúscula, número ou caractere especial.")
	private String nome;
	
//	@Temporal(TemporalType.DATE) 
//	@Column(name="data_entrada")
//	private Date dataEntrada;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name="data_saída")
//	private Date dataSaida;
	
	private String cargo;
	
	@Column(name="matrícula")
	private String matricula;
	
	@Column(name="salário_bruto")
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{3})*,\\d{2}$", message="Digite um salário válido.")
	private String salarioBruto;
	
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="naõ deve conter número ou caractere especial.")
	private String cidade;
	
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="naõ deve conter número ou caractere especial.")
	private String logradouro;
	
	@Column(name="número")
	@Pattern(regexp = "\\d+", message="Somente números válidos no campo.")
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String uf;
	
	@Pattern(regexp = "\\d{5}-\\d{3}", message="deve corresponder ao exemplo: 00000-000")
	private String cep;
	
}
