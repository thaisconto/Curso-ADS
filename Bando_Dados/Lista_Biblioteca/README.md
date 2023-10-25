<h1>Proposta:</h1>

Você foi designado para criar um sistema de biblioteca.

* Código completo do exercício [aqui](https://github.com/thaisconto/Curso-ADS/blob/main/Bando_Dados/Lista_Biblioteca/sql.sql).
* Obs: O execício foi elaborado através do [SQL Server da Oracle](https://dev.mysql.com/doc/) e [WAMP](https://sourceforge.net/projects/wampserver/).

<h2>Tabelas:</h2>

As tabelas devem incluir: 

* **Livros:** Armazene informações sobre cada livro, incluindo título, ISBN, ano de publicação e um identificador exclusivo;
* **Autores:** Registre informações sobre os autores, como nome, data de nascimento e nacionalidade;
* **Editoras:** Mantenha detalhes sobre as editoras, como nome e endereço;
* **Empréstimos:** Controle os empréstimos de livros, incluindo a data de empréstimo e de devolução, bem como o status do empréstimo (pendente, devolvido, atrasado);
* **Relacionamentos:** entre "Livros" e "Autores" para associar cada livro a um ou mais autores; e entre "Empréstimos" e "Clientes" para rastrear quem pegou emprestado um livro.

<img src = modelo_logico.png>

----------------------------------------------------------------

<h2>Stored Procedures:</h2>

* Registrar um novo empréstimo, verificando a disponibilidade do livro e atualizando o estoque.

<img src = stored_procedure_1.png>

* Recuperar a lista de livros emprestados por um cliente específico.

<img src = stored_procedure_2.png>

* Calcule multas para empréstimos atrasados.

<img src = stored_procedure_3.png>

----------------------------------------------------------------

<h2>Views:</h2>

* Mostre os livros disponíveis para empréstimo, excluindo aqueles que já foram emprestados.

<img src = view_1.png>

* Forneça uma lista de todos os empréstimos atuais, incluindo os detalhes dos livros emprestados e dos clientes.

<img src = view_2.png>

------------------------------------------------
