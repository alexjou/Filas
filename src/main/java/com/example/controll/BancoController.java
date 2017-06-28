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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Banco;
import com.example.repository.BancoRepository;

/**
 *
 * @author �?lex
 */
@RestController
public class BancoController {

	@Autowired
	BancoRepository bancoRepository;
	
	// LISTAR UM DETERMINADO BANCO
	@GetMapping(path = "/listarBanco/{idBanco}")
	public Banco buscar(@PathVariable Long idBanco) {
		return bancoRepository.findOne(idBanco);
	}
	
	// LISTAR TODOS OS BANCOS
	@GetMapping(path = "/listarBancos")
	public List<Banco> listarBancos() {
		
		return (List<Banco>) bancoRepository.findAll();
	}

	// CADASTRAR BANCO
	@PostMapping(path = "/inserirBanco")
	public @ResponseBody String cadastrarBanco(@RequestBody Banco banco) {

		bancoRepository.save(banco);

		return "Banco inserido";
	}
	
	// EDITAR BANCO
	@PutMapping(path = "/editarBanco/{idBanco}")
	public @ResponseBody String editarBanco(@PathVariable(name = "idBanco") Long idBanco,
			@RequestBody Banco banco) {
		
		Banco bancoSelecionado = bancoRepository.findOne(idBanco);
		if (bancoSelecionado == null) {
			return "Banco não encontrado.";
		}
		
		bancoSelecionado.setNome(banco.getNome());
		bancoSelecionado.setEndereco(banco.getEndereco());
		
		bancoRepository.save(bancoSelecionado);
		
		return "Banco editado com sucesso";
	}

	// DELETAR BANCO
	@DeleteMapping("/deletarBanco/{idBanco}")
	public String deletar(@PathVariable Long idBanco) {
		
		Banco banco = bancoRepository.findOne(idBanco);
		if (banco == null) {
			return "Banco não localizado";
		} else {
			bancoRepository.delete(idBanco);
			return "Banco excluido com sucesso.";
		}
	}
}
