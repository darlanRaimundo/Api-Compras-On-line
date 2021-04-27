package br.com.desafio.audora.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.audora.model.Desconto;
import br.com.desafio.audora.repository.DescontoDAO;

@RestController
public class DescontoController {

	private DescontoDAO descontoDAO;
	
	public DescontoController(DescontoDAO descontoDao) {
		this.descontoDAO = descontoDao;
	}
	
	@PostMapping("/descontos")
	public String cadastrar(@RequestBody Desconto desconto) {
		
		if (desconto.getPercDesconto() == 0 || desconto.getPercDesconto() == null) {
			desconto.setPercDesconto(0.0);
		}
		
		if (desconto.getValorDesconto() == 0.0 || desconto.getValorDesconto() == null) {
			desconto.setValorDesconto(0.0);
		}
		
		if (desconto.getAplicacao() == "" || desconto.getAplicacao() == null) {
			desconto.setAplicacao("CC");
		} 
		
		Desconto descontoSalvo = descontoDAO.save(desconto); 
		if (descontoSalvo != null) {
			return "Cadastro concluido com sucesso!";
		} else {
			return "Ocorreu um erro na tentativa de cadastro.";
		}
		
	}
}
