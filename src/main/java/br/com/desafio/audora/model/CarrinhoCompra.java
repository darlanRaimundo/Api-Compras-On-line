package br.com.desafio.audora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="carrinho_compras")
public class CarrinhoCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="codigocliente")
	private String codigoCliente;
	
	@Column(name="codigoproduto")
	private String codigoProduto;
	
	@Column(name="quantidade_produto")
	private Integer quantidadeProduto;
	
	@Column(name="valortotal")
	private Double valorTotal;
	
	@Column(name="valordesconto")
	private Double valorDesconto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Double getValorTotal() {
		if (valorTotal == null) {
			valorTotal = 0.0;
		}
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorDesconto() {
		if (valorDesconto == null) {
			valorDesconto = 0.0;
		}
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
}
