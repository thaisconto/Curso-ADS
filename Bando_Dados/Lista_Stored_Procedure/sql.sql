/*
O aluno possui um email que deve ter seu endereço gerado automaticamente no seguinte formato:
nome.sobrenome@dominio.com
Como fica o email se duas pessoas tiverem o mesmo nome e sobrenome?
*/

-- criar tabela Curso
CREATE TABLE IF NOT EXISTS Curso (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nome_curso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_curso`)
)ENGINE = InnoDB;


-- criar tabela Aluno
CREATE TABLE IF NOT EXISTS Aluno (
  `id_aluno` INT NOT NULL AUTO_INCREMENT,
  `nome_aluno` VARCHAR(45) NOT NULL,
  `sobrenome_aluno` VARCHAR(45) NOT NULL,
  `email_aluno` VARCHAR(45) DEFAULT (`nome_aluno` + `sobrenome_aluno` + '@dominio.com'),
  `id_curso_aluno` INT NOT NULL,
  PRIMARY KEY (`id_aluno`),
  INDEX `id_curso_aluno_idx` (`id_curso_aluno` ASC) VISIBLE,
  CONSTRAINT `id_curso_aluno`
    FOREIGN KEY (`id_curso_aluno`)
    REFERENCES Curso (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;


-- criar tabela Professor
CREATE TABLE IF NOT EXISTS Professor (
  `id_professor` INT NOT NULL AUTO_INCREMENT,
  `nome_professor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_professor`)
)ENGINE = InnoDB;


-- criar tabela Professor_Curso
CREATE TABLE IF NOT EXISTS Professor_Curso (
  `pc_id_professor` INT NOT NULL,
  `pc_id_curso` INT NOT NULL,
  PRIMARY KEY (`pc_id_professor`, `pc_id_curso`),
  INDEX `pc_id_curso_idx` (`pc_id_curso` ASC) VISIBLE,
  CONSTRAINT `pc_id_curso`
    FOREIGN KEY (`pc_id_curso`)
    REFERENCES Curso (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pc_id_professor`
    FOREIGN KEY (`pc_id_professor`)
    REFERENCES Professor (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

-- ------------------------------------------------------------------------------

-- criar stored procedure: inserir dados Aluno: id, nome, sobrenome, email - nulo, id_curso

delimiter $
create procedure insert_aluno(
	id_aluno int,
    nome_aluno VARCHAR(45),
	sobrenome_aluno VARCHAR(45),
    email_aluno varchar(45),
	id_curso_aluno INT
)
begin
	INSERT INTO Aluno Values (null, nome_aluno, sobrenome_aluno, null, id_curso_aluno);
end$
delimiter ;


call insert_aluno(null, 'Thaís', 'Marchetti', null, 1);
call insert_aluno(null, 'Felipe', 'Silva', null, 1);
call insert_aluno(null, 'Felipe', 'Silva', null, 2);
call insert_aluno(null, 'Marcos', 'José', null, 3);
call insert_aluno(null, 'Robson', 'Souza', null, 4);
call insert_aluno(null, 'Gustavo', 'Souza', null, 5);


SELECT * from Aluno;

-- --------------------------------------------------------------------------------

-- criar stored procedure: inserir dados Curso: id, nome

delimiter $
create procedure insert_curso(
	`id_curso` INT,
	`nome_curso` VARCHAR(45)
)
begin
	INSERT INTO Curso Values (null, nome_curso);
end$
delimiter ;

call insert_curso(null, 'ADS');
call insert_curso(null, 'Engenharia Química');
call insert_curso(null, 'ADM');
call insert_curso(null, 'Gatronomia');
call insert_curso(null, 'Psicologia');

SELECT * from Curso;

-- ------------------------------------------------------------------------

-- criar stored procedure: inserir dados Professor: id, nome

delimiter $
create procedure insert_professor(
	`id_professor` INT,
	`nome_professor` VARCHAR(45)
)
begin
	INSERT INTO Professor Values (null, nome_professor);
end$
delimiter ;


call insert_professor(null, 'Mario');
call insert_professor(null, 'Marcelo');
call insert_professor(null, 'Rose');
call insert_professor(null, 'William');
call insert_professor(null, 'Leonardo');
call insert_professor(null, 'Júlia');

select * from Professor;

-- ----------------------------------------------------------------------------

-- criar stored procedure: inserir dados Professor_Curso: id_professor, id_curso

delimiter $
create procedure insert_professor_curso(
	`pc_id_professor` INT,
	`pc_id_curso` INT
)
begin
	INSERT INTO Professor_Curso Values (pc_id_professor, pc_id_curso);
end$
delimiter ;

call insert_professor_curso(1,1);
call insert_professor_curso(1,2);
call insert_professor_curso(2,1);
call insert_professor_curso(2,3);
call insert_professor_curso(3,1);
call insert_professor_curso(3,5);
call insert_professor_curso(4,1);
call insert_professor_curso(5,1);
call insert_professor_curso(5,4);
call insert_professor_curso(6,2);

select * from Professor_Curso;

-- --------------------------------------------------------------------------------

-- criar stored procedure para seleção de alunos com curso

delimiter $
create procedure selecao_aluno_curso(id_aluno int)
begin
	SELECT id_aluno, nome_aluno, nome_curso
	FROM Aluno
	INNER JOIN Curso
	ON id_curso_aluno = id_curso
    where aluno.id_aluno = id_aluno;
end$
delimiter ;

call selecao_aluno_curso(2);

-- -------------------------

-- criar stored procedure para seleção de professor com curso

delimiter $
create procedure selecao_professor_curso(id_professor int)
begin
	SELECT id_professor, nome_professor, nome_curso
	FROM Professor
	INNER JOIN Professor_Curso
	ON pc_id_professor = id_professor
    JOIN Curso
    ON curso.id_curso = pc_id_curso
    where professor.id_professor = id_professor;
end$
delimiter ;

call selecao_professor_curso(1);