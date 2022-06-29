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
	
	private String nome;
	
//	@Temporal(TemporalType.DATE) 
//	@Column(name="data_entrada")
//	private Date dataEntrada;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name="data_saída")
//	private Date dataSaida;
	
	private String cargo;
	
	private String cidade;
	
	private String logradouro;
	
	@Column(name="número")
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String uf;
	
	private String cep;
	
}
