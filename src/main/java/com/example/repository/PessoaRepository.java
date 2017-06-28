package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
