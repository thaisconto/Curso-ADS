//entendendo a diferença entre const, var e let
const a = 0
var x; // var tem escopo global
let y // let tem escopo dentro das chaves
z = 1

console.log(a) // 0
console.log(x) // undefined
console.log(y) // undefined
console.log(z) // 1

//imprimindo os tipos de variáveis
t = 'a'
console.log(typeof t) // string
t = 1
console.log(typeof t) // number
t = 1.12
console.log(typeof t) // number

//escopo
var n1 = 10
if (true) {
    var n2 = 20 
    let n3 = 30
    
    console.log(n1)
    console.log(n2)
    console.log(n3)
}

console.log(n1) //var funciona fora do escopo
console.log(n2) //var funciona fora do escopo
console.log(n3) // não vai encontrar porque é let e está fora do escopo dela
