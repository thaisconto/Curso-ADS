// Aguarda o carregamento completo do DOM antes de executar o código
document.addEventListener("DOMContentLoaded", function() {
    // Obtém o elemento com id "output"
    const output = document.getElementById("output");
    // Obtém o elemento com id "jsonInput"
    const jsonInput = document.getElementById("jsonInput");
    // Define a URL base para as chamadas à API mockada
    const mockapiBaseUrl = "https://662abf39d3f63c12f458970b.mockapi.io/example";

    // Função para atualizar o conteúdo exibido na página
    function updateOutput(content) {
        output.innerHTML += "<pre>" + JSON.stringify(content, null, 2) + "</pre>";
    }

    // Função para enviar dados para a API usando o método POST
    async function postData() {
        const json = jsonInput.value;
        const response = await fetch(`${mockapiBaseUrl}/usuario`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: json
        });
        const data = await response.json();
        updateOutput(data);
    }

    // Função para atualizar dados na API usando o método PUT
    // precisa mudar o id
    async function putData() {
        const json = jsonInput.value;
        const response = await fetch(`${mockapiBaseUrl}/usuario/66`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: json
        });
        const data = await response.json();
        updateOutput(data);
    }

    // Função para excluir dados na API usando o método DELETE
    // precisa mudar o id
    async function deleteData() {
        const response = await fetch(`${mockapiBaseUrl}/usuario/66`, {
            method: "DELETE"
        });
        if (response.ok) {
            updateOutput("DELETE successful");
        } else {
            updateOutput("DELETE failed");
        }
    }

    // Função para obter todos os dados da API
    async function getAllData() {
        // Faz múltiplas requisições em paralelo
        // Para trazer todos os rgistros é só retirar o id
        const promise1 = fetch(`${mockapiBaseUrl}/usuario/1`);
        const promise2 = fetch(`${mockapiBaseUrl}/usuario/2`);

        // Aguarda todas as requisições serem concluídas
        const responses = await Promise.all([promise1, promise2]);
        // Converte os resultados para JSON
        const data = await Promise.all(responses.map(response => response.json()));
        // Atualiza o conteúdo exibido na página
        updateOutput(data);
    }

    // Torna as funções disponíveis globalmente
    /*
    Essa linha de código está atribuindo a função postData ao objeto window, tornando-a acessível globalmente em todo o contexto do navegador. 
    Isso significa que você pode chamar a função postData em qualquer lugar do seu código JavaScript, mesmo fora do escopo onde ela foi definida.
    Essa técnica é comumente usada para tornar funções ou variáveis importantes disponíveis globalmente, especialmente quando se trabalha com bibliotecas 
    ou frameworks que esperam que certas funções estejam no escopo global. No seu caso, você está tornando as funções postData, putData, deleteData e 
    getAllData disponíveis globalmente para poder chamá-las a partir de outros scripts ou elementos HTML, se necessário.
    */
    window.postData = postData;
    window.putData = putData;
    window.deleteData = deleteData;
    window.getAllData = getAllData;
});