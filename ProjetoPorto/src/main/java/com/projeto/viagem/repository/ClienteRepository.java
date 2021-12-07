package com.projeto.viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.viagem.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	//@Query("select c from Cliente join fetch c.viagem where c.idcliente = :id")
//	@Query (value = "select c.nome, v.data_viagem from viagem v, cliente c where v.cliente_idcliente = c.idcliente and c.idcliente = '%:id%'", nativeQuery = true)
//	Cliente findClienteFetchViagem(@Param("id") Integer id);
}
