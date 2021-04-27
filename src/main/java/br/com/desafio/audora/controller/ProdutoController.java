package br.com.desafio.audora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.audora.model.Produto;
import br.com.desafio.audora.repository.ProdutoDAO;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private ProdutoDAO produtoDAO;

	ProdutoController(ProdutoDAO produtoDao) {
		this.produtoDAO = produtoDao;
	}
	
	@GetMapping
	public List<?> Listar(){
	   return produtoDAO.findAll();
	}
	
	@PostMapping
	public String cadastrar(@RequestBody Produto produto) {
		
		if (produto.getDescricao() == "" || produto.getDescricao() == null) {
			return "Necessário informar a descrição.";
		} else if (produto.getPreco() == 0 || produto.getPreco() == null) {
			return "Necessário informar o preço.";
		}
		
		Produto produtoSalvo = produtoDAO.save(produto); 
		if (produtoSalvo != null) {
			return "Cadastro concluido com sucesso!";
		} else {
			return "Ocorreu um erro na tentativa de cadastro.";
		}
		
	}

}
