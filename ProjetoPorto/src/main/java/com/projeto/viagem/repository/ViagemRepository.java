package com.projeto.viagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.viagem.entity.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {

//	@Query (value = "select c.nome, v.data_viagem from viagem v, cliente c where v.cliente_idcliente = c.idcliente and c.idcliente = '%:idcliente%'", nativeQuery = true)
//	List<Viagem> findByCliente(@Param("idcliente") Integer idCliente);	
}