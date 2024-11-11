const express = require('express');
const mongoose = require('mongoose');

require('dotenv').config();
const DB_USER = process.env.DB_USER
const DB_PASSWORD = process.env.DB_PASSWORD

const usuarioRouter = require('./routes/usuario');
const lista1Router = require('./routes/lista1');
const lista2Router = require('./routes/lista2');
const alunoRouter = require('./routes/aluno');
const professorRouter = require('./routes/professor');

const app = express();
app.use(express.json());

app.use('/usuario', usuarioRouter);
app.use('/lista1', lista1Router);
app.use('/lista2', lista2Router);
app.use('/aluno', alunoRouter);
app.use('/professores', professorRouter);

mongoose.connect(`mongodb+srv://${DB_USER}:${DB_PASSWORD}@cluster0.kcwyx.mongodb.net/`)
    .then(() => {
        app.listen(3000, () => {
            console.log('Conectado ao mongoDB');
            console.log('Servidor iniciado na porta 3000');
        })
    })
    .catch((err) => {
        console.log(err);
});