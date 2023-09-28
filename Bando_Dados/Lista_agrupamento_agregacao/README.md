<h1>Proposta:</h1>
Foi proposto a criação de uma tabela Produtos, onde:

- Possua os itens: id_produto, nome, preço, estoque, perecível, marca e nacionalidade;
- Atribua a cada campo seu respectivo tipo;
- Os itens: nome, preço, estoque e perecível não poderão receber valores nulos;
- O id_produto deve ser utilizado como chave-primaria;
- Insira cinco produtos.

O execício foi elaborado através do [SQL Server da Oracle](https://dev.mysql.com/doc/) e [WAMP](https://sourceforge.net/projects/wampserver/).

O <b>código SQL completo</b> desenvolvido para a resolução do exercício está disponibilizado [aqui](https://github.com/thaisconto/Curso-ADS/blob/main/Bando_Dados/Lista2/sql.sql).

Após a criação da tabela, foi lançado o desafio de criar uma sequência de relatórios que serão apresentados a seguir:

- Verifique se todos os dados foram inseridos;
<img src = select1.png>

 
- Gere um relatório informando quantos produtos estão cadastrados;
<img src = select2.png>


- Gere um relatório informando o preço médio dos produtos;
<img src = select3.png>
 
  
- Selecione a média dos preços dos produtos em 2 grupos: perecíveis e não
perecíveis;
<img src = select4.png>


- Selecione a média dos preços dos produtos agrupados pelo nome do produto;
<img src = select5.png>

 
- Selecione a média dos preços e total em estoque dos produtos;
<img src = select6.png>
  
  
- Selecione o nome, marca e quantidade em estoque do produto mais caro;
<img src = select7.png>

  
- Selecione os produtos com preço acima da média;
<img src = select8.png>
 
  
- Selecione a quantidade de produtos de cada nacionalidade
<img src = select9.png>

