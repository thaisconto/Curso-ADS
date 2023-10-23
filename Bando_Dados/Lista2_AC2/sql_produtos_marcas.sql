-- criar tabela produtos

CREATE TABLE Produtos(
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nome varchar(30) NOT NULL,
preco_custo decimal(10,2) NOT NULL,
preco_venda decimal(10,2) NOT NULL,
validade date,
marca_id int NOT NULL,
FOREIGN KEY (marca_id) references Marcas (id),
CHECK (preco_venda > preco_custo)
);

-- criar tabela marcas

CREATE TABLE Marcas (
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nome_marca varchar(30) NOT NULL,
site varchar(30),
telefone varchar(30)
);

-- inserir dados produtos: id, nome, custo, venda, validade, marca_id
INSERT INTO Produtos VALUES (null, "Copo", 2.99, 5.99, "2024-09-13", 1);
INSERT INTO Produtos VALUES (null, "Caneca", 1.99, 5.99, "2024-10-21", 2);
INSERT INTO Produtos VALUES (null, "Xícara", 0.99, 6.99, "2024-03-14", 3);
INSERT INTO Produtos VALUES (null, "Garrafa", 6.99, 7.99, "2024-04-22", 1);
INSERT INTO Produtos VALUES (null, "Garfo", 5.99, 9.99, "2021-01-12", 2);
INSERT INTO Produtos VALUES (null, "Faca", 4.99, 8.99, "2024-09-07", 3);
INSERT INTO Produtos VALUES (null, "Colher", 8.99, 15.99, "-2024-08-09", 1);
INSERT INTO Produtos VALUES (null, "Jarra", 7.99, 30.99, "2024-02-02", 2);

-- inserir dados animais: id, nome, site, telefone
INSERT INTO Marcas VALUES (null, "Tramontina", "xxxx.com.br", "(xx) xxxx-xxxx");
INSERT INTO Marcas VALUES (null, "Diamontina", "yyyy.com.br", "(yy) yyyy-yyyy");
INSERT INTO Marcas VALUES (null, "Adamontina", "zzzz.com.br", "(zz) zzzz-zzzz");

-- consultar dados

SELECT * 
FROM Produtos left
join Marcas
on Marcas.id = Produtos.marca_id;