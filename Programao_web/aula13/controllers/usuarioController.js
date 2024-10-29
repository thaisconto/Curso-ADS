// Lógica para obter todos os usuários
exports.obterTodos = (req, res) => {
    res.json({"mensagem" : "Obter todos os usuários"});
    };

// Lógica para criar um novo usuário
exports.inserir = (req, res) => { 
    res.status(201).json({"mensagem" : "Inserir um novo usuário"});
    };
    