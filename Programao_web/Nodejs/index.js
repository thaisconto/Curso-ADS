const express = require('express');
const app = express();
app.use(express.json());

const produtos = [];

app.get("/produto", (request, response) => {
    return response.json(produtos);
})

app.post("/produto", (request, response) => {
    const produto = request.body;
    produtos.push(produto);
    return response.json(produto);
});

app.get("/somar/:numero1/:numero2", (request, response) => {
    const numero1 = request.params.numero1;
    const numero2 = request.params.numero2;
    const soma = parseFloat(numero1) + parseFloat(numero2);
    return response.json({ "soma": soma });
});

app.listen(3001, () => console.log('server running on port 3001')); 
