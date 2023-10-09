CREATE TABLE Animais2 (
	id int,
 	nome varchar(50),
  	nasc date,
  	peso decimal(10,2),
  	cor varchar(50)
);

CREATE TABLE Especies (
especie varchar(30)
);

INSERT INTO Animais2 values (01 , 'Ágata' , '2015-04-09' , 13.9 , 'branco' );
INSERT INTO Animais2 values (02 , 'Félix' , '2016-06-06' , 14.3 , 'preto' );
INSERT INTO Animais2 values (03 , 'Tom' , '2013-02-08' , 11.2 , 'azul' );
INSERT INTO Animais2 values (04 , 'Garfield' , '2015-07-06' , 17.1 , 'laranja' );
INSERT INTO Animais2 values (05 , 'Frajola' , '2013-08-01' , 13.7 , 'preto' );
INSERT INTO Animais2 values (06 , 'Manda-chuva' , '2012-02-03' , 12.3 , 'amarelo' );
INSERT INTO Animais2 values (07 , 'Snowball' , '2014-04-06' , 13.2 , 'amarelo' );
INSERT INTO Animais2 values (10 , 'Ágata' , '2015-08-03' , 11.9 , 'azul' );
INSERT INTO Animais2 values (11 , 'Gato de botas' , '2012-12-10' , 11.6 , 'amarelo' );
INSERT INTO Animais2 values (12 , 'Kitty' , '2020-04-06' , 11.6 , 'amarelo' );
INSERT INTO Animais2 values (13 , 'Milu' , '2013-02-04' , 17.9 , 'branco' );
INSERT INTO Animais2 values (14 , 'Pluto' , '2012-01-03' , 12.3 , 'amarelo' );
INSERT INTO Animais2 values (15 , 'Pateta' ,'2015-05-01' , 17.7 , 'preto' );
INSERT INTO Animais2 values (16 , 'Snoopy' , '2013-07-02' , 18.2 , 'branco' );
INSERT INTO Animais2 values (17 , 'Rex' , '2019-11-03' , 19.7 , 'beje' );
INSERT INTO Animais2 values (20 , 'Bidu' , '2012-09-08' , 12.4 , 'azul' );
INSERT INTO Animais2 values (21 , 'Dum Dum' , '2015-04-06' , 11.2 , 'laranja' );
INSERT INTO Animais2 values (22 , 'Muttley' , '2011-02-03' , 14.3 , 'laranja' );
INSERT INTO Animais2 values (23 , 'Scooby' , '2012-01-02' , 19.9 , 'marrom' );
INSERT INTO Animais2 values (24 , 'Rufus' , '2014-04-05' , 19.7 , 'branco' );
INSERT INTO Animais2 values (25 , 'Rex' , '2021-08-19' , 19.7 , 'branco' );

SELECT * FROM Animais2;

/* Altere o nome do Pateta para Goofy; */
UPDATE Animais2 SET nome = 'Goofy' WHERE id = 15;
SELECT * FROM Animais2 WHERE id = 15;

/* Altere o peso do Garfield para 10 quilogramas; */
UPDATE Animais2 SET peso=10 WHERE id = 4;
SELECT * FROM Animais2 WHERE id = 4;

/* Altere a cor de todos os gatos para laranja; */
UPDATE Animais2 SET cor='laranja' WHERE 
SELECT * FROM Animais2;

/* Crie um campo altura para os animais; */

/* Crie um campo observação para os animais; */

/* Remova todos os animais que pesam mais que 200 quilogramas. */

/* Remova todos os animais que o nome inicie com a letra ‘C’. */

/* Remova o campo cor dos animais; */

/* Aumente o tamanho do campo nome dos animais para 80 caracteres; */

/* Remova todos os gatos e cachorros. */

/* Remova o campo data de nascimento dos animais. */

/* Remova todos os animais. */

/* Remova a tabela especies. */