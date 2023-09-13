package br.com.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Pedido {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomeProduto;
	
	private BigDecimal valorNegociado;
	
	private LocalDate dataEntrega;
	
	@Column(length = 2000)
	private String urlProduto;
	
	private String urlImagem;
	
	private String descricao;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

}
