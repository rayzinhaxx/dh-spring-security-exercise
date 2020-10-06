CREATE DATABASE empresa;
USE empresa;

CREATE TABLE cliente 
(id_cliente INTEGER PRIMARY KEY UNIQUE,
nome VARCHAR(50),
cpf VARCHAR(14) UNIQUE NOT NULL,
rg VARCHAR(14) UNIQUE NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
nascimento DATE NOT NULL);

CREATE TABLE pedido
(id_pedido INTEGER PRIMARY KEY UNIQUE,
data_emissao DATE NOT NULL,
valor_total DECIMAL(10,2) NOT NULL,
status_pedido VARCHAR(10) NOT NULL,
CONSTRAINT fk_id_cliente FOREIGN KEY (fk_id_cliente)
REFERENCES cliente (id_cliente));

CREATE TABLE pedido2
(id_pedido INTEGER PRIMARY KEY UNIQUE,
data_emissao DATE NOT NULL,
valor_total DECIMAL(10,2) NOT NULL,
status_pedido VARCHAR(10) NOT NULL,
fk_id_cliente INTEGER);

ALTER TABLE pedido2 ADD FOREIGN KEY (fk_id_cliente) REFERENCES cliente (id_cliente);

CREATE TABLE funcionario
(id_funcionario INTEGER PRIMARY KEY UNIQUE,
nome VARCHAR(50),
salario DECIMAL(10,2) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
senha VARCHAR(20),
habilitado BOOL);

CREATE TABLE autorizacao
(autoridade VARCHAR(50),
email VARCHAR(100) PRIMARY KEY UNIQUE NOT NULL);

