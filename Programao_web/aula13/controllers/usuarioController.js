const usuarioModel = require('../models/usuario');

// Lógica para obter todos os usuários
exports.obterTodos = async (req, res) => {
    try {
        const usuarios = await usuarioModel.find();
        res.status(200).json(usuarios);
    } catch (error) {
        res.status(500).json({ error: error });
    }
};

// Lógica para criar um novo usuário
exports.inserir = async (req, res) => {
    try {
        await usuarioModel.create(req.body);
        res.status(201).json(req.body);
    } catch (error) {
        res.status(400).json({ error: error });
    }
};
    