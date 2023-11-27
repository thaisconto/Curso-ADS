-- --------------------------------------------------
-- Criando tabelas
-- --------------------------------------------------

CREATE DATABASE Normalizacao;
USE Normalizacao;

-- Tabela Clientes
CREATE TABLE IF NOT EXISTS Clientes (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nome_cliente VARCHAR(45) NOT NULL,
  cpf_cliente VARCHAR(45) NOT NULL,
  nasc DATE NOT NULL,
  PRIMARY KEY (id_cliente)
);

-- Tabela Veiculos
CREATE TABLE IF NOT EXISTS Veiculos (
  id_veiculo INT NOT NULL AUTO_INCREMENT,
  nome_veiculo VARCHAR(45) NOT NULL,
  cor_veiculo VARCHAR(45) NOT NULL,
  placa_veiculo VARCHAR(45) NOT NULL,
  valor_diaria DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_veiculo)
);

-- Tabela Locacao
CREATE TABLE IF NOT EXISTS Locacao (
  id_locacao INT NOT NULL AUTO_INCREMENT,
  cliente_id INT NOT NULL,
  veiculo_id INT NOT NULL,
  dias INT NOT NULL,
  total DECIMAL(10,2),
  PRIMARY KEY (id_locacao),
  FOREIGN KEY (cliente_id) REFERENCES Clientes (id_cliente),
  FOREIGN KEY (veiculo_id) REFERENCES Veiculos (id_veiculo)
);


-- --------------------------------------------------
-- Inserindo dados
-- --------------------------------------------------

INSERT INTO Clientes VALUES (NULL, 'Ariano Suassuna', '123.456.789-1', '21/05/1022');
INSERT INTO Clientes VALUES (NULL, 'Grace Hopper', '543.765.987-23', '29-04-2002');
INSERT INTO Clientes VALUES (NULL, 'Richard Feynman', '987.654.231-90', '12-10-2001');
INSERT INTO Clientes VALUES (NULL, 'Edgar Poe', '432.765.678-67', '14-12-1998');
INSERT INTO Clientes VALUES (NULL, 'Gordon Freeman', '927.384.284-44', '26-11-1984');

INSERT INTO Veiculos VALUES (NULL, 'Fusca', 'Preto', 'WER-3456', 30);
INSERT INTO Veiculos VALUES (NULL, 'Variante', 'Rosa', 'FDS-8384', 60);
INSERT INTO Veiculos VALUES (NULL, 'Comodoro', 'Preto', 'CVB-9933', 20);
INSERT INTO Veiculos VALUES (NULL, 'Deloriam', 'Azul', 'FGH-2256', 80);
INSERT INTO Veiculos VALUES (NULL, 'Brasília', 'Amarela', 'DDI-3948', 45);

INSERT INTO Locacao VALUES (NULL, 1, 1, 3, NULL);
INSERT INTO Locacao VALUES (NULL, 2, 2, 7, NULL);
INSERT INTO Locacao VALUES (NULL, 3, 3, 1, NULL);
INSERT INTO Locacao VALUES (NULL, 4, 4, 3, NULL);
INSERT INTO Locacao VALUES (NULL, 5, 5, 7, NULL);

-- calcular o total após inserção em locação


-- --------------------------------------------------
-- View que seleciona todas as locações e seus respectivos veículos e clientes.
-- --------------------------------------------------
