package br.com.dh.empresa.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCliente;
	
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cpf;
	@Column(nullable=false)
	private String rg;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private LocalDate nascimento;
	
	Cliente(){}

	public Cliente(String nome, String cpf, String rg, String email, LocalDate nascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public int getIdCliente() {
		return IdCliente;
	}
}
