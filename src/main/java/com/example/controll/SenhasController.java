/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controll;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Pessoa;
import com.example.model.Senha;
import com.example.repository.PessoaRepository;
import com.example.repository.SenhaRepository;

/**
 *
 * @author �?lex
 */
@RestController
public class SenhasController {

	@Autowired SenhaRepository senhaRepository;
	@Autowired PessoaRepository pessoaRepository;
	
	// LISTAR UM DETERMINADO SENHA
	@GetMapping(path = "/listarSenha/{idSenha}")
	public Senha buscar(@PathVariable Long idSenha) {
		return senhaRepository.findOne(idSenha);
	}
	
	// LISTAR TODOS OS SENHAS
	@GetMapping(path = "/listarSenhas")
	public List<Senha> listarSenhas() {
		
		return (List<Senha>) senhaRepository.findAll();
	}

	// CADASTRAR SENHA
	@PostMapping(path = "/inserirSenha/{idPessoa}/{tipo}")
	public @ResponseBody String cadastrarSenha(
			@PathVariable(name = "idPessoa") Long idPessoa,
			@PathVariable(name = "tipo") String tipo,
			@RequestBody Senha senha) {
		
		boolean prioritario = false;
		
		Pessoa pessoa = pessoaRepository.findOne(idPessoa);
		if (pessoa == null) {
			return "Pessoa não encontrada.";
		}
		
		if(tipo.equals("c")){
			prioritario = false;
		} else if (tipo.equals("p")){
			prioritario = true;
		}
		
		senha.setSenha(tipo+senha.Senha(prioritario));
		senha.setHorarioChegada(new GregorianCalendar());
		senha.setPessoa(pessoa);
		senha.setTipo(tipo);
		senhaRepository.save(senha);

		return "Senha gerada";
	}

	// DELETAR SENHA
	@DeleteMapping("/deletarSenha/{idSenha}")
	public String deletar(@PathVariable Long idSenha) {
		
		Senha senha = senhaRepository.findOne(idSenha);
		if (senha == null) {
			return "Senha não localizado";
		} else {
			senhaRepository.delete(idSenha);
			return "Senha excluido com sucesso.";
		}
	}
}
