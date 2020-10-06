package br.com.dh.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.model.entities.Funcionario;
import br.com.dh.empresa.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public Iterable<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	@PostMapping("/cadastrar")
	public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}
	
	//Reajustar Salario
	@PutMapping("/reajustarsalario/{idFuncionario}")
	public Funcionario reajustarSalarioFuncionario(@PathVariable int idFuncionario, @RequestBody Funcionario dadosFuncionario) throws Exception{
		Funcionario meuFuncionario = funcionarioRepository.findById(idFuncionario)
				.orElseThrow(() -> new IllegalAccessException());
				
		if(dadosFuncionario.getSalario() > 0 && dadosFuncionario.getSalario() != meuFuncionario.getSalario()) {
			meuFuncionario.setSalario(dadosFuncionario.getSalario());
		}
		
		funcionarioRepository.save(meuFuncionario);		
		return meuFuncionario;
		
	}
	
	//Demitir Funcionário
	@GetMapping("/demitir/{idFuncionario}")
	public Funcionario demitirFuncionario(@PathVariable int idFuncionario) throws Exception{
		Funcionario meuFuncionario = funcionarioRepository.findById(idFuncionario)
				.orElseThrow(() -> new IllegalAccessException());
				
		if(meuFuncionario.isHabilitado() == true) {
			meuFuncionario.setHabilitado(false);
		}
		
		funcionarioRepository.save(meuFuncionario);		
		return meuFuncionario;
	}

}
