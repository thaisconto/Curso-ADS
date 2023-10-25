CREATE TABLE Animais (
	id int,
 	nome varchar(50),
  	nasc date,
  	peso decimal(10,2),
  	cor varchar(50)
);

INSERT INTO Animais values (01 , 'Ágata' , '2015-04-09' , 13.9 , 'branco' );
INSERT INTO Animais values (02 , 'Félix' , '2016-06-06' , 14.3 , 'preto' );
INSERT INTO Animais values (03 , 'Tom' , '2013-02-08' , 11.2 , 'azul' );
INSERT INTO Animais values (04 , 'Garfield' , '2015-07-06' , 17.1 , 'laranja' );
INSERT INTO Animais values (05 , 'Frajola' , '2013-08-01' , 13.7 , 'preto' );
INSERT INTO Animais values (06 , 'Manda-chuva' , '2012-02-03' , 12.3 , 'amarelo' );
INSERT INTO Animais values (07 , 'Snowball' , '2014-04-06' , 13.2 , 'amarelo' );
INSERT INTO Animais values (10 , 'Ágata' , '2015-08-03' , 11.9 , 'azul' );
INSERT INTO Animais values (11 , 'Gato de botas' , '2012-12-10' , 11.6 , 'amarelo' );
INSERT INTO Animais values (12 , 'Kitty' , '2020-04-06' , 11.6 , 'amarelo' );
INSERT INTO Animais values (13 , 'Milu' , '2013-02-04' , 17.9 , 'branco' );
INSERT INTO Animais values (14 , 'Pluto' , '2012-01-03' , 12.3 , 'amarelo' );
INSERT INTO Animais values (15 , 'Pateta' ,'2015-05-01' , 17.7 , 'preto' );
INSERT INTO Animais values (16 , 'Snoopy' , '2013-07-02' , 18.2 , 'branco' );
INSERT INTO Animais values (17 , 'Rex' , '2019-11-03' , 19.7 , 'beje' );
INSERT INTO Animais values (20 , 'Bidu' , '2012-09-08' , 12.4 , 'azul' );
INSERT INTO Animais values (21 , 'Dum Dum' , '2015-04-06' , 11.2 , 'laranja' );
INSERT INTO Animais values (22 , 'Muttley' , '2011-02-03' , 14.3 , 'laranja' );
INSERT INTO Animais values (23 , 'Scooby' , '2012-01-02' , 19.9 , 'marrom' );
INSERT INTO Animais values (24 , 'Rufus' , '2014-04-05' , 19.7 , 'branco' );
INSERT INTO Animais values (25 , 'Rex' , '2021-08-19' , 19.7 , 'branco' );

/*1- Selecione todos os animais*/
SELECT * FROM Animais;


/* 2- Selecione todos os animais que pesam menos que 13.1*/
SELECT * from Animais WHERE peso < 13.1;

/*3- Selecione todos nasceram entre fevereiro e dezembro de 2015*/
SELECT * FROM Animais WHERE nasc BETWEEN '2015-02-01' and '2015-12-01';

/*4- Selecione todos os animais brancos que pesam menos que 15.0*/
SELECT * FROM Animais WHERE cor = 'branco' and peso < 15.0;

/* 5- Selecione nome, cor e peso de todos cujo nome comece com ’B’*/
SELECT nome, cor, peso FROM Animais WHERE nome LIKE 'B%';

/*6- Selecione nome, cor e peso de todos com cor vermelha, amarela, marrom e laranja*/
SELECT nome, cor, peso FROM Animais WHERE cor IN ('vermelho', 'amarelo', 'marrom', 'laranja');

/*7- Selecione nome, cor, data de nascimento e peso de todos ordenados pelos mais jovens*/
SELECT nome, cor, nasc, peso FROM Animais ORDER BY nasc DESC;

/*8- Selecione todos os animais cujo nome comece com 'C' e não sejam brancos*/
SELECT * FROM Animais WHERE nome LIKE 'C%' and cor != 'branco';

/*8.1- Selecione todos os animais cujo nome comece com 'A' e não sejam brancos*/
SELECT * FROM Animais WHERE nome LIKE 'A%' and cor != 'branco';

/*9- Selecione todos os animais cujo nome contenha 'ba'*/
SELECT * FROM Animais WHERE nome like '%ba%';

/*10 -Selecione todos os animais com peso entre 13.0 à 15.0*/
SELECT * FROM Animais WHERE peso BETWEEN 13.0 AND 15.0;

/*11-  Selecione todos os animais que o peso não seja maior que 30, com cor amarelo ou roxo e nascidos
depois de 2012*/
SELECT * FROM Animais WHERE peso < 30 and cor in ('amarelo', 'roxo') and nasc >= 2012-01-01;

/*12- (Desafio) Selecione todos os capricornianos (entre 22 de dezembro e 19 de janeiro)*/
SELECT * FROM Animais WHERE 
(DATE_FORMAT(nasc, '%m') = '12' AND DATE_FORMAT(nasc, '%d') BETWEEN '22' AND '31')
OR 
(DATE_FORMAT(nasc, '%m') = '01' AND DATE_FORMAT(nasc, '%d') BETWEEN '01' AND '19');


/* 13- (Desafio) Selecione todos os animais com nome formado por mais de uma palavra.*/
select * from Animais WHERE nome like '% %';
