const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

require('dotenv').config();
const DB_USER = process.env.DB_USER;
const DB_PASSWORD = process.env.DB_PASSWORD;

// Importação das rotas
const usuarioRouter = require('./routes/usuario');
const lista1Router = require('./routes/lista1');
const lista2Router = require('./routes/lista2');
const alunoRouter = require('./routes/aluno');
const professorRouter = require('./routes/professor');
const produtoRouter = require('./routes/produto');

const app = express();
app.use(express.json());

// Configuração do CORS
app.use(cors({
    origin: 'http://localhost:4200', // URL do seu front-end
    methods: ['GET', 'POST', 'PUT', 'DELETE'], // Métodos permitidos
    allowedHeaders: ['Content-Type', 'Authorization'], // Cabeçalhos permitidos
}));

// Registro das rotas
app.use('/usuario', usuarioRouter);
app.use('/lista1', lista1Router);
app.use('/lista2', lista2Router);
app.use('/aluno', alunoRouter);
app.use('/professores', professorRouter);
app.use('/produto', produtoRouter);

// Conexão com o banco de dados
mongoose.connect(`mongodb+srv://${DB_USER}:${DB_PASSWORD}@cluster0.kcwyx.mongodb.net/`)
    .then(() => {
        app.listen(3000, () => {
            console.log('Conectado ao MongoDB');
            console.log('Servidor iniciado na porta 3000');
        });
    })
    .catch((err) => {
        console.log(err);
    });
