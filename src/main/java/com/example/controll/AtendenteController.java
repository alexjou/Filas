/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Atendente;
import com.example.model.Banco;
import com.example.repository.AtendenteRepository;
import com.example.repository.BancoRepository;

/**
 *
 * @author �?lex
 */
@RestController
public class AtendenteController {
	
	@Autowired AtendenteRepository atendenteRepository;
	@Autowired BancoRepository bancoRepository;
	
	// LISTAR UM DETERMINADO ATENDENTE
	@GetMapping(path = "/listarAtendente/{idAtendente}")
	public Atendente buscar(@PathVariable Long idAtendente) {		
		return atendenteRepository.findOne(idAtendente);
	}
	
	// LISTAR TODOS OS ATENDENTES
	@GetMapping(path = "/listarAtendentes")
	public List<Atendente> listarAtendentes() {
		
		return (List<Atendente>) atendenteRepository.findAll();
	}

	// CADASTRAR ATENDENTE
	@PostMapping(path = "/inserirAtendente/{idBanco}")
	public @ResponseBody String cadastrarAtendente(
			@PathVariable(name = "idBanco") Long idBanco,
			@RequestBody Atendente atendente) {

		Banco banco = bancoRepository.findOne(idBanco); 
		if (banco == null) {
			return "Banco não encontrado.";
		}
		
		atendente.setBanco(banco);
		
		atendenteRepository.save(atendente);

		return "Atendente inserido";
	}
}
