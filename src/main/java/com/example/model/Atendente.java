/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author �?lex
 */
@Entity
public class Atendente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String matricula;
	@OneToOne
	private Banco banco;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
