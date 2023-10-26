CREATE DATABASE Biblioteca;
USE Biblioteca;
-- exercicio biblioteca

-- ------------------------------------------------------------------
-- Criando tabelas
-- ------------------------------------------------------------------
-- Tabela Editoras
CREATE TABLE IF NOT EXISTS Editoras (
  id_editora INT NOT NULL AUTO_INCREMENT,
  nome_editora VARCHAR(45) NOT NULL,
  endereco_editora VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_editora)
);

-- Tabela Livros
CREATE TABLE IF NOT EXISTS Livros (
  id_livro INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(45) NOT NULL,
  numero_isbn VARCHAR(45) NOT NULL UNIQUE,
  ano_publicacao DATE NOT NULL,
  editora_id INT NOT NULL,
  PRIMARY KEY (id_livro),
  FOREIGN KEY (editora_id) REFERENCES Editoras (id_editora)
);

-- Tabela Autores
CREATE TABLE IF NOT EXISTS Autores (
  id_autor INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  data_nascimento DATE NOT NULL,
  nacionalidade VARCHAR(45) DEFAULT 'Brasil',
  PRIMARY KEY (id_autor)
);

-- Tabela Emprestimos
CREATE TABLE IF NOT EXISTS Emprestimos (
  id_emprestimo INT NOT NULL AUTO_INCREMENT,
  data_emprestimo DATE NOT NULL, -- DEFAULT NOW()
  data_devolucao DATE NOT NULL, -- AS (DATEADD (day, 7, GETDATE('data_emprestimo')) ),
  status ENUM ('pendente', 'devolvido', 'atrasado'),
  livro_id INT NOT NULL,
  cliente_id INT NOT NULL,
  multa DECIMAL (10,2),
  PRIMARY KEY (id_emprestimo),
  FOREIGN KEY (cliente_id) REFERENCES Clintes (id_cliente),
  FOREIGN KEY (livro_id) REFERENCES Livros (id_livro),
  CHECK (data_devolucao > data_emprestimo)
);

-- Tabela Livros_Autores
CREATE TABLE IF NOT EXISTS Livros_Autores (
  la_livro_id INT NOT NULL,
  la_autor_id INT NOT NULL,
  PRIMARY KEY (la_livro_id, la_autor_id),
  FOREIGN KEY (la_livro_id) REFERENCES Livros (id_livro),
  FOREIGN KEY (la_autor_id) REFERENCES Autores (id_autor)
);

-- Tabela Clientes
CREATE TABLE IF NOT EXISTS Clientes (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_cliente)
);


-- Tabela Emprestimos_Clientes
CREATE TABLE IF NOT EXISTS Emprestimos_Clientes (
  ec_emprestimo_id INT NOT NULL,
  ec_cliente_id INT NOT NULL,
  PRIMARY KEY (ec_emprestimo_id, ec_cliente_id),
  FOREIGN KEY (ec_emprestimo_id) REFERENCES Emprestimo (id_emprestimo),
  FOREIGN KEY (ec_cliente_id) REFERENCES Clientes (id_cliente)
);


-- verificando tabelas criadas
desc autores;
desc clientes;
desc emprestimos_clientes;
desc emprestimos;
desc livros;
desc editoras;
desc livros_autores;


-- ------------------------------------------------------------------
-- inserindo dados
-- ------------------------------------------------------------------

-- editora: id, nome, endereco
INSERT INTO Editoras VALUES (null, "Editora 1", "endereco aa");
INSERT INTO Editoras VALUES (null, "Editora 2", "endereco bb");
INSERT INTO Editoras VALUES (null, "Editora 3", "endereco cc");
INSERT INTO Editoras VALUES (null, "Editora 4", "endereco dd");
INSERT INTO Editoras VALUES (null, "Editora 5", "endereco ee");

select * from editoras;

