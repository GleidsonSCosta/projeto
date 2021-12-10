package com.projeto.viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.viagem.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
