package br.com.desafio.audora.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.expression.ParseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.audora.model.CarrinhoCompra;
import br.com.desafio.audora.repository.CarrinhoCompraDAO;

@RestController
public class CarrinhoCompraController implements CommandLineRunner {
	
	private CarrinhoCompraDAO carrinhoCompraDAO;
	
	public CarrinhoCompraController(CarrinhoCompraDAO carrinhoCompraDao) {
		this.carrinhoCompraDAO = carrinhoCompraDao;
	}

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	@PostMapping("/clientes/carrinho")
	public String cadastrarCarrinho(@RequestBody CarrinhoCompra carrinhoCompra) throws ParseException {
		
		if (carrinhoCompra.getCodigoCliente() == "" || carrinhoCompra.getCodigoCliente() == null) {
			return "Necessário informar o Cliente.";
		} else if (carrinhoCompra.getCodigoProduto() == "" || carrinhoCompra.getCodigoProduto() == null) {
			return "Necessário informar o Porduto";
		}
		
		if (carrinhoCompra.getQuantidadeProduto() == 0 || carrinhoCompra.getQuantidadeProduto() == null) {
			carrinhoCompra.setQuantidadeProduto(1);
		}
		
		Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = dateFormat.format(dataAtual);
		
		String sql = "SELECT COALESCE(SUM(PERCDESCONTO), 0.0) FROM DESCONTOS WHERE DATAINICIO <= '"+dataFormatada+"' AND DATAFINAL >= '"+dataFormatada+"' AND APLICACAO = 'CC'";
		double dPercDesconto = Double.parseDouble(jdbcTemplate.queryForObject(sql, String.class).toString());
		
		sql = "SELECT COALESCE(SUM(VALORDESCONTO), 0.0) FROM DESCONTOS WHERE DATAINICIO <= '"+dataFormatada+"' AND DATAFINAL >= '"+dataFormatada+"' AND APLICACAO = 'CC'";
		double dValorDesconto = Double.parseDouble(jdbcTemplate.queryForObject(sql, String.class).toString());
		
		sql = "SELECT COALESCE(VALORTOTAL, 0.0) FROM CARRINHO_COMPRAS WHERE CODIGOCLIENTE = '"+carrinhoCompra.getCodigoCliente()+"' LIMIT 1 ";
		Double valorTotal =  Double.parseDouble(jdbcTemplate.queryForObject(sql, String.class).toString());
		
		sql = "SELECT VALOR FROM PRODUTOS WHERE ID = '"+carrinhoCompra.getCodigoProduto()+"'";
		Double valorProduto = Double.parseDouble(jdbcTemplate.queryForObject(sql, String.class).toString());
		
		valorTotal += valorProduto * carrinhoCompra.getQuantidadeProduto();
		
		Double valorTotalCarrinhoComDesconto = 0.0; 
		Double valor = 0.0;
		String complementoMensagem = "";
		if (dPercDesconto > 0.0 && dPercDesconto < 100) {
			valor = valorTotal * (dPercDesconto/100);
			valorTotalCarrinhoComDesconto = valorTotal - valor;
			complementoMensagem = System.lineSeparator()+
									" Promoção aplicada: "+dPercDesconto+"%";
		}
		
		if (dValorDesconto > 0.0 && dValorDesconto < carrinhoCompra.getValorTotal()) {
			valorTotal -= dValorDesconto;
			complementoMensagem += System.lineSeparator()+
									" Promoção aplicada: R$"+dValorDesconto;
		}
		
		if (valorTotal > 0.0) {
			carrinhoCompra.setValorTotal(valorTotal);
			carrinhoCompra.setValorDesconto(valorTotalCarrinhoComDesconto);
		}
		
		if (carrinhoCompra.getValorTotal() == null) {
			carrinhoCompra.setValorTotal(0.0);
		}
		
		if (carrinhoCompra.getValorDesconto() == null) {
			carrinhoCompra.setValorDesconto(0.0);
		}
		
		CarrinhoCompra carrinhoSalvo = carrinhoCompraDAO.save(carrinhoCompra); 
		if (carrinhoSalvo != null) {	
			return "Produto incluido no carrinho com sucesso!"+complementoMensagem;
		} else {
			return "Ocorreu um erro na tentativa de gravação.";
		}
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
