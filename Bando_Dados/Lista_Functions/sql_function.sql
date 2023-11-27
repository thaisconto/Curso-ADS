
CREATE DATABASE Universidade;
USE Universidade;

-- -----------------------------------------------------
-- Criando tabelas
-- -----------------------------------------------------

-- tabela Areas
CREATE TABLE IF NOT EXISTS Areas (
  id_area INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_area)
);

-- Tabela cursos
CREATE TABLE IF NOT EXISTS Cursos (
  id_curso INT NOT NULL AUTO_INCREMENT,
  nome_curso VARCHAR(45) NOT NULL,
  duracao_meses INT NOT NULL,
  area_id INT NOT NULL,
  PRIMARY KEY (id_curso),
  FOREIGN KEY (area_id) REFERENCES Areas (id_area)
);

-- Tabela alunos
CREATE TABLE IF NOT EXISTS Alunos (
  id_aluno INT NOT NULL AUTO_INCREMENT,
  nome_aluno VARCHAR(45) NOT NULL,
  sobrenome_aluno VARCHAR(45) NOT NULL,
  cpf_aluno VARCHAR(45) NOT NULL UNIQUE,
  email_aluno VARCHAR(45),
  PRIMARY KEY (id_aluno)
);

-- Tabela matriculas
CREATE TABLE IF NOT EXISTS Matriculas (
  id_matricula INT NOT NULL AUTO_INCREMENT,
  aluno_id INT NOT NULL,
  curso_id INT NOT NULL,
  PRIMARY KEY (id_matricula),
  FOREIGN KEY (aluno_id) REFERENCES Alunos (id_aluno),
  FOREIGN KEY (curso_id) REFERENCES Cursos (id_curso)
);

-- -----------------------------------------------------
-- Stored procedure: aidiconar aluno 
-- -----------------------------------------------------
-- O aluno possui um e-mail gerado automaticamente no seguinte formato: nome.sobrenome@dominio.com
delimiter $
create procedure insert_aluno(
	id_aluno int,
    nome_aluno VARCHAR(45),
	sobrenome_aluno VARCHAR(45),
    cpf_aluno varchar(45)
)
begin
	DECLARE email_base VARCHAR(255);
    DECLARE email VARCHAR(255);
    DECLARE i INT;
	
    -- setar email_base
    SET email_base  = CONCAT (nome_aluno, ".", sobrenome_aluno, "@dominio.com");
    
    -- verificar se já existe
    SET i = 0;
    REPEAT
        SET i = i + 1;
        SET email = IF (i = 1, email_base, CONCAT(i, email_base));
		UNTIL NOT EXISTS (SELECT 1 FROM Alunos WHERE email_aluno = email) 
    END REPEAT;
    
    -- inserir dados
	INSERT INTO Alunos (id_aluno, nome_aluno, sobrenome_aluno, cpf_aluno, email_aluno)
    Values (null, nome_aluno, sobrenome_aluno, cpf_aluno, email);
end$
delimiter ;

drop procedure insert_aluno;

call insert_aluno(null, 'Nome', 'Sobrenome1', 'CPF 1');
call insert_aluno(null, 'Nome', 'Sobrenome2', 'CPF 2');
call insert_aluno(null, 'Nome', 'Sobrenome3', 'CPF 3');
call insert_aluno(null, 'Nome', 'Sobrenome4', 'CPF 4');
call insert_aluno(null, 'Nome', 'Sobrenome5', 'CPF 5');

SELECT * from Alunos;

-- -----------------------------------------------------
-- Stored procedure: automatizar a inserção area;
-- -----------------------------------------------------
delimiter $
create procedure insert_area(
	id_area int,
    nome VARCHAR(45)
)
begin
	   
    -- inserir dados
	INSERT INTO Areas (id_area, nome)
    Values (null, nome);
end$
delimiter ;

