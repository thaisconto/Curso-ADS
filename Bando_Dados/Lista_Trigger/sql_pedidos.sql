-- criação tabela "Pedidos"

CREATE TABLE Pedidos(
IDPedido INT AUTO_INCREMENT PRIMARY KEY,
DataPedido DATETIME,
NomeCliente varchar(100)
);

-- inserção de dados
INSERT INTO Pedidos (DataPedido, NomeCliente) VALUES
(now(), 'Cliente 1'),
(now(), 'Cliente 2'),
(now(), 'Cliente 3');

-- criação da Trigger
DELIMITER $
CREATE TRIGGER RegistroDataCriacaoPedido
	BEFORE INSERT ON Pedidos
    FOR EACH ROW
    BEGIN
		SET NEW.DataPedido = Now();
	END;
    $
DELIMITER ;

-- inserção de novo pedido sem fornecer a data
INSERT INTO Pedidos (NomeCliente) VALUES ('Novo cliente');

-- consulta para verificar resultados
SELECT * FROM Pedidos;