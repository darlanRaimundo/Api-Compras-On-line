package br.com.desafio.audora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@Column(name="subcategoria")
	private String subCategoria;
	
	@Column(name="categoriaativa")
	private String categoriaAtiva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}

	public String getCategoriaAtiva() {
		return categoriaAtiva;
	}

	public void setCategoriaAtiva(String categoriaAtiva) {
		this.categoriaAtiva = categoriaAtiva;
	}
	
}
