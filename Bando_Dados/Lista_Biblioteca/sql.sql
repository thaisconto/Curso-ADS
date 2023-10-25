-- exercicio biblioteca
/*
Você foi designado para criar um sistema de biblioteca. Aqui estão os detalhes adicionais:
Tabelas:
Livros: Armazene informações sobre cada livro, incluindo título, ISBN, ano de publicação e um identificador exclusivo.
Autores: Registre informações sobre os autores, como nome, data de nascimento e nacionalidade.
Editoras: Mantenha detalhes sobre as editoras, como nome e endereço.
Empréstimos: Controle os empréstimos de livros, incluindo a data de empréstimo e de devolução, bem como o status do empréstimo (pendente, devolvido, atrasado).
Relacionamentos:
Crie relacionamentos entre "Livros" e "Autores" para associar cada livro a um ou mais autores.
Estabeleça um relacionamento entre "Empréstimos" e "Clientes" para rastrear quem pegou emprestado um livro.
Stored Procedures:
Crie uma stored procedure para registrar um novo empréstimo, verificando a disponibilidade do livro e atualizando o estoque.
Crie outra stored procedure para recuperar a lista de livros emprestados por um cliente específico.
Implemente uma stored procedure que calcule multas para empréstimos atrasados.
Views:
Crie uma view que mostre os livros disponíveis para empréstimo, excluindo aqueles que já foram emprestados.
Implemente uma view que forneça uma lista de todos os empréstimos atuais, incluindo os detalhes dos livros emprestados e dos clientes.
*/