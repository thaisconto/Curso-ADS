const mongoose = require('mongoose');
const Aluno = mongoose.model('Aluno', {
    ra: String,
    nome: String,
    disciplinas: [
        {
            codigo: String,
            nome: String,
            professor: String
        }
    ]
});
module.exports = Aluno;