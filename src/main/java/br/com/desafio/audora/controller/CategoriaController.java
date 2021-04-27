package br.com.desafio.audora.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.audora.model.Categoria;
import br.com.desafio.audora.repository.CategoriaDAO;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaDAO categoriaDAO;
	
	public CategoriaController(CategoriaDAO categoriaDao) {
		this.categoriaDAO = categoriaDao;
	}
	
	@PostMapping
	public String cadastrar(@RequestBody Categoria categoria) {
		
		if (categoria.getDescricao() == "" || categoria.getDescricao() == null) {
			return "Necessário informar a descrição.";
		} 
		
		if (categoria.getSubCategoria() == "" || categoria.getSubCategoria() == null) {
			categoria.setSubCategoria("F");
		} 
		
		if (categoria.getCategoriaAtiva() == "" || categoria.getCategoriaAtiva() == null) {
			categoria.setCategoriaAtiva("T");
		}
		
		Categoria categoriaSalvo = categoriaDAO.save(categoria); 
		if (categoriaSalvo != null) {
			return "Cadastro concluido com sucesso!";
		} else {
			return "Ocorreu um erro na tentativa de cadastro.";
		}
		 
	}
}
