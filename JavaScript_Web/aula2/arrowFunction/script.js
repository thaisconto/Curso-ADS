/*
Transforme dois exercícios da aula passada em forma de arrow
functions
/*
• Faça um programa que mostre os números impares em um intervalo de 0 a
100.

for (let i = 0; i<=100; i++){
    let n = i;
    if (n % 2 != 0) {console.log(n)}
}
*/

let impares = () => {
    for (let i = 1; i <= 100; i += 2){
        console.log(i);
    }
}

impares();

/*
• Faça uma função que mostre o dobro do número passado. Caso o número
seja menor ou igual a zero deve mostrar a mensagem “Só é aceito números
positivos maiores que zero”.
*/
/*
let numero = 2;
if(numero <= 0){console.log("Só é aceito números positivos maiores que zero")}
else {
    console.log(`O dobro é ${numero*2}`)
}
*/
let dobro = (numero) => {
    if(numero <= 0){console.log("Só é aceito números positivos maiores que zero")}
    else {
    console.log(`O dobro é ${numero*2}`)
    }
}

dobro(1)