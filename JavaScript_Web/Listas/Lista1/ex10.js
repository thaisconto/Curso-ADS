var palavra = "Thais"
reverseString(palavra);

function reverseString(str) {
    var newString = "";
    for (let i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    console.log(`Palavra normal: ${palavra}`);
    console.log(`Palavra invertida: ${newString}`);
    if(newString == palavra){
        console.log("É um palíndromo? Sim");
    }
    else {
        console.log("É um palíndromo? Não");
    }

}



