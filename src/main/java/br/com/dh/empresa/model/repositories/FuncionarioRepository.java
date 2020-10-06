package br.com.dh.empresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.model.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{

}
