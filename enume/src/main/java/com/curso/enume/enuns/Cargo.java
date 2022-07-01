package com.curso.enume.enuns;

public enum Cargo {
	
//	SELECIONE("selecione"), 
	CONTABIL("contabil"),
    ADMINISTRATIVO("administrativo"),
    CONTADOR("contador"),
    PROGRAMDOR("programador"),
    DESENVOLVEDOR("desenvolvedor"),
    RH("rh"),
    PSICOLOGO("psicologo");
	
	private String cargo;
	
	private Cargo(String cargo) {
		this.cargo = cargo;
	}

}
