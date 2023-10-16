CREATE TABLE Marcas (
marca_id int auto_increment primary key,
marca_nome varchar(50) not null,
marca_nacionalidade varchar(50)
);

CREATE TABLE Produto(
prd_id int auto_increment primary key,
prd_nome varchar(50) not null,
prd_qtd_estoque int not null default 0,
prd_estoque_min int not null default 0,
prd_data_fabricacao timestamp default now(),
prd_perecivel boolean,
prd_valor decimal(10,2),
prd_marca_id int,
prd_frn_id int,
constraint fk_marca foreign key (prd_marca_id) references marcas(marca_id),
constraint fk_fornecedor foreign key (prd_frn_id) references fornecedor(frn_id)
);

CREATE TABLE Fornecedor(
frn_id int auto_increment primary key,
frn_nome varchar(50) not null,
frn_email varchar(50)
);

CREATE TABLE Produto_Fornecedor(
pf_prod_id int references Produto (prd_id),
pf_frn_id int references Fornecedor (frn_id),
primary key (pf_prod_id, pf_frn_id)
);

/*inserir valores de marca: id, nome, nacionalidade*/
INSERT INTO Marcas VALUES (null, 'AllPlastic', 'EAU');
INSERT INTO Marcas VALUES (null, 'BomMesmo', 'BRASIL');
INSERT INTO Marcas VALUES (null, 'Organicos', 'CHILE');
INSERT INTO Marcas VALUES (null, 'VestCerto', 'MEXICO');

/*inserir valores produto: id, nome, estqoue, min, fab, perecivel, valor,marca_id, fornecedor_id*/
INSERT INTO Produto VALUES (null, 'Garrafa', 20, 2, null, 1, 10.99, 1,1);
INSERT INTO Produto VALUES (null, 'Guarda roupa', 10, 1, '2020-02-24', 1, 2000.99, 2,2);
INSERT INTO Produto VALUES (null, 'Chocolate', 130, 50, '2023-06-30', 0, 9.99, 3,2);
INSERT INTO Produto VALUES (null, 'Camiseta', 7, 3, null, 1, 50.99, 4,3);
INSERT INTO Produto VALUES (null, 'Copos', 20, 40, null, 1, 3.99, 1,2);
INSERT INTO Produto VALUES (null, 'Pirulito', 7, 5, '2021-02-20', 0, 2.99, 3,3,'2022-02-20');

/*inserir valores fornecedor:id, nome, email*/
INSERT INTO Fornecedor VALUES (null, 'Rapido', 'rapido@gmail.com');
INSERT INTO Fornecedor VALUES (null, 'Lento e sem quebrar', 'lento@inteiro.com');
INSERT INTO Fornecedor VALUES (null, 'Entregador', 'entregador@eu.com');

/*inserir valores produto_fornecedor:pf_prod_id ,pf_frn_id */
INSERT INTO Produto_Fornecedor VALUES (1,1);
INSERT INTO Produto_Fornecedor VALUES (2,2);
INSERT INTO Produto_Fornecedor VALUES (3,3);
INSERT INTO Produto_Fornecedor VALUES (4,1);
INSERT INTO Produto_Fornecedor VALUES (5,2);
INSERT INTO Produto_Fornecedor VALUES (6,3);


/*1- Crie uma view que mostra todos os produtos e suas respectivas marcas;*/
CREATE VIEW Produtos_E_Marcas as
SELECT prd_id, prd_nome, marca_nome, marca_id
FROM PRODUTO
INNER JOIN Marcas
ON marca_id = prd_marca_id;

SELECT * FROM Produtos_E_Marcas;

/*2- Crie uma view que mostra todos os produtos e seus respectivos fornecedores;*/
CREATE VIEW Produtos_E_Fornecdores as
SELECT prd_id, prd_nome, frn_nome, frn_id
FROM PRODUTO
INNER JOIN Fornecedor
ON frn_id = prd_frn_id;

SELECT * FROM Produtos_E_Fornecdores;

/*3- Crie uma view que mostra todos os produtos e seus respectivos fornecedores e marcas;*/
CREATE VIEW Produtos_Fornecedores_Marcas as
SELECT prd_nome, frn_nome, marca_nome FROM Produto
JOIN Produto_Fornecedor
ON pf_prod_id = produto.prd_id
JOIN Fornecedor
ON fornecedor.frn_id = pf_frn_id
JOIN Marcas
ON marcas.marca_id = produto.prd_marca_id ;

SELECT * FROM Produtos_Fornecedores_Marcas;

/*4- Crie uma view que mostra todos os produtos com estoque abaixo do mínimo;*/
CREATE VIEW Produtos_Abaixo_Estoque_Minimo as
SELECT prd_id, prd_nome, prd_qtd_estoque, prd_estoque_min
FROM Produto
WHERE prd_qtd_estoque < prd_estoque_min;

SELECT * FROM Produtos_Abaixo_Estoque_Minimo;

/*5- Adicione o campo data de validade. Insira novos produtos com essa informação;*/
ALTER TABLE Produto ADD COLUMN prd_data_validade timestamp;

INSERT INTO Produto VALUES (null, 'Chicletes', 100, 80, '2023-02-20', 0, 0.99, 3,3,'2024-02-20');

select * from Produto;

/*6- Crie uma view que mostra todos os produtos e suas respectivas marcas com validade vencida;*/
CREATE VIEW Produtos_Marcas_Vencidos as
SELECT prd_id, prd_nome, marca_nome, marca_id, prd_data_validade
FROM PRODUTO
INNER JOIN Marcas
ON marca_id = prd_marca_id
WHERE prd_data_validade < NOW();

SELECT * FROM Produtos_Marcas_Vencidos;

/*7- Selecionar os produtos com preço acima da média.*/
SELECT prd_id, prd_nome, prd_valor 
FROM Produto 
WHERE prd_valor > (select avg(prd_valor) from Produto);