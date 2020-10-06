package br.com.dh.empresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
