document.addEventListener("DOMContentLoaded", function() {
    var textoInput = document.getElementById("textoInput");
    var countarButton = document.getElementById("countarButton");
    var resultado = document.getElementById("resultado");

    countarButton.addEventListener("click", function() {
        var texto = textoInput.value.trim();
        var contarPalavra = countarPalavras(texto);
        resultado.textContent = "Número de palavras: " + contarPalavra;
    });

    function countarPalavras(texto) {
        var palavras = texto.split(/\s+/).filter(function(palavra) {
            return palavra.length > 0;
        });
        return palavras.length;
    }
});
