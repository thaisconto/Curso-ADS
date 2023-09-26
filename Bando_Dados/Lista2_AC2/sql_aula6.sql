CREATE TABLE Carros (
  id integer primary key AUTO_INCREMENT,
  modelo varchar(60),
  alimentacao varchar(20) DEFAULT "Combustao",
  qtd_portas int  default 4  
);


CREATE TABLE Pessoas(
  id integer primary key AUTO_INCREMENT,
  primeiro_nome varchar(20),
  sobre_nome varchar(40),
  nome_completo varchar(60) as ( concat(primeiro_nome, " ", sobre_nome)),
  peso decimal (6,3),
  altura decimal (3,2),
  imc decimal(6,3) as (peso / (altura*altura))
);


CREATE TABLE Produtos2(
  id integer primary key AUTO_INCREMENT,
  nome varchar(60) NOT NULL UNIQUE,
  preco_custo decimal(9,2),
  preco_venda decimal(9,2),
  lucro decimal(9,2) as (preco_venda - preco_custo),
  check (preco_custo < preco_venda)
);


CREATE TABLE Fornecedores(
  id integer primary key AUTO_INCREMENT,
  nome varchar(60) NOT NULL UNIQUE,
  cidade varchar(40),
  estado char(2) DEFAULT "SP"
);

/* Na tabela de Produtos crie um campo data_de_vencimento para a
tabela Produtos que será 1 mês após a data de cadastro.*/


/*Na tabela Carros crie um campo autonomia que será utilizado para
calcular o volume máximo de combustivel e consumo médio.*/
