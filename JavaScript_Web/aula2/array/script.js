/*
Dado um array de números:
• Encontre o primeiro número maior que 10.
• Filtre os números pares.
• Crie um novo array com o dobro de cada número.
*/

let numeros = [2,5,8,10,12];

console.log(`vetor: ${numeros}`);

console.log("Maior que 10 é:")
console.log(numeros.find(a => a > 10));

console.log("Números pares são:")
let pares = numeros.filter((numero) => {
    return numero % 2 == 0;
});
console.log(pares);

console.log("Números em dobro são:")
let dobro = numeros.forEach((numero) =>{
    console.log(numero*2);
})