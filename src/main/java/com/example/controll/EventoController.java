/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controll;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Atendente;
import com.example.model.Evento;
import com.example.model.Pessoa;
import com.example.model.Senha;
import com.example.repository.AtendenteRepository;
import com.example.repository.EventoRepository;
import com.example.repository.PessoaRepository;
import com.example.repository.SenhaRepository;

/**
 *
 * @author �?lex
 */
@RestController
public class EventoController {
    
	@Autowired EventoRepository eventoRepository;
	@Autowired PessoaRepository pessoaRepository;
	@Autowired AtendenteRepository atendenteRepository;
	@Autowired SenhaRepository senhaRepository;
	
	// CADASTRAR EVENTO
		@PostMapping(path = "/fazerAtendimento/{idAtendente}/{idPessoa}/{idSenha}")
		public @ResponseBody String atender(
				@PathVariable(name = "idAtendente") Long idAtendente,
				@PathVariable(name = "idPessoa") Long idPessoa,
				@PathVariable(name = "idSenha") Long idSenha,
				@RequestBody Evento evento) {
			
			Pessoa pessoa = pessoaRepository.findOne(idPessoa);
			if (pessoa == null) {
				return "Pessoa não encontrada.";
			}
			
			Atendente atendente = atendenteRepository.findOne(idAtendente);
			if (atendente == null) {
				return "Atendente não encontrado.";
			}

			Senha senha = senhaRepository.findOne(idSenha);
			if (senha == null) {
				return "Senha não confere.";
			}
						
			if (senha.isAtendido() == false) {
				evento.setAtendente(atendente);
				evento.setPessoa(pessoa);
				evento.setHorarioAtendimento(new GregorianCalendar());
				evento.setDescricao(evento.getDescricao());
				eventoRepository.save(evento);
	
				senha.setAtendido(true);
				senhaRepository.save(senha);

				return "Atendido com sucesso";
			} else {
				return "Senha ja atendida.";
			}
		}
	
}
