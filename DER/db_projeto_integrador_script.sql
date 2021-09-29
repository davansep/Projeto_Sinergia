CREATE DATABASE db_projeto_integrador;

USE db_projeto_integrador;
CREATE TABLE tb_usuario (

	id_usuario INT(30) NOT NULL PRIMARY KEY,
	nome_completo VARCHAR (255) NOT NULL,
	email VARCHAR (255) NOT NULL,
	senha VARCHAR (255) NOT NULL
);

USE db_projeto_integrador;
CREATE TABLE tb_tema (

	id_tema INT(30) NOT NULL PRIMARY KEY,
	nome VARCHAR (255) NOT NULL,
	descricao VARCHAR (255) NOT NULL,
	`status` BOOLEAN NOT NULL 
);

USE db_projeto_integrador;
CREATE TABLE tb_postagem (

	id_postagem INT(30) NOT NULL PRIMARY KEY,
	titulo VARCHAR (255) NOT NULL,
	conteudo VARCHAR (255) NOT NULL,
	link_midia VARCHAR (255) NOT NULL,
	`data` DATETIME NOT NULL,
	fk_tema INT(30) NOT NULL,
	fk_usuario INT(30) NOT NULL,
	
	FOREIGN KEY (fk_tema) REFERENCES tb_tema (id_tema),
	FOREIGN KEY (fk_usuario) REFERENCES tb_usuario (id_usuario)
);


SELECT * FROM tb_usuario;
SELECT * FROM tb_tema;
SELECT * FROM tb_postagem;