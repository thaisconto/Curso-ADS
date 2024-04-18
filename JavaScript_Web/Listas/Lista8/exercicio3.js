document.addEventListener("DOMContentLoaded", function() {
    var countador = document.getElementById("countador");
    var incrementarButton = document.getElementById("incrementarButton");
    var count = 0;

    incrementarButton.addEventListener("click", function() {
        count++;
        countador.textContent = count;
    });
});
