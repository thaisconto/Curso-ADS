/*
Escreva uma função que recebe um endereço de e-mail como argumento 
e retorna true se o e-mail for válido ou false caso contrário. 
Um e-mail válido deve conter um único símbolo '@' e pelo menos 
um ponto '.' após o '@'. 
*/

function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

const email1 = validarEmail("exemplo@email.com");
console.log(email1); 

const email2 = validarEmail("exemploemail.com");
console.log(email2); 
