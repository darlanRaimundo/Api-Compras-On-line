package br.com.desafio.audora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="descontos")
public class Desconto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="percdesconto")
	private Double percDesconto;
	
	@Column(name="valordesconto")
	private Double valorDesconto;
	
	private String aplicacao;
	
	@Column(name="datainicio")
	private Date dataInicio;
	
	@Column(name="datafinal")
	private Date dataFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPercDesconto() {
		if (percDesconto == null) {
			percDesconto = 0.0;
		}
		return percDesconto;
	}

	public void setPercDesconto(Double percDesconto) {
		this.percDesconto = percDesconto;
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

	public String getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}
