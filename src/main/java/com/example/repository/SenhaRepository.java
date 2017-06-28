package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.example.model.Senha;

public interface SenhaRepository extends CrudRepository<Senha, Long>{

	List<Senha> findAll(Sort sort);

}
