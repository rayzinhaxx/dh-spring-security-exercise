package br.com.dh.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.model.entities.Pedido;
import br.com.dh.empresa.model.repositories.PedidoRepository;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public Iterable<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}
	
	@PostMapping("cadastrar")
	public Pedido addPedido(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
		return pedido;
	}
	
}