-- livros: id, titulo, isbn, ano, editora_id
INSERT INTO Livros VALUES (null, "Livro 1", "1111", "2021-01-01", 1);
INSERT INTO Livros VALUES (null, "Livro 2", "2222", "2022-01-01", 2);
INSERT INTO Livros VALUES (null, "Livro 3", "3333", "2023-01-01", 3);
INSERT INTO Livros VALUES (null, "Livro 4", "4444", "2020-01-01", 2);
INSERT INTO Livros VALUES (null, "Livro 5", "5555", "2020-01-01", 3);

select * from livros;

-- autores: id, nome, nasc, nacionalidade
INSERT INTO Autores VALUES (null, "Autor 1", "1988-10-21", "brasil");
INSERT INTO Autores VALUES (null, "Autor 2", "1994-09-13", "americano");
INSERT INTO Autores VALUES (null, "Autor 3", "1960-01-07", "portugues");
INSERT INTO Autores VALUES (null, "Autor 4", "1990-04-09", "chileno");
INSERT INTO Autores VALUES (null, "Autor 5", "1900-02-07", "brasileiro");

select * from autores;

-- clientes: id, nome, cpf
INSERT INTO Clientes VALUES (null, "Cliente 1", "1111");
INSERT INTO Clientes VALUES (null, "Cliente 2", "2222");
INSERT INTO Clientes VALUES (null, "Cliente 3", "3333");
INSERT INTO Clientes VALUES (null, "Cliente 4", "4444");
INSERT INTO Clientes VALUES (null, "Cliente 5", "5555");

select * from clientes;

-- livros_autores
INSERT INTO  livros_autores VALUES (1,1);
INSERT INTO  livros_autores VALUES (1,2);
INSERT INTO  livros_autores VALUES (2,2);
INSERT INTO  livros_autores VALUES (3,1);
INSERT INTO  livros_autores VALUES (4,3);
INSERT INTO  livros_autores VALUES (5,4);
INSERT INTO  livros_autores VALUES (3,5);

select * from livros_autores;

-- EMPRESTIMOS: id, data_emprestimo, data_devolução, status, livro_id, cliente_id
INSERT INTO Emprestimos VALUES (null, "2023-10-25", "2023-10-31", "pendente", 1, 1, null);
INSERT INTO Emprestimos VALUES (null, "2022-10-25", "2022-10-31", "devolvido", 1, 2, null);
INSERT INTO Emprestimos VALUES (null, "2023-10-10", "2023-10-21", "atrasado", 2, 3, null);
INSERT INTO Emprestimos VALUES (null, "2023-10-24", "2023-11-01", "pendente", 3, 4, null);
INSERT INTO Emprestimos VALUES (null, "2023-10-14", "2023-10-20", "devolvido", 4, 4, null);
INSERT INTO Emprestimos VALUES (null, "2023-10-14", "2023-10-20", "pendente", 5, 5, null);

select * from emprestimos;


-- ------------------------------------------------------------------
-- Stored Procedures:
-- ------------------------------------------------------------------

-- registrar um novo empréstimo, verificando a disponibilidade do livro e atualizando o estoque.
delimiter $
create procedure novo_emprestimo (
  novo_id_emprestimo int,
  novo_data_emprestimo DATE,
  novo_data_devolucao DATE,
  novo_status ENUM ('pendente', 'devolvido', 'atrasado'),
  novo_livro_id INT,
  novo_cliente_id INT
)
BEGIN
	-- Verificar se o livro está disponível
    DECLARE estoque int;
    select count(*) into estoque 
    from Emprestimos
    WHERE livro_id = novo_livro_id AND (status = 'pendente' OR 'atrasado');
    
    -- se estiver disponível, registra o novo empréstimo
    IF estoque = 0 THEN
		INSERT INTO Emprestimos (id_emprestimo, data_emprestimo, data_devolucao, status, livro_id, cliente_id)
        VALUES (novo_id_emprestimo, novo_data_emprestimo, novo_data_devolucao, novo_status, novo_livro_id, novo_cliente_id);
	
		-- mensagem informando se registrou ou não
		SELECT 'Empréstimo realizado' AS mensagem;
    ELSE
		SELECT 'Livro não disponível' AS mensagem;
	END IF;

