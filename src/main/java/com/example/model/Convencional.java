/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import javax.persistence.Entity;

/**
 *
 * @author �?lex
 */
@Entity
public class Convencional extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tipoFila;

	public String getTipoFila() {
		return tipoFila;
	}

	public void setTipoFila(String tipoFila) {
		this.tipoFila = tipoFila;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
