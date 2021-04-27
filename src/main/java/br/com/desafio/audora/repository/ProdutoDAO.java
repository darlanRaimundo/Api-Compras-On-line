package br.com.desafio.audora.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.audora.model.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Id> {

}
