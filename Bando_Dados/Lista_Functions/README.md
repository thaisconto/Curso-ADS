<h1>Proposta:</h1>

Você foi designado para criar um sistema para uma universidade.

* Código completo do exercício [aqui](https://github.com/thaisconto/Curso-ADS/blob/main/Bando_Dados/Lista_Functions/sql_function.sql).
* Obs: O execício foi elaborado através do [SQL Server da Oracle](https://dev.mysql.com/doc/) e [WAMP](https://sourceforge.net/projects/wampserver/).

<h2>Modelo lógico:</h2>
Crie um banco de dados para armazenar alunos e cursos de uma universidade. Cada curso pode pertencer a somente uma área.
Obs: O aluno possui um e-mail que deve ter seu endereço gerado automaticamente no seguinte formato: nome.sobrenome@dominio.com

<img src = modelo_logico.png>

----------------------------------------------------------------------------

<h2>Stored Procedure</h2>

• Utilize Stored Procedures para automatizar a inserção de alunos

<img src = print_stored_procedure_insert_aluno_1.png>
<img src = print_stored_procedure_insert_aluno_2.png>
<img src = print_stored_procedure_insert_aluno_3.png>

----------------------------------------------------------------------------

• Utilize Stored Procedures para automatizar a inserção de áreas.

<img src = print_stored_procedure_insert_area_1.png>
<img src = print_stored_procedure_insert_area_2.png>


----------------------------------------------------------------------------

• Utilize Stored Procedures para automatizar a inserção de cursos.

<img src = print_stored_procedure_insert_curso_1.png>
<img src = print_stored_procedure_insert_curso_2.png>

----------------------------------------------------------------------------

• Crie uma procedure que recebe os dados do aluno e de um curso e faz sua matrícula. Caso o aluno já esteja matriculado em um curso, essa matrícula não pode ser realizada;

<img src = print_stored_procedure_nova_matricula_1.png>

----------------------------------------------------------------------------

<h2>View</h2>
• Utilize um View para selecionar os cursos e suas áreas.

<img src = print_view_curso_e_area_1.png>

----------------------------------------------------------------------------

<h2>Function</h2>

• Crie uma função que recebe o nome de um curso e sua área, em seguida retorna o id do curso;

<img src = print_function_obter_id_curso_1.png>
<img src = print_function_obter_id_curso_2.png>

