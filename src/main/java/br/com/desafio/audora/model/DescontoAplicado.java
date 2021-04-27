package br.com.desafio.audora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="desconto_aplicacao")
public class DescontoAplicado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="codigocategoria")
	private String codigoCategoria;
	
	@Column(name="codigocarrinho")
	private String codigoCarrinho;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getCodigoCarrinho() {
		return codigoCarrinho;
	}

	public void setCodigoCarrinho(String codigoCarrinho) {
		this.codigoCarrinho = codigoCarrinho;
	}
	
	

}
