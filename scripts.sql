-- Criar Banco de Dados
CREATE DATABASE `sistema_compras` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- criar tabela de clientes
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(320) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- criar tabela de produtos
CREATE TABLE `produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `codcategoria` int DEFAULT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PRODUTOSCATEGORIA_idx` (`codcategoria`),
  CONSTRAINT `FK_PRODUTOSCATEGORIA` FOREIGN KEY (`codcategoria`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- criar tabela de desconto
CREATE TABLE `descontos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `percdesconto` double DEFAULT '0',
  `valordesconto` double DEFAULT '0',
  `aplicacao` varchar(2) NOT NULL DEFAULT 'CC',
  `datainicio` date DEFAULT NULL,
  `datafinal` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- criar tabela de categorias
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `subcategoria` char(1) NOT NULL DEFAULT 'F',
  `categoriaativa` char(1) NOT NULL DEFAULT 'T',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- criar tabela de vinculo da forma que o desconto será aplicado
CREATE TABLE `desconto_aplicacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigocategoria` int DEFAULT NULL,
  `codigocarrinho` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DESCAPLICACAO_CATEGORIA_idx` (`codigocategoria`),
  KEY `FK_DESCAPLICACAO_CARRINHO_idx` (`codigocarrinho`),
  CONSTRAINT `FK_DESCAPLICACAO_CARRINHO` FOREIGN KEY (`codigocarrinho`) REFERENCES `carrinho_compras` (`id`),
  CONSTRAINT `FK_DESCAPLICACAO_CATEGORIA` FOREIGN KEY (`codigocategoria`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Criar tabela do carrinho de compras
CREATE TABLE `carrinho_compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigocliente` int NOT NULL,
  `codigoproduto` int NOT NULL,
  `quantidade_produto` int NOT NULL DEFAULT '1',
  `valortotal` double NOT NULL DEFAULT '0',
  `valordesconto` double DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_CODIGOCLIENTE_idx` (`codigocliente`),
  KEY `FK_CODIGOPRODUTO_idx` (`codigoproduto`),
  CONSTRAINT `FK_CARRINHOCLIENTE` FOREIGN KEY (`codigocliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `FK_CARRINHOPRODUTO` FOREIGN KEY (`codigoproduto`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;