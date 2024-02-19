const nome = "Edson"

// pega a letra na posição 3
console.log(nome.charAt(3))

//pega o código decimal da tabela axe - modo que compitador entende as letras
console.log(nome.charCodeAt(3)) 

// troca um padrão por outro
console.log(nome.replace("so", "XX"))

// retorna o tamanho da string
console.log(nome.length)

// verifica se termina com "n"
console.log(nome.endsWith("n"))

// verifica o index do caractere
console.log(nome.indexOf("d"))

// pega um pedaço da string: da posição 0 a 3
console.log(nome.substring(0, 3))

// deixa maiusculo
console.log(nome.toLocaleUpperCase())

// dividi a string naquele caractere vírgula, então vai gerar 3 variaveis - array/vetor
console.log("Ana,Maria,José".split(","))

// junta strings
console.log(nome.concat(' Martin '.concat('Feitosa')))

// concatenação
let concatenacao = "Olá "+ nome + "!"
console.log(concatenacao)

//template string
let template = `Olá ${nome}!`
console.log(template)

//expressões
console.log(`1 + 1 = ${1 + 1}`)

//criando uma função dentro de uma variável
//string up(string texto){ return texto.toUpperCase();}
const up = texto => texto.toUpperCase();
console.log(`Ei! ${up('Cuidado')}!`)
