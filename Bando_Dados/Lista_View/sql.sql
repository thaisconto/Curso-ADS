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
constraint fk_marca foreign key (prd_marca_id) references marcas(marca_id)
);

CREATE TABLE Fornecedor(
frn_id int auto_increment primary key,
frn_nome varchar(50) not null,
frn_email varchar(50)
);

CREATE TABLE Produto_Fornecedor(
pf_prod_id int references Produto (prd_id),
pf_frc_id int references Fornecedor (frn_id),
primary key (pf_prod_id, pf_frc_id)
);

/*inserir valores de marca: id, nome, nacionalidade*/
INSERT INTO Marca VALUES ();

/*inserir valores produto: id, nome, estqoue, min, fab, perecivel, valor,marca_id*/

/*inserir valores fornecedor:id, nome, email*/


/*1- Crie uma view que mostra todos os produtos e suas respectivas marcas;*/

/*2- Crie uma view que mostra todos os produtos e seus respectivos fornecedores;*/

/*3- Crie uma view que mostra todos os produtos e seus respectivos fornecedores e marcas;*/

/*4- Crie uma view que mostra todos os produtos com estoque abaixo do mínimo;*/

/*5- Adicione o campo data de validade. Insira novos produtos com essa informação;*/

/*6- Crie uma view que mostra todos os produtos e suas respectivas marcas com validade vencida;*/

/*7- Selecionar os produtos com preço acima da média.*/