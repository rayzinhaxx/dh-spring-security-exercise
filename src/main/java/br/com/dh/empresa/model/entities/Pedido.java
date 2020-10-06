package br.com.dh.empresa.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	
	@Column(nullable = false)
	private LocalDate dataEmissao;
	@Column(nullable = false)
	private double valorTotal;
	@Column(nullable = false)
	private String statusPedido;

	@OneToOne
	@JoinColumn(name = "fk_id_cliente")
	private Cliente fkIdCliente;
	
	Pedido(){}

	public Pedido(LocalDate dataEmissao, double valorTotal, String statusPedido, Cliente fkIdCliente) {
		super();
		this.dataEmissao = dataEmissao;
		this.valorTotal = valorTotal;
		this.statusPedido = statusPedido;
		this.fkIdCliente = fkIdCliente;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public Cliente getFkIdCliente() {
		return fkIdCliente;
	}

	public void setFkIdCliente(Cliente fkIdCliente) {
		this.fkIdCliente = fkIdCliente;
	}
}
