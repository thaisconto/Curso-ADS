// EXERCICIO 1
exports.ex1 = (req, res) => {
    const palavra = req.query.palavra;
    let qtdeVogais = 0;
    for (let i = 0; i < palavra.length; i++) {
        if (palavra[i].toLowerCase() === 'a' ||
            palavra[i].toLowerCase() === 'e' ||
            palavra[i].toLowerCase() === 'i' ||
            palavra[i].toLowerCase() === 'o' ||
            palavra[i].toLowerCase() === 'u') {
            qtdeVogais++;
        }
    }
    res.json({ "quantidade de vogais:": qtdeVogais });
};


// EXERCICIO 2
exports.ex2 = (req, res) => {
    const capitalInicial = parseFloat(req.query.capitalInicial);
    const taxaJuros = parseFloat(req.query.taxaJuros);
    const tempo = parseFloat(req.query.tempo); 
    let montante = capitalInicial * Math.pow((1 + taxaJuros), tempo);
    res.json({ "montante:": montante });
};

// EXERCICIO 3
exports.ex3 = (req, res) => {
    const palavra = req.query.palavra;
    const caractere = req.query.caractere;
    let qtdeCaractere = 0;

    for (let i = 0; i < palavra.length; i++) {
        if (palavra[i].toLowerCase() === caractere) {
            qtdeCaractere++;
        }
    }
    
    res.json({ "quantidade_caracteres": qtdeCaractere });
};


// EXERCICIO 4
exports.ex4 = (req, res) => {
    const ano = parseInt(req.query.ano, 10);

    if ((ano % 4 === 0 && ano % 100 !== 0) || ano % 400 === 0) {
        res.json({ "Mensagem": "É um ano bissexto" });
    } else {
        res.json({ "Mensagem": "NÃO é um ano bissexto" });
    }
};


// EXERCICIO 5 -- Escreva uma função que recebe um array de números e retorna uma mensagem dizendo qual é o menor e o maior número.
exports.ex5 = (req, res) => {
    const numeros = req.query.numeros.split(';').map(Number);
    let menor = Infinity;
    let maior = -Infinity;

    for (let i = 0; i < numeros.length; i++) {
        if (numeros[i] < menor) {
            menor = numeros[i];
        }
        if (numeros[i] > maior) {
            maior = numeros[i];
        }
    }

    res.json({ "Maior numero": maior, "Menor numero": menor });
};


// EXERCICIO 6 -- Escreva uma função que simule uma loteria, onde o usuário escolhe 6 números e o programa sorteia 6 números aleatórios, verificando quantos números o usuário acertou.
exports.ex6 = (req, res) => {
    const numeros = req.query.numeros.split(';').map(Number);
    const numerosSorteados = [];
    let acertos = 0;

    // Gerar 6 números aleatórios únicos entre 1 e 60
    while (numerosSorteados.length < 6) {
        const num = Math.floor(Math.random() * 60) + 1;
        if (!numerosSorteados.includes(num)) {
            numerosSorteados.push(num);
        }
    }

    // Verificar os acertos
    for (let i = 0; i < numeros.length; i++) {
        if (numerosSorteados.includes(numeros[i])) {
            acertos++;
        }
    }

    res.json({ "Números sorteados": numerosSorteados, "Você acertou": acertos });
};