 -- Criacao do banco
CREATE DATABASE IF NOT EXISTS db_cadastro_cliente;

-- Seleciona o banco de dados para uso
USE db_cadastro_cliente;

-- Cria a tabela de clientes
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20)
);

CREATE USER 'bruno'@'localhost' IDENTIFIED BY 'Senh4df987'; GRANT ALL PRIVILEGES ON db_cadastro_cliente.* TO 'bruno'@'localhost'; FLUSH PRIVILEGES;
