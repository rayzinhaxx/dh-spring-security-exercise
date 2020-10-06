package br.com.dh.empresa.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFuncionario;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private double salario;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private boolean habilitado;
	
	public Funcionario(){}

	public Funcionario(String nome, double salario, String email, String senha, boolean habilitado) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.email = email;
		this.senha = senha;
		this.habilitado = habilitado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}
	
}
