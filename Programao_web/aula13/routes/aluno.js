const express = require('express');
const router = express.Router();
const alunoController = require('../controllers/alunoController.js');

router.get('/', alunoController.obterTodos);
router.get('/:ra', alunoController.buscarAlunoPorRa);
router.get('/:ra/disciplina',alunoController.buscarDisciplinaPorRa);
router.put('/:ra', alunoController.atualizarAlunoPorRa);

module.exports = router;