document.addEventListener("DOMContentLoaded", function() {
    var num1Input = document.getElementById("num1");
    var num2Input = document.getElementById("num2");
    var somarButton = document.getElementById("somarButton");
    var subtrairButton = document.getElementById("subtrairButton");
    var multiplicarButton = document.getElementById("multiplicarButton");
    var dividirButton = document.getElementById("dividirButton");
    var resultado = document.getElementById("resultado");

    function calcular(operation) {
        var num1 = parseFloat(num1Input.value);
        var num2 = parseFloat(num2Input.value);

        //verificar se é um número
        if (isNaN(num1) || isNaN(num2)) {
            alert("Por favor, digite números válidos.");
            return;
        }

        // verificar se está dividindo por zero
        if (operation === "dividir" && num2 === 0) {
            alert("Impossível dividir por zero.");
            return;
        }

        var resultadoCalculado;

        switch (operation) {
            case "somar":
                resultadoCalculado = num1 + num2;
                break;
            case "subtrair":
                resultadoCalculado = num1 - num2;
                break;
            case "multiplicar":
                resultadoCalculado = num1 * num2;
                break;
            case "dividir":
                resultadoCalculado = num1 / num2;
                break;
        }

        resultado.textContent = "Resultado: " + resultadoCalculado;
    }

    somarButton.addEventListener("click", function() {
        calcular("somar");
    });

    subtrairButton.addEventListener("click", function() {
        calcular("subtrair");
    });

    multiplicarButton.addEventListener("click", function() {
        calcular("multiplicar");
    });

    dividirButton.addEventListener("click", function() {
        calcular("dividir");
    });
});
