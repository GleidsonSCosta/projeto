package com.projeto.viagem.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.viagem.controller.dto.ViagemDTO;
import com.projeto.viagem.entity.Cliente;
import com.projeto.viagem.entity.Estado;
import com.projeto.viagem.entity.Viagem;
import com.projeto.viagem.repository.ClienteRepository;
import com.projeto.viagem.repository.EstadoRepository;
import com.projeto.viagem.repository.ViagemRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/viagem")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
public class ViagemController {
	
	private final ClienteRepository clienteRepository;
	private final ViagemRepository viagemRepository;
	private final EstadoRepository estadoRepository;
	
	// INSERIR CLIENTE NO BANCO DE DADOS
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Viagem salvar(@RequestBody ViagemDTO dto) {
		
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Integer idCliente = dto.getIdCliente();
		Integer idOrigem = dto.getOrigem();
		Integer idDestino = dto.getDestino();
		
		Cliente cliente = clienteRepository.findById(idCliente)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		
		Estado origem = estadoRepository.findById(idOrigem)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		
		Estado destino = estadoRepository.findById(idDestino)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		
		Viagem viagem = new Viagem();
		viagem.setDataViagem(data);
		viagem.setCliente(cliente);
		viagem.setOrigem(origem);
		viagem.setDestino(destino);

		return viagemRepository.save(viagem);
	}
	
	// BUSCA POR ID DA VIAGEM E RETONA O CLIENTE RESGIATRADO NA VIAGEM
	
	@GetMapping("{id}")
	public Viagem buscarViagem(@PathVariable Integer id){
		return viagemRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	// RETORNA LISTA DE TODAS AS VIAGENS CADASTRADAS NO BANCO

	@GetMapping 
	public List<Viagem> buscarTodasViagens(){
		return viagemRepository.findAll();
	}
	
	// RETORNA LISTA DE VIAGENS DO CLIENTE POR ID
	
	@GetMapping("/cliente/{cliente}")
	public List<Viagem>buscaViagensCliente(@PathVariable Cliente cliente){
		return viagemRepository.findByCliente(cliente);
	}

}
