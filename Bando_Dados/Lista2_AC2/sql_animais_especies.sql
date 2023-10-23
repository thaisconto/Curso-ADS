-- criar tabela animais

CREATE TABLE Animais (
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nome varchar(30) NOT NULL,
peso decimal (10,2) NOT NULL,
nascimento date,
especie_id INT,
FOREIGN KEY (especie_id) references Especie (id)
);

-- criar tabela especie

CREATE TABLE Especie (
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nome_especie varchar(30) NOT NULL,
descricao varchar(200)
);

-- inserir dados animais: id, nome, peso, nasc, id_especie
INSERT INTO Animais values (null , 'Ágata' ,13.9,  '2015-04-09', 1 );
INSERT INTO Animais values (null , 'Félix' , 14.3 , '2016-06-06' ,  1 );
INSERT INTO Animais values (null , 'Tom' , 11.2 , '2013-02-08' ,  2 );
INSERT INTO Animais values (null , 'Garfield' , 17.1 ,'2015-07-06' , 2 );
INSERT INTO Animais values (null , 'Frajola' , 13.7 , '2013-08-01' ,  3);
INSERT INTO Animais values (null , 'Manda-chuva' , 12.3 , '2012-02-03' , 3 );
INSERT INTO Animais values (null, 'Snowball' , 13.2 , '2014-04-06' , 1 );
INSERT INTO Animais values (null , 'Ágata' , 11.9 , '2015-08-03' , 2);

-- inserir dados especie: id, nome, descricao
INSERT INTO Especie VALUES (null, "Cachorro", "animal fofinho de 4 patas" );
INSERT INTO Especie VALUES (null, "Gato", "animal antipático, porém fofo" );
INSERT INTO Especie VALUES (null, "Peixe", "animal aquático" );


-- consultar dados
SELECT * 
FROM Animais left
join Especie
on Especie.id = Animais.especie_id;