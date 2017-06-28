/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Senha;
import com.example.repository.SenhaRepository;

/**
 *
 * @author �?lex
 */
@RestController
public class FilaController {

	@Autowired SenhaRepository senhaRepository;
	
	@GetMapping(path = "/fila")
	public List<Senha> pesquisar(
			@RequestParam(defaultValue = "tipo") String ordenacao1,
	        @RequestParam(defaultValue = "horarioChegada") String ordenacao2,
	        @RequestParam(defaultValue = "ASC") Sort.Direction direcao) {
	  return senhaRepository.findAll(new Sort(direcao, ordenacao1, ordenacao2));
	}
}
