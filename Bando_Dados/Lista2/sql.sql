CREATE TABLE Produtos(
id_produto integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome varchar(30) NOT NULL,
preco decimal(5,2) NOT NULL,
estoque int NOT NULL,
perecivel char(1) NOT NULL,
marca varchar(30),
nacionalidade varchar(30)
);

INSERT INTO Produtos values (null , 'Bécker', 105.90, 55, 'n', 'reacts', 'eua');
INSERT INTO Produtos values (null , 'Balão volumétrico', 180.00, 180, 'n', 'merck', 'alemanha');
INSERT INTO Produtos values (null , 'Ácido nítrico', 134.99, 46, 's', 'mettler', 'brasil');
INSERT INTO Produtos values (null , 'Pipeta graduada', 99.99, 176, 'n', 'volumeters', 'belgica');
INSERT INTO Produtos values (null , 'Acetona', 12.70, 87, 's', 'sinth', 'chile');

/*Verifique se todos os dados foram inseridos*/
SELECT * FROM Produtos;

/*Gere um relatório informando quantos produtos estão cadastrados;*/
SELECT COUNT(id_produto) AS Quantidade_produtos FROM Produtos;

/*Gere um relatório informando o preço médio dos produtos;*/
SELECT AVG(preco) AS preco_media FROM Produtos;

/*Selecione a média dos preços dos produtos em 2 grupos: perecíveis e não perecíveis;*/
SELECT perecivel, preco, AVG(preco) AS media_preco FROM Produtos GROUP BY perecivel;

/*Selecione a média dos preços dos produtos agrupados pelo nome do produto;*/
SELECT nome, preco, AVG(preco) AS media_preco FROM Produtos GROUP BY nome;

/*Selecione a média dos preços e total em estoque dos produtos;*/
SELECT SUM(estoque) AS total_estoque, AVG(preco) AS media_preco  FROM Produtos;

/*Selecione o nome, marca e quantidade em estoque do produto mais caro;*/
SELECT nome, marca, estoque, MAX(preco) FROM Produtos;

/*Selecione os produtos com preço acima da média;*/
SELECT nome, preco FROM Produtos HAVING preco > (SELECT AVG(preco) FROM Produtos);

/*Selecione a quantidade de produtos de cada nacionalidade*/
SELECT nacionalidade, SUM(estoque) AS total_estoque FROM Produtos Group by nacionalidade;