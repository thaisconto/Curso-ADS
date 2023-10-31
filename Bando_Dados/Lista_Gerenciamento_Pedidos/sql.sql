/*
*/
CREATE DATABASE gerenciamento_pedidos;
USE gerenciamento_pedidos;

-- -----------------------------------------------------
-- Criando as tabelas
-- -----------------------------------------------------

-- Tabela Clientes
CREATE TABLE IF NOT EXISTS Clientes (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL UNIQUE,
  total_pedidos DECIMAL(10,2) NULL,
  PRIMARY KEY (id_cliente)
 );

-- Tabela Pedidos
CREATE TABLE IF NOT EXISTS Pedidos (
  id_pedido INT NOT NULL AUTO_INCREMENT,
  cliente_id INT NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  detalhe VARCHAR(45) NULL,
  PRIMARY KEY (id_pedido),
  FOREIGN KEY (cliente_id) REFERENCES Clientes (id_cliente)
  );

-- Tabela Clientes_Pedidos
CREATE TABLE IF NOT EXISTS Clientes_Pedidos (
  cp_cliente_id INT NOT NULL,
  cp_pedido_id INT NOT NULL,
  PRIMARY KEY (cp_cliente_id, cp_pedido_id),
  FOREIGN KEY (cp_pedido_id) REFERENCES Pedidos (id_pedido),
  FOREIGN KEY (cp_cliente_id) REFERENCES Clientes (id_cliente)
);

-- -----------------------------------------------------
-- Inserindo dados
-- -----------------------------------------------------

-- clientes
INSERT INTO Clientes VALUES (null, 'Cliente 1', '1111', null);
INSERT INTO Clientes VALUES (null, 'Cliente 2', '2222', null);
INSERT INTO Clientes VALUES (null, 'Cliente 3', '3333', null);

select * from Clientes;

-- pedidos
INSERT INTO Pedidos VALUES (null, 1, 10.99, 'detalhe 1');
INSERT INTO Pedidos VALUES (null, 2, 20.99, 'detalhe 2');
INSERT INTO Pedidos VALUES (null, 3, 30.99, 'detalhe 3');

select * from Pedidos;

-- -----------------------------------------------------
-- Criação de Stored Procedure
-- -----------------------------------------------------
-- inserir um novo pedido na tabela 

delimiter $
create procedure InserirPedido (
  cliente_id INT,
  valor DECIMAL (10,2),
  detalhe VARCHAR(45)
)
BEGIN
	  INSERT INTO Pedidos (cliente_id, valor, detalhe) VALUES (cliente_id, valor, detalhe);
END$
DELIMITER ;

call InserirPedido (1, 1.99, 'detalhe stored procedure');
select * from pedidos;

-- -----------------------------------------------------
-- Criação Trigger
-- -----------------------------------------------------
-- acionada APÓS a inserção de um novo pedido. Calcular o valor total dos pedidos para o cliente 
DELIMITER $
CREATE TRIGGER AtualizarTotalPedidosCliente
	AFTER INSERT ON Pedidos  
    FOR EACH ROW
    BEGIN
			UPDATE Clientes 
            SET total_pedidos = (SELECT SUM(valor) 
								 FROM Pedidos 
								 WHERE cliente_id = NEW.cliente_id)
            WHERE Clientes.id_cliente = NEW.cliente_id;
	END;
    $
DELIMITER ;

call InserirPedido (1, 23.99, 'detalhe trigger');
select * from pedidos;
select * from Clientes;

-- -----------------------------------------------------
-- Criação View
-- -----------------------------------------------------
-- combina informações usando JOIN para mostrar os detalhes dos pedidos e os nomes dos clientes.

CREATE VIEW PedidosClientes as
SELECT Pedidos.cliente_id, Clientes.nome, Pedidos.detalhe, Pedidos.valor
FROM Pedidos
INNER JOIN Clientes
ON cliente_id = id_cliente;

SELECT * FROM PedidosClientes;

-- -----------------------------------------------------
-- Criação Consulta com JOIN
-- -----------------------------------------------------
-- listar os detalhes dos pedidos de cada cliente, utilize a view "PedidosClientes" para essa consulta.

SELECT  PedidosClientes.nome, PedidosClientes.valor, PedidosClientes.detalhe, 
		Clientes.total_pedidos
FROM PedidosClientes
JOIN Clientes
ON PedidosClientes.cliente_id = Clientes.id_cliente;