END$
DELIMITER ;

CALL novo_emprestimo (NULL, "2023-10-25", "2023-10-31", "pendente", 4, 1);

CALL novo_emprestimo (NULL, "2023-10-25", "2023-10-31", "pendente", 1, 1);

-- ----------------------------------------------------------------------------
-- recuperar a lista de livros emprestados por um cliente específico.
delimiter $
create procedure emprestimos_por_cliente (
	cliente_id int
)
BEGIN
	SELECT Emprestimos.data_emprestimo, Emprestimos.data_devolucao, Emprestimos.status, Livros.id_livro
	FROM Emprestimos
    INNER JOIN Livros 
    ON Emprestimos.livro_id = Livros.id_livro
    WHERE Emprestimos.cliente_id = cliente_id;
    
END$
DELIMITER ;

call emprestimos_por_cliente (1);

-- --------------------------------------------------------------------------------------------
-- calcule multas para empréstimos atrasados.
DELIMITER $
CREATE PROCEDURE calcular_multas (
	consulta_cliente_id int
)
BEGIN
	-- declarando e definindo o valor da multa por dia
    DECLARE multa DECIMAL (10,2);
    SET multa = 0.50;  -- ajustar o valor da multa conforme necessidade
    
    -- primeiro: alterar o pendente para atrasado se for necessário
    UPDATE Emprestimos
    SET status = 'atrasado'
    WHERE data_devolucao < now() 
    AND status = 'pendente' 
    AND consulta_cliente_id = cliente_id;
          
    -- calcular a multa 
    UPDATE Emprestimos
    SET multa = DATEDIFF(CURDATE(), data_devolucao) * multa
    WHERE status = 'atrasado'
    AND cliente_id = consulta_cliente_id;
           
    -- mostrando valor da multa atualizado
    SELECT Emprestimos.multa, Emprestimos.status, Clientes.nome, Livros.titulo
	FROM Emprestimos
    JOIN Clientes 
    ON Emprestimos.cliente_id = Clientes.id_cliente
    JOIN Livros
	ON Emprestimos.livro_id = Livros.id_livro
	WHERE Emprestimos.cliente_id = consulta_cliente_id
    AND Emprestimos.status = "atrasado";    
END$
DELIMITER ;

call calcular_multas(3);

-- ------------------------------------------------------------------
-- Views:
-- ------------------------------------------------------------------

-- mostre os livros disponíveis para empréstimo, excluindo aqueles que já foram emprestados.
-- ??????????????????????????? arrumar
CREATE VIEW livros_disponiveis AS
	SELECT Livros.titulo, Livros.numero_isbn, Livros.ano_publicacao, Autores.nome 
    AS autor, Editoras.nome_editora AS editora
	FROM Livros
	INNER JOIN Autores ON Livros.autor_id = Autores.id_autor
	INNER JOIN Editoras ON Livros.editora_id = Editoras.id_editora
	WHERE Livros.id_livro NOT IN (
        SELECT livro_id
		FROM Emprestimos
		WHERE status = 'pendente' OR status = 'atrasado'
);

-- forneça uma lista de todos os empréstimos atuais, incluindo os detalhes dos livros emprestados e dos clientes.
-- ???????????????? arrumar
CREATE VIEW lista_emprestimos AS
	SELECT E.emprestimo_id, L.titulo, C.nome AS cliente, E.data_emprestimo, E.data_devolucao, E.status
	FROM Emprestimos E
	INNER JOIN Livros L ON E.livro_id = L.livro_id
	INNER JOIN Clientes C ON E.cliente_id = C.cliente_id;