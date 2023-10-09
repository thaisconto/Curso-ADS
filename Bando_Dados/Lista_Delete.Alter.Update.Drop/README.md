<h1>Proposta:</h1>
Foi proposto a criação de duas tabelas com relacionamento entre si:

- Cidades: id, nome e população.
- Alunos: id, nome, data de nascimento e cidade.

Após a criação das tabelas foi lançado o desafio para elaborar as seguintes ações:
Após a criação de uma nova base, execute os códigos abaixo:

Altere o nome do Pateta para Goofy;

Altere o peso do Garfield para 10 quilogramas;

Altere a cor de todos os gatos para laranja;

Crie um campo altura para os animais;

Crie um campo observação para os animais;

Remova todos os animais que pesam mais que 200 quilogramas.

Remova todos os animais que o nome inicie com a letra ‘C’.

Remova o campo cor dos animais;

Aumente o tamanho do campo nome dos animais para 80 caracteres;

Remova todos os gatos e cachorros.

Remova o campo data de nascimento dos animais.

Remova todos os animais.

Remova a tabela especies.

O execício foi elaborado através do [SQL Server da Oracle](https://dev.mysql.com/doc/) e [WAMP](https://sourceforge.net/projects/wampserver/).

O <b>código completo</b> desenvolvido para a resolução do exercício está disponibilizado [aqui](https://github.com/thaisconto/Curso-ADS/blob/main/Bando_Dados/Lista_InnerJoin/sql_ex2_aula7.sql).


------------------------------------------------
- Fazendo uma consulta juntando as tabelas alunos com suas referentes cidades, de duas formas:

   Inner Join
<img src = innerjoin.png>


Join on

<img src = joinon.png>

 -------------------------------------------------------
- Usando left join para deixar na ordem do id dos alunos;
<img src = leftjoin.png>

 -------------------------------------------------------
- Usando right join para deixar na ordem do id das cidades;
<img src = rightjoin.png>
 
  
