package br.com.desafio.audora.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.audora.model.Cliente;
import br.com.desafio.audora.repository.ClienteDAO;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteDAO clienteDAO;

	public ClienteController(ClienteDAO clienteDao) {
		this.clienteDAO = clienteDao;
	}
	
	@PostMapping
	public String cadastrar(@RequestBody Cliente cliente) {
		
		if (cliente.getNome() == "" || cliente.getNome() == null) {
			return "Necessário informar o nome.";
		} else if (cliente.getEmail() == "" || cliente.getEmail() == null) {
			return "Necessário informar o E-mail.";
		} else if (cliente.getSenha() == "" || cliente.getSenha() == null) {
			return "Necessário informar a senha.";
		}
		
		if (!ClienteDAO.checarEmailValido(cliente.getEmail())) {
			return "Email inválido!";
		}
		
		Cliente clienteSalvo = clienteDAO.save(cliente); 
		if (clienteSalvo != null) {
			return "Cadastro concluido com sucesso!";
		} else {
			return "Ocorreu um erro na tentativa de cadastro.";
		}
		 
	}
	
}
