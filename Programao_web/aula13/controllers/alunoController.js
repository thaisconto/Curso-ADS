const alunoModel = require('../models/aluno');

//1. obter todos os alunos
exports.obterTodos = async (req, res) => {
    try {
        const alunos = await alunoModel.find();
        res.status(200).json(alunos);
    } catch (error) {
        res.status(400).json({ error: error });
    }
};

// 2. Buscar um aluno pelo RA
exports.buscarAlunoPorRa = async (req, res) => {
    try {
        const alunos = await alunoModel.findOne({ra : req.params.ra});
        res.status(200).json(alunos);
    } catch (error) {
        res.status(400).json({ error: error });
    }
};

// 3. Listar todas as disciplinas de um aluno
exports.buscarDisciplinaPorRa = async (req, res) => {
    try {
        const aluno = await alunoModel.findOne({ ra: req.params.ra });
        if (!aluno) {
            return res.status(404).json({ error: "Aluno não encontrado" });
        }
        res.status(200).json(aluno.disciplinas);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
};

// 4. Atualizar os dados de um aluno
exports.atualizarAlunoPorRa = async (req, res) => {
    try {
        const aluno = await alunoModel.findOne({ ra: req.params.ra });
        if (aluno) {
            const { nome, disciplinas } = req.body;
            if (nome) aluno.nome = nome;
            if (disciplinas) aluno.disciplinas = disciplinas;
            
            await aluno.save(); // Salva as alterações no banco de dados
            
            res.status(200).json({ message: "Dados do aluno atualizados com sucesso", aluno });
        } else {
            res.status(404).json({ error: "Aluno não encontrado" });
        }
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
};
/*
forma mais simples de fazer o PUT
exports.editarAluno = async (req, res) => {
    try {
        const aluno = await alunoModel.findOne({ ra: req.params.ra });
        aluno.nome = req.body.nome;
        aluno.disciplinas = req.body.disciplinas;
        await aluno.save();
        res.status(200).json(aluno);
    } catch (error) {
        res.status(400).json({ error: error });
    }
};
*/