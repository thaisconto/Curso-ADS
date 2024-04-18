document.addEventListener("DOMContentLoaded", function() { 
    var adicionarButton = document.getElementById("adicionarButton");
    var tarefaInput = document.getElementById("tarefaInput");
    var listaTarefa = document.getElementById("listaTarefa");

    adicionarButton.addEventListener("click", function() {
        // elimina os espaços antes e depois da palavra
        var tarefaText = tarefaInput.value.trim();

        if (tarefaText !== "") {
            var novaTarefa = document.createElement("li");
            novaTarefa.textContent = tarefaText;
            listaTarefa.appendChild(novaTarefa);
            tarefaInput.value = "";
        } else {
            alert("Por favor, digite uma tarefa.");
        }
    });
});
