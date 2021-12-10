package com.projeto.viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.viagem.entity.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {

}
