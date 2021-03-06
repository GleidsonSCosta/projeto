package com.projeto.viagem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente")
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false , length = 11)
	private String cpf;
	
	@Column(nullable = false , length = 11)
	private String telefone;
	
	@Column(nullable = false)
	private String endereco;
	 
	//@JsonIgnore
	//@OneToMany(mappedBy = "cliente")
	//private List<Viagem> viagens;
	
}
