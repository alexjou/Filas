/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author �?lex
 */
@Entity
public class Senha implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String senha;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horarioChegada;
	private String tipo;
	private boolean atendido = false;
	@Transient
	private static int contadorPrioritario = 1;
	@Transient
	private static int contadorConvencional = 1;

	@OneToOne
	private Pessoa pessoa;


	public int Senha(boolean prioritario){
		if(prioritario == true){
			return contadorPrioritario++;
		}else{
			return contadorConvencional++;
		}
	}
	
	
	public Senha(){
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Calendar getHorarioChegada() {
		return horarioChegada;
	}


	public void setHorarioChegada(Calendar horarioChegada) {
		this.horarioChegada = horarioChegada;
	}


	public static int getContadorPrioritario() {
		return contadorPrioritario;
	}


	public static void setContadorPrioritario(int contadorPrioritario) {
		Senha.contadorPrioritario = contadorPrioritario;
	}


	public static int getContadorConvencional() {
		return contadorConvencional;
	}


	public static void setContadorConvencional(int contadorConvencional) {
		Senha.contadorConvencional = contadorConvencional;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public boolean isAtendido() {
		return atendido;
	}


	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}
	
	
	
}