document.getElementById("cadastroForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita o envio do formulário para a página

    // pegar idade do campo
    let idade = parseInt(document.getElementById("idade").value);

    // Verifica se a idade atende ao requisito mínimo
    let idadeMinima = 18;
    if (idade <= idadeMinima) {
        alert("Idade mínima permitida é 18 anos");
    } else {
        alert("OK");
    }
});
