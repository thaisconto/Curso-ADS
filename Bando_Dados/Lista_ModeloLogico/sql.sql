CREATE TABLE Pizza(
id integer PRIMARY KEY,
sabor varchar(45),
ingredientes varchar(45),
preco decimal (5,2),
tamanho varchar(45),
descricao varchar(45),
embalagem_id integer,
receita_id integer,
FOREIGN KEY (embalagem_id) references Embalagem (id),
FOREIGN KEY (receita_id) references Receita (id)
);

CREATE TABLE Embalagem(
id integer PRIMARY KEY,
material varchar(45),
preco decimal(3,2),
tamanho varchar(45)
);

CREATE TABLE Receita(
id integer PRIMARY KEY,
autor varchar(45),
instrucao varchar(45)
);

CREATE TABLE Pizzaiolo(
id integer PRIMARY KEY,
nome varchar(45),
salario decimal(8,2)
);

CREATE TABLE Pizza_Pizzaiolo(
pp_pizza_id integer references Pizza (id),
pp_pizzaiolo_id integer references Pizzaiolo (id),
primary key (pp_pizza_id, pp_pizzaiolo_id)
);

CREATE TABLE Ingredientes (
id integer auto_increment primary key,
descricao VARCHAR(100)
);

CREATE TABLE Ingredientes_Pizza(
ip_ingredientes_id  integer references Ingredientes (id),
ip_pizza_id integer references Pizza (id),
primary key (ip_ingredientes_id, ip_pizza_id)
);


/*Inserir dados embalagem: id, material, preco, tamanho*/
INSERT INTO Embalagem values (1, 'papelão', 1.99, 'P');
INSERT INTO Embalagem values (2, 'papelão', 2.99, 'M');
INSERT INTO Embalagem values (3, 'papelão', 3.99, 'G');
INSERT INTO Embalagem values (4, 'papelão', 4.99, 'GG');

/*Inserir dados receita: id, autor, instrução */       
INSERT INTO Receita values (1, 'Thaís', 'pizza bauru: inserir todos os ingredientes');
INSERT INTO Receita values (2, 'Marcos', 'marguerita: inserir todos os ingredientes');
INSERT INTO Receita values (3, 'Gustavo', 'bacon: inserir todos os ingredientes');
INSERT INTO Receita values (4, 'Rose', 'portuguesa: inserir todos os ingredientes');

/*Inserir dados pizzaiolo: id, nome, salário*/
INSERT INTO Pizzaiolo values (1, 'Marcos', '4700.00');
INSERT INTO Pizzaiolo values (2, 'Thaís', '3700.00');
INSERT INTO Pizzaiolo values (3, 'Alemão', '2700.00');
INSERT INTO Pizzaiolo values (4, 'Rose', '1700.00');

/*Inserir dados pizza: id, sabor, ingredientes, preco, tamanho, descrição, embalagem_id, receita_id*/
INSERT INTO Pizza values (1, 'bauru', 'molho, queijo, presunto', 20.99, 'M', 'na', 2, 1);
INSERT INTO Pizza values (2, 'marguerita', 'molho, queijo, manjericão', 18.99, 'M', 'na', 2, 2);
INSERT INTO Pizza values (3, 'bacon', 'molho, queijo, bacon', 10.99, 'P', 'na', 1, 3);
INSERT INTO Pizza values (4, 'portuguesa', 'molho, queijo, presunto, palmito', 40.99, 'GG', 'na', 4, 4);


/*Inserir dados ingredientes: id, descrição*/
INSERT INTO Ingredientes values (1, 'molho');
INSERT INTO Ingredientes values (2, 'queijo');
INSERT INTO Ingredientes values (3, 'presunto');
INSERT INTO Ingredientes values (4, 'manjericão');
INSERT INTO Ingredientes values (5, 'bacon');
INSERT INTO Ingredientes values (6, 'palmito');

