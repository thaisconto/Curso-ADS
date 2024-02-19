let isAtivo = true

console.log(isAtivo)
isAtivo = 1
console.log(!!isAtivo)
console.log("os verdadeiros...")
console.log(!!3)
console.log(!!-1)
console.log(!!' ')
console.log(!![])
console.log(!!{})
console.log(!!(isAtivo = true))
console.log(!!Infinity)
console.log('os falsos...')
console.log(!!0)
console.log(!!'')
console.log(!!null)
console.log(!!NaN)
console.log(!!undefined)
console.log(!!(isAtivo = false))
console.log('para finalizar...')
console.log(!!('' || null || 0 || ' '))
//forma de usar expressão lógica para definir valor padrão
let nome = ''
//numa expressão lógica o javascript pega o 1º valor válido
console.log(nome || 'Desconhecido') 
