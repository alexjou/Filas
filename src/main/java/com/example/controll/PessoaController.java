/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Banco;
import com.example.model.Pessoa;
import com.example.repository.BancoRepository;
import com.example.repository.PessoaRepository;

/**
 *
 * @author �?lex
 */
@RestController
public class PessoaController {
	
	@Autowired PessoaRepository pessoaRepository;
	@Autowired BancoRepository bancoRepository;
	
	// LISTAR UM DETERMINADO PESSOA
	@GetMapping(path = "/listarPessoa/{idPessoa}")
	public Pessoa buscar(@PathVariable Long idPessoa) {		
		return pessoaRepository.findOne(idPessoa);
	}
	
	// LISTAR TODOS OS PESSOAS
	@GetMapping(path = "/listarPessoas")
	public List<Pessoa> listarPessoas() {
		return (List<Pessoa>) pessoaRepository.findAll();
	}

	// CADASTRAR PESSOA
	@PostMapping(path = "/inserirPessoa")
	public @ResponseBody String cadastrarPessoa(
			@RequestBody Pessoa pessoa) {

		pessoaRepository.save(pessoa);

		return "Pessoa inserido";
	}
	
	// DELETAR PESSOA
		@DeleteMapping("/deletarPessoa/{idPessoa}")
		public String deletar(@PathVariable Long idPessoa) {
			
			Pessoa pessoa = pessoaRepository.findOne(idPessoa);
			if (pessoa == null) {
				return "Pessoa não localizada";
			} else {
				pessoaRepository.delete(idPessoa);
				return "Pessoa excluida com sucesso.";
			}
		}
}
