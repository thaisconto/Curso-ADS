/*
• Crie uma rotina que recebe os dados de um novo curso e o insere no banco de dados;
• Crie uma função que recebe o nome de um curso e sua área, em seguida retorna o id do
curso;
*/
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
  email_aluno VARCHAR(45) NULL,
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
-- Trigger: gerar email
-- -----------------------------------------------------
-- O aluno possui um e-mail gerado automaticamente no seguinte formato: nome.sobrenome@dominio.com
DELIMITER $
CREATE TRIGGER gerar_email_automatico
	AFTER INSERT ON Alunos  
    FOR EACH ROW
    BEGIN	
		UPDATE Alunos
		SET email_aluno = concat(nome_aluno, ".", sobrenome_aluno, "@dominio.com") 
		WHERE Alunos.id_aluno = NEW.id_aluno;
                  
END;
    $
DELIMITER ;

drop TRIGGER gerar_email_automatico;
INSERT INTO Alunos VALUES (null, 'thais', 'marchetti', '1', null);
select * from Alunos;
-- -----------------------------------------------------
-- Stored procedure
-- -----------------------------------------------------
-- Utilize Stored Procedures para automatizar a inserção e seleção dos cursos;
-- Crie uma procedure que recebe os dados do aluno e de um curso e faz sua matrícula;
-- Caso o aluno já esteja matriculado em um curso, essa matrícula não pode ser realizada;

delimiter $
create procedure nova_matricula (
  id_aluno INT,
  nome_aluno VARCHAR(45),
  sobrenome_aluno VARCHAR(45),
  cpf VARCHAR(45),
  id_matricula INT,
  curso_id INT
)
begin
	
    
    -- inserir dados alunos
	INSERT INTO Alunos (id_aluno, nome_aluno, sobrenome_aluno, cpf_aluno, email_aluno)
    Values (null, nome_aluno, sobrenome_aluno, cpf_aluno, email);
    
    -- inserir dados matricula
    INSERT INTO Matriculas (id_matricula, aluno_id, curso_id)
    Values (null, id_aluno, curso_id);
    
end$
delimiter ;

drop procedure nova_matricula;