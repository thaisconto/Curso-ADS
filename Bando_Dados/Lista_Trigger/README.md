<h1>Proposta:</h1>

* Obs: O execício foi elaborado através do [SQL Server da Oracle](https://dev.mysql.com/doc/) e [WAMP](https://sourceforge.net/projects/wampserver/).


------------------------------------------------

<h2>Exercício Pedidos</h2>
Crie uma base de dados Pedidos, que contenha: ID, data e nome do cliente. 
* O <b>código completo</b> desenvolvido para a resolução do exercício está disponibilizado [aqui]().

------------------------------------------------

Crie uma Trigger para quando o novo pedido for inserido sem fornecer a data. Mostre a inserção de dados sem e com a Trigger.

------------------------------------------------
- Criação da Trigger:

<img src = print3.png>

------------------------------------------------

- Inserção de dados sem utilizar a Trigger:

<img src = print1.png>

------------------------------------------------

- Inserção de dados utilizando a Trigger:

<img src = print2.png>

------------------------------------------------

<h2>Exercício Filmes</h2>

Crie uma base de dados Filmes, que contenha: id, titulo, minutos.
* O <b>código completo</b> desenvolvido para a resolução do exercício está disponibilizado [aqui]().

------------------------------------------------

Crie uma Trigger que não aceite a inserção de minutos negativos.

<img src = print4.png>

------------------------------------------------

Insira dados e teste se a trigger está funcionando.
Obs: observe que ao inserir -88 minutos, ele alterou para null.

<img src = print5.png>

------------------------------------------------

Crie uma trigger que avise o erro ao inserir minutos negativos.

<img src = print6.png>

------------------------------------------------

Insira dados e verifique se a Trigger esta funcionando.

<img src = print7.png>

------------------------------------------------

Crie uma Trigger que mostre as ocorrências ao deletar dados.

<img src = print8.png>

------------------------------------------------

Detele dados e verifique se a Trigger está funcionando.

<img src = print9.png>
