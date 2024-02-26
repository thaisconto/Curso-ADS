let numeros = [1,2,3,4,5,6,7,8,9,10];

let pares = numeros.filter(numero => numero % 2 == 0);

let dobro = pares.map(numero => numero * 2);

console.log(`Números: ${numeros}`);
console.log(`Números pares: ${pares}`);
console.log(`Números pares em dobro: ${dobro}`);