<h1>Proposta:</h1>

Você foi designado para criar um sistema de gerenciamento de pedidos de uma loja.

* Código completo do exercício [aqui](https://github.com/thaisconto/Curso-ADS/blob/main/Bando_Dados/Lista_Gerenciamento_Pedidos/sql.sql).
* Obs: O execício foi elaborado através do [SQL Server da Oracle](https://dev.mysql.com/doc/) e [WAMP](https://sourceforge.net/projects/wampserver/).

<h2>Tabelas</h2>

Crie as tabelas "Clientes" e "Pedidos" com campos apropriados. Insira dados de exemplo nas tabelas para simular clientes e pedidos. Certifique-se de incluir uma chave primária em cada tabela.

<h2>Stored Procedure</h2>

Crie uma stored procedure chamada "InserirPedido" que permite inserir um novo pedido na tabela "Pedidos" com as informações apropriadas. A stored procedure deve receber parâmetros como o ID do cliente e os detalhes do pedido. Ao término teste o funcionamento da stored procedure criada inserindo um pedido.

<h2>Trigger</h2>

Crie uma trigger que seja acionada APÓS a inserção de um novo pedido na tabela "Pedidos". A trigger deve calcular o valor total dos pedidos para o cliente correspondente e atualizar um campo "TotalPedidos" na tabela "Clientes" com o valor total. Teste a Trigger inserindo um novo pedido na tabela "Pedidos“.

<h2>View</h2>

Crie uma view chamada "PedidosClientes" que combina informações das tabelas "Clientes" e "Pedidos" usando JOIN para mostrar os detalhes dos pedidos e os nomes dos clientes.

<h2> Consulta com JOIN</h2>

Escreva uma consulta SQL que utiliza JOIN para listar os detalhes dos pedidos de cada cliente, incluindo o nome do cliente e o valor total de seus pedidos. Utilize a view "PedidosClientes" para essa consulta.

<img src = view_2_2.png>


