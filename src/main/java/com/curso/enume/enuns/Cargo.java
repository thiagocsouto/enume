package com.curso.enume.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cargo {
	
	CONTABIL("contabil"),
    ADMINISTRATIVO("administrativo"),
    CONTADOR("contador"),
    PROGRAMDOR("programador"),
    DESENVOLVEDOR("desenvolvedor"),
    RH("rh"),
    PSICOLOGO("psicologo"),
	TI("ti");
	
	private String cargo;

}
