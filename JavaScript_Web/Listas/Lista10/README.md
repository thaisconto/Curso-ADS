# Exercicio AJAX + Métodos HTTP

Hoje é o seu primeiro dia como desenvolvedor frontend web e como primeiro
trabalho, precisa desenvolver uma tela de cadastro de funcionário.

A tela deve ter as seguintes informações:
   
    • Dados Pessoais
        o Nome
        o Telefone
        o E-mail
        o CPF
        o RG

    • Cargo
        o Nome
        o Salário

    • Setor
        o Sigla
        o Nome

    • Convênio
        o Nome
        o Valor para o titular
        o Valor para o dependente

O cargo, setor e convênio devem ser selecionados pelo usuário, onde ao selecionar completa as demais informações. Para isso, utilize os seguintes web services:

    • https://aulalp2024.free.beeceptor.com/setor
    • https://aulalp2024.free.beeceptor.com/cargo
    • https://aulalp2024.free.beeceptor.com/convenio


Para salvar as informações foi passado o web service:

    • https://66266bc2052332d55322d1f0.mockapi.io/funcionario

Importante: O chefe requisitou que os dados de cargo, setor e convênio devem ser baixados em paralelo no momento que a tela de cadastro é carregada com o método Promise.All.

### Resulução

Foi criada a minha própria webservice:

https://exercicio.free.beeceptor.com/cargo
https://exerciciothais.free.beeceptor.com/

Tela antes de selecionar:

Tela após selecionar um cargo (com campos preenchidos automaticamente)



Código
[HTML](https://github.com/thaisconto/Curso-ADS/tree/main/JavaScript_Web/Listas/Lista10/exercicio.html)
[CSS](https://github.com/thaisconto/Curso-ADS/tree/main/JavaScript_Web/Listas/Lista10/exercicio.css)
[JS](https://github.com/thaisconto/Curso-ADS/tree/main/JavaScript_Web/Listas/Lista10/exercicio.js)
