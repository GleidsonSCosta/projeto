package com.projeto.viagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.viagem.entity.Estado;
import com.projeto.viagem.repository.EstadoRepository;

@RestController
@RequestMapping("api/estado")
public class EstadoController {
	private EstadoRepository repository;
	
	@Autowired
	public EstadoController(@RequestBody EstadoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(Estado estado) {
		return repository.save(estado);
	}
	@GetMapping("{id}")
	public Estado acharPorid(@PathVariable Integer id) {
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
