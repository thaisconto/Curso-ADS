let escola = [
    {
        ra: '1',
        nome: "João",
        disciplinas: [
            { codigo: "MAT101", nome: "Matemática", professor: "Prof. Carlos" },
            { codigo: "HIS101", nome: "História", professor: "Prof. Ana" },
            { codigo: "POR101", nome: "Português", professor: "Prof. João" },
            { codigo: "GEO101", nome: "Geografia", professor: "Prof. Ana" }
        ]
    },
    {
        ra: '2',
        nome: "Maria",
        disciplinas: [
            { codigo: "MAT101", nome: "Matemática", professor: "Prof. Carlos" },
            { codigo: "HIS101", nome: "História", professor: "Prof. Ana" },
            { codigo: "GEO101", nome: "Geografia", professor: "Prof. Ana" }
        ]
    },
    {
        ra: '3',
        nome: "Pedro",
        disciplinas: [
            { codigo: "CIE101", nome: "Ciências", professor: "Prof. João" },
            { codigo: "HIS101", nome: "História", professor: "Prof. Ana" },
            { codigo: "POR101", nome: "Português", professor: "Prof. João" },
            { codigo: "GEO101", nome: "Geografia", professor: "Prof. Ana" },
            { codigo: "EDF101", nome: "Educação Física", professor: "Prof. Carlos" }
        ]
    }
];

// 1. Exibir todos os alunos
exports.alunos = (req, res) => {
    res.json({escola});
};

// 2. Buscar um aluno pelo RA
exports.buscarAlunoPorRa = (req, res) => {
    const ra = req.params.ra;
    const aluno = escola.find(aluno => aluno.ra === ra);
    if (aluno) {
        res.json(aluno);
    } else {
        res.status(404).json({ error: "Aluno não encontrado" });
    }
};


// 3. Listar todas as disciplinas de um aluno
exports.buscarDisciplinaPorRa = (req, res) => {
    const ra = req.params.ra;
    const aluno = escola.find(aluno => aluno.ra === ra);
    if (aluno) {
        res.json(aluno.disciplinas);
    } else {
        res.status(404).json({ error: "Aluno não encontrado" });
    }
};


// 4. Adicionar uma disciplina para um aluno
exports.adicionarDisciplinaPorRa = (req, res) => {
    const ra = req.params.ra;
    const aluno = escola.find(aluno => aluno.ra === ra);
    if (aluno) {
        const novaDisciplina = req.body;
        aluno.disciplinas.push(novaDisciplina);
        res.json({ message: "Disciplina adicionada com sucesso", aluno });
    } else {
        res.status(404).json({ error: "Aluno não encontrado" });
    }
};


// 5. Atualizar os dados de um aluno
exports.atualizarAlunoPorRa = (req, res) => {
    const ra = req.params.ra;
    const aluno = escola.find(aluno => aluno.ra === ra);
    if (aluno) {
        const { nome, disciplinas } = req.body;
        if (nome) aluno.nome = nome;
        if (disciplinas) aluno.disciplinas = disciplinas;
        res.json({ message: "Dados do aluno atualizados com sucesso", aluno });
    } else {
        res.status(404).json({ error: "Aluno não encontrado" });
    }
};

