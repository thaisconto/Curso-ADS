
CREATE TABLE Especies (
id int PRIMARY KEY,
especie varchar(30)
);

CREATE TABLE Animais2 (
	id int PRIMARY KEY,
 	nome varchar(50),
  	nasc date,
  	peso decimal(10,2),
  	cor varchar(50),
    especies_id int,
    foreign key (especies_id) references Especies (id)
);

INSERT INTO Especies values (01 , 'chachorro');
INSERT INTO Especies values (02 , 'gato');
INSERT INTO Especies values (03 , 'passaro');
INSERT INTO Especies values (04 , 'peixe');


INSERT INTO Animais2 values (01 , 'Ágata' , '2015-04-09' , 13.9 , 'branco', 01 );
INSERT INTO Animais2 values (02 , 'Félix' , '2016-06-06' , 14.3 , 'preto', 01 );
INSERT INTO Animais2 values (03 , 'Tom' , '2013-02-08' , 11.2 , 'azul', 02 );
INSERT INTO Animais2 values (04 , 'Garfield' , '2015-07-06' , 17.1 , 'laranja', 02 );
INSERT INTO Animais2 values (05 , 'Frajola' , '2013-08-01' , 13.7 , 'preto', 03 );
INSERT INTO Animais2 values (06 , 'Manda-chuva' , '2012-02-03' , 12.3 , 'amarelo', 04 );
INSERT INTO Animais2 values (07 , 'Snowball' , '2014-04-06' , 13.2 , 'amarelo', 03 );
INSERT INTO Animais2 values (10 , 'Ágata' , '2015-08-03' , 11.9 , 'azul', 01 );
INSERT INTO Animais2 values (11 , 'Gato de botas' , '2012-12-10' , 11.6 , 'amarelo', 02 );
INSERT INTO Animais2 values (12 , 'Kitty' , '2020-04-06' , 11.6 , 'amarelo', 02 );
INSERT INTO Animais2 values (13 , 'Milu' , '2013-02-04' , 17.9 , 'branco', 03 );
INSERT INTO Animais2 values (14 , 'Pluto' , '2012-01-03' , 12.3 , 'amarelo', 01 );
INSERT INTO Animais2 values (15 , 'Pateta' ,'2015-05-01' , 17.7 , 'preto', 01 );
INSERT INTO Animais2 values (16 , 'Snoopy' , '2013-07-02' , 18.2 , 'branco', 01 );
INSERT INTO Animais2 values (17 , 'Rex' , '2019-11-03' , 19.7 , 'beje', 01 );
INSERT INTO Animais2 values (20 , 'Bidu' , '2012-09-08' , 12.4 , 'azul', 02 );
INSERT INTO Animais2 values (21 , 'Dum Dum' , '2015-04-06' , 11.2 , 'laranja', 03 );
INSERT INTO Animais2 values (22 , 'Muttley' , '2011-02-03' , 14.3 , 'laranja', 04 );
INSERT INTO Animais2 values (23 , 'Scooby' , '2012-01-02' , 19.9 , 'marrom', 01 );
INSERT INTO Animais2 values (24 , 'Rufus' , '2014-04-05' , 19.7 , 'branco', 01 );
INSERT INTO Animais2 values (25 , 'Rex' , '2021-08-19' , 19.7 , 'branco' , 01);

/*visualizando todos os dados*/
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;

/* 1- Altere o nome do Pateta para Goofy; */
UPDATE Animais2 SET nome = 'Goofy' WHERE id = 15;
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id where Animais2.id = 15;

/* 2- Altere o peso do Garfield para 10 quilogramas; */
UPDATE Animais2 SET peso=10 WHERE id = 4;
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id where Animais2.id = 4;


/* 3- Altere a cor de todos os gatos para laranja; */
UPDATE Animais2 SET cor='laranja' WHERE especies_id = 02;
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id where especies.id = 2;

/* 4- Crie um campo altura para os animais; */
ALTER TABLE Animais2 ADD altura int;
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;


/* 5- Crie um campo observação para os animais; */
ALTER TABLE Animais2 ADD obs varchar(100);
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;

/* 6- Remova todos os animais que pesam mais que 200 quilogramas. */
DELETE FROM Animais2 WHERE peso > 200;
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;

/* 7- Remova todos os animais que o nome inicie com a letra ‘C’. */
DELETE FROM Animais2 WHERE nome LIKE 'C%';
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;

/* 8- Remova o campo cor dos animais; */
ALTER TABLE Animais2 DROP column cor;
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;

/* 9-  Aumente o tamanho do campo nome dos animais para 80 caracteres; */
ALTER TABLE Animais2 MODIFY nome varchar(80);
DESC Animais2;

/* 10- Remova todos os gatos e cachorros. */
DELETE FROM Animais2 WHERE especies_id = 1 OR especies_id = 2;
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;

/* 11- Remova o campo data de nascimento dos animais. */
ALTER TABLE Animais2 DROP column nasc;
DESC Animais2;

/* 12- Remova todos os animais. */
DELETE  FROM Animais2; 
SELECT * FROM Animais2 left join Especies on Especies.id = Animais2.especies_id;

/*13-  Remova a tabela especies. */
DROP TABLE Especies;
SELECT * FROM Especies;