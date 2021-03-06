package com.projeto.viagem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idviagem")
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_viagem")
	private LocalDate dataViagem;
	
	@ManyToOne
	@JoinColumn(name = "cliente_idcliente")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "origem_idestado")
	private Estado origem;
	
	@OneToOne
	@JoinColumn(name = "destino_idestado")
	private Estado destino;
	
}
