function showActivity(activity) {
    var content = document.getElementById("content");

    switch(activity) {
        case 'html':
            fetch('../Lista3/ex1.html')
                .then(response => response.text())
                .then(data => {
                    content.innerHTML = data;
                });
            break;
        case 'css':
            Promise.all([
                fetch('../Lista5/exercicio.html').then(response => response.text()),
                fetch('../Lista5/exercicio.css').then(response => response.text())
            ]).then(data => {
                content.innerHTML = "<style>" + data[1] + "</style>" + data[0];
            });
            break;
        case 'flexbox':
            Promise.all([
                fetch('../Lista7/exercicio.html').then(response => response.text()),
                fetch('../Lista7/exercicio.css').then(response => response.text())
            ]).then(data => {
                content.innerHTML = "<style>" + data[1] + "</style>" + data[0];
            });
            break;
        case 'dom':
            Promise.all([
                fetch('../Lista8/exercicio1.html').then(response => response.text()),
                fetch('../Lista8/exercicio1.css').then(response => response.text()),
                fetch('../Lista8/exercicio1.js').then(response => response.text())
            ]).then(data => {
                content.innerHTML = "<style>" + data[1] + "</style>" + data[0] + "<script>" + data[2] + "</script>";
            });
            break;
        default:
            content.innerHTML = "Selecione uma atividade para começar.";
    }
}

