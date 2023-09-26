/*Crie duas tabelas conforme o modelo apresentado nos slides 61 e 62, deste material;
Preste atenção aos campos que estão no exemplo; Insira os valores conforme os slides;
Aplique o exemplo sobre inner join dado no slide 67, deste material;
Execute essas atividades dentro o Oracle Workbench; Crie um repositório remoto e envie o script em SQL;
Produza o Readme do repositório remoto e tire um print da tela após o término da atividade;
Coloque comentários em seu código.
*/

/* criando tabela cidades*/
CREATE TABLE Cidades(
id integer PRIMARY KEY,
nome varchar(60) NOT NULL,
populacao int
);

/*criando tabela alunos*/
CREATE TABLE Alunos(
id integer PRIMARY KEY,
nome varchar(60) NOT NULL,
data_nasc date,
cidade_id int,
FOREIGN KEY (cidade_id) references Cidades (id)
);

/*inserindo valores na tablea cidades*/
INSERT INTO Cidades VALUES (1, 'Arraial dos Tucanos', 42632);
INSERT INTO Cidades VALUES (2, 'Springfield', 13820);
INSERT INTO Cidades VALUES (3, 'Hill Valley', 27383);
INSERT INTO Cidades VALUES (4, 'Coruscant', 19138);
INSERT INTO Cidades VALUES (5, 'Minas Tirith', 31394);

/*inserindo valores na tabela alunos*/
INSERT INTO Alunos VALUES (1, 'Immanuel Kant', date'1724-04-22', 4);
INSERT INTO Alunos VALUES (2, 'Alan Turig', date'1912-06-23', 3);
INSERT INTO Alunos VALUES (3, 'George Boole', date'2002-01-01', 1);
INSERT INTO Alunos VALUES (4, 'Lynn Margulis', date'1991-08-12', 3);
INSERT INTO Alunos VALUES (5, 'Nicola Tesla', date'2090-01-08', null);
INSERT INTO Alunos VALUES (6, 'Ada Lovelace', date'1978-05-28', 4);
INSERT INTO Alunos VALUES (7, 'Claude Shanon', date'1982-10-15', 3);
INSERT INTO Alunos VALUES (8, 'Charles Darwin', date'2010-02-06', null);
INSERT INTO Alunos VALUES (9, 'Marie Culie', date'2007-07-12', 3);
INSERT INTO Alunos VALUES (10, 'Carl Sagan', date'2000-11-20', 1);
INSERT INTO Alunos VALUES (11, 'Tim Beners-Lee', date'1973-12-05', 4);
INSERT INTO Alunos VALUES (12, 'Richard Feynan', date'1982-09-12', 1);

/*fazendo uma consulta juntando as tabelas alunos com suas refrentes cidades */
SELECT * 
FROM Alunos inner
join Cidades
on Cidades.id = Alunos.cidade_id;
