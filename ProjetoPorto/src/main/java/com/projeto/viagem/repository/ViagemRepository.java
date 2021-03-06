package com.projeto.viagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.viagem.entity.Cliente;
import com.projeto.viagem.entity.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {
	
	List<Viagem> findByCliente(Cliente cliente);
}
