const professorModel = require('../models/professor');

//1. listar todos os professores
exports.obterTodos = async (req, res) => {
    try {
        const professores = await professorModel.find();
        res.status(200).json(professores);
    } catch (error) {
        res.status(400).json({ error: error });
    }
};

// 2. Buscar um professor por id
exports.buscarProfessorPorId = async (req, res) => {
    try {
        const professores = await professorModel.findOne({id : req.params.id});
        res.status(200).json(professores);
    } catch (error) {
        res.status(400).json({ error: error });
    }
};

// 3. Listar todas as turmas de um professor por ID
exports.buscarTurmasPorIdProfessor = async (req, res) => {
    try {
        const professores = await professorModel.findOne({ id: req.params.id });
        if (!professores) {
            return res.status(404).json({ error: "Professor não encontrado" });
        }
        res.status(200).json(professores.turmas);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
};

// 4. Atualizar os dados de um professor
exports.atualizarProfessorPorId = async (req, res) => {
    try {
        const professor = await professorModel.findOne({ id: req.params.id });
        if (professor) {
            const { nome, idade, departamento } = req.body;
            if (nome) professor.nome = nome;
            if (idade) professor.idade = idade;
            if (departamento) professor.departamento = departamento;
            
            await professor.save(); // Salva as alterações no banco de dados
            
            res.status(200).json({ message: "Dados do professor atualizados com sucesso", professor });
        } else {
            res.status(404).json({ error: "Id não existente" });
        }
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
};

// 5. Adicionar uma turma para um professor
exports.adicionarTurmaParaProfessorPorId = async (req, res) => {
    try {
        const professor = await professorModel.findOne({ id: req.params.id });
        if (!professor) {
            return res.status(404).json({ error: "Professor não encontrado" });
        }

        // itens dentro do array turmas
        const { codigo, disciplina, alunos } = req.body;
        professor.turmas.push({ codigo, disciplina, alunos });
       
        await professor.save();
        res.status(200).json({ message: "Turma adicionada com sucesso", professor });
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
};


// 6. Listar professores por departamento
exports.listarProfessoresPorDepartamento = async (req, res) => {
    try {
        const professores = await professorModel.find({ departamento: req.params.departamento });
        if (professores.length === 0) {
            return res.status(404).json({ error: "Nenhum professor encontrado nesse departamento" });
        }
        res.status(200).json(professores);
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
};

// 7. Remover um professor
exports.removerProfessor = async (req, res) => {
    try {
        const result = await professorModel.deleteOne({ id: req.params.id });
        if (result.deletedCount === 0) {
            return res.status(404).json({ error: "Id não existente" });
        }
        res.status(200).json({ message: 'Professor excluído com sucesso' });
    } catch (error) {
        res.status(400).json({ error: error.message });
    }
};
