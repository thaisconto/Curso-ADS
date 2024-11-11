const mongoose = require('mongoose');
const Professor = mongoose.model('Professor', {
    id: String,
    nome: String,
    idade: Number,
    departamento: String,
    turmas: [
        {
            codigo: String,
            disciplina: String,
            alunos: [String]
        }
    ]
});
module.exports = Professor;