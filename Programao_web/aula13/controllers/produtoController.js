const produtoModel = require('../models/produto');


//1. listar todos os produtos
exports.obterTodos = async (req, res) => {
    try {
        const produtos = await produtoModel.find();
        res.status(200).json(produtos);
    } catch (error) {
        res.status(400).json({ error: error });
    }
};