/*Inserir dados Pizza_Pizzaiolo: pizza_id, pizzaiolo_id
 pizzaiolo  1 faz 1,2,3,4
			2 --> 1,2,3
            3 --> 1,2
            4 --> 1
*/
INSERT INTO Pizza_Pizzaiolo values (1,1);
INSERT INTO Pizza_Pizzaiolo values (2,1);
INSERT INTO Pizza_Pizzaiolo values (3,1);
INSERT INTO Pizza_Pizzaiolo values (4,1);
INSERT INTO Pizza_Pizzaiolo values (1,2);
INSERT INTO Pizza_Pizzaiolo values (2,2);
INSERT INTO Pizza_Pizzaiolo values (3,2);
INSERT INTO Pizza_Pizzaiolo values (1,3);
INSERT INTO Pizza_Pizzaiolo values (2,3);
INSERT INTO Pizza_Pizzaiolo values (1,4);

/*Inserir dados ingredientes_Pizza: ingredintes_id, pizza_id
 1 molho, 2 queijo, 3 presunto, 4 manjericao, 5 bacon, 6 palmito
 pizza  1 bauru tem 1, 2, 3
		2 marguerita  --> 1, 2, 4
		3 bacon --> 1, 2, 5
		4 portuguesa --> 1, 2, 3, 6
*/
INSERT INTO Ingredientes_Pizza values (1,1);
INSERT INTO Ingredientes_Pizza values (1,2);
INSERT INTO Ingredientes_Pizza values (1,3);
INSERT INTO Ingredientes_Pizza values (2,1);
INSERT INTO Ingredientes_Pizza values (2,2);
INSERT INTO Ingredientes_Pizza values (2,4);
INSERT INTO Ingredientes_Pizza values (3,1);
INSERT INTO Ingredientes_Pizza values (3,2);
INSERT INTO Ingredientes_Pizza values (3,5);
INSERT INTO Ingredientes_Pizza values (4,1);
INSERT INTO Ingredientes_Pizza values (4,2);
INSERT INTO Ingredientes_Pizza values (4,3);
INSERT INTO Ingredientes_Pizza values (4,6);


/*1- Crie um relatório com todas as pizzas e os pizzaiolos aptos a produzi-las;*/
SELECT 
pizza.sabor, pizzaiolo.nome
FROM Pizza
JOIN Pizza_Pizzaiolo
ON pp_pizza_id = pizza.id
JOIN Pizzaiolo
ON pizzaiolo.id = pp_pizzaiolo_id
ORDER BY pizzaiolo.nome ;

/*2- Crie um relatório com todas as pizzas e seus ingredientes;*/
SELECT pizza.sabor, ingredientes.descricao
FROM Pizza
JOIN Ingredientes_Pizza
ON ip_pizza_id = pizza.id
JOIN ingredientes
ON ingredientes.id = ip_ingredientes_id
ORDER BY pizza.sabor;

/*3- Crie um relatório com todos os ingredientes e as pizzas onde são utilizados;*/
SELECT pizza.sabor, ingredientes.descricao FROM Pizza
JOIN Ingredientes_Pizza
ON ip_pizza_id = pizza.id
JOIN ingredientes
ON ingredientes.id = ip_ingredientes_id
ORDER BY ingredientes.descricao;

/*4- Crie um relatório com os sabores de todas as pizzas, o nome dos pizzaiolos que as fazem e as instruções para produzi-las*/
SELECT pizza.sabor, pizzaiolo.nome, receita.instrucao FROM Pizza
JOIN Pizza_Pizzaiolo
ON pp_pizza_id = pizza.id
JOIN Pizzaiolo
ON pizzaiolo.id = pp_pizzaiolo_id
JOIN Receita
ON receita.id = pizza.id ;

DROP TABLE pizza;
DROP TABLE pizza_pizzaiolo;
DROP TABLE pizzaiolo;
DROP TABLE Ingredientes;
DROP TABLE embalagem;
DROP TABLE ingredientes_pizza;
DROP TABLE receita;

SELECT * FROM pizzaiolo;
DESC Pizza;
DESC pizza_pizzaiolo;
DESC pizzaiolo;