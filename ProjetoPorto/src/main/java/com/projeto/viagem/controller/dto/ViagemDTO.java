package com.projeto.viagem.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViagemDTO {
	
	private String data;
	private Integer idCliente;
	private Integer origem;
	private Integer destino;
	
}