call insert_area (null, 'Area 1');
call insert_area (null, 'Area 2');
call insert_area (null, 'Area 3');
call insert_area (null, 'Area 4');
call insert_area (null, 'Area 5');

Select * from Areas;
-- -----------------------------------------------------
-- Stored procedure: automatizar a inserção dos cursos;
-- -----------------------------------------------------
delimiter $
create procedure insert_curso(
	id_curso int,
    nome_curso VARCHAR(45),
	duracao_meses VARCHAR(45),
    area_id varchar(45)
)
begin
	   
    -- inserir dados
	INSERT INTO Cursos (id_curso, nome_curso, duracao_meses, area_id)
    Values (null, nome_curso, duracao_meses, area_id);
end$
delimiter ;

call insert_curso (null, 'Curso 1', 10 , 1);
call insert_curso (null, 'Curso 2', 5 , 1);
call insert_curso (null, 'Curso 3', 20 , 2);
call insert_curso (null, 'Curso 4', 18 , 3);
call insert_curso (null, 'Curso 5', 30 , 4);

select * from Cursos;

-- -----------------------------------------------------
-- View: seleção dos cursos;
-- -----------------------------------------------------
CREATE VIEW Cursos_e_Areas as
SELECT Areas.nome as Area, Cursos.nome_curso, Cursos.duracao_meses
FROM Cursos
INNER JOIN Areas
ON area_id = id_area;

SELECT * FROM Cursos_e_Areas;



-- -----------------------------------------------------
-- Stored procedure: recebe os dados do aluno e de um curso e faz sua matrícula. 
-- Caso o aluno já esteja matriculado em um curso, essa matrícula não pode ser realizada;
-- -----------------------------------------------------
delimiter $
create procedure nova_matricula (
 IN alunoNome VARCHAR(50),
 IN alunoSobrenome VARCHAR(50),
 IN alunoEmail VARCHAR(100),
 IN alunoCPF VARCHAR(100),
 IN cursoNome VARCHAR(100),
 IN cursoArea VARCHAR(50)
)
begin
	DECLARE alunoID INT;
    DECLARE cursoID INT;

    -- Verificar se o aluno já está matriculado em algum curso
    SELECT id_aluno INTO alunoID
    FROM Alunos
    WHERE email_aluno = alunoEmail;

    IF alunoID IS NOT NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'O aluno já está matriculado em outro curso';
    END IF;

    -- Inserir o aluno
    call insert_curso (null, alunoNome, alunoSobrenome, alunoCPF);
    SET alunoID = LAST_INSERT_ID();

    -- Obter o ID do curso
    SET cursoID = obter_ID_curso(cursoNome, cursoArea);

    IF cursoID IS NOT NULL THEN
        -- Matricular o aluno no curso
        INSERT INTO Matriculas (aluno_id, curso_id) VALUES (alunoID, cursoID);
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Curso não encontrado';
    END IF;
    
end$
delimiter ;

-- call nova_matricula (Nome, Sobrenome, email, CPF, nome curso, curso area);
call nova_matricula ('Nome','Sobrenome 1',null, 'CPF 1', 'Curso 2', 'Area 1');


-- -----------------------------------------------------
-- Function: recebe o nome de um curso e sua área, em seguida retorna o id do curso 
-- -----------------------------------------------------
delimiter $$
CREATE FUNCTION obter_ID_curso (
	novo_nome_curso VARCHAR(100),
    novo_nome_area VARCHAR(50)
) 
    RETURNS INT
    
BEGIN
    
    DECLARE novo_curso_id INT;

    SELECT Cursos.id_curso INTO novo_curso_id
    FROM Cursos
    WHERE nome_curso = novo_nome_curso AND area_id = (  SELECT id_area
                                                        FROM Areas
                                                        WHERE nome = novo_nome_area);
    RETURN novo_curso_id;
    
END $$
delimiter ;

drop function obter_ID_curso;

select obter_ID_curso ('Curso 2', 'Area 1');
SELECT * FROM Cursos;