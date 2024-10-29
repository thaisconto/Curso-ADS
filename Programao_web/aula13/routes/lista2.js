const express = require('express');
const router = express.Router();
const lista2Controller = require('../controllers/lista2Controller');

router.get('/alunos', lista2Controller.alunos);
router.get('/alunos/:ra', lista2Controller.buscarAlunoPorRa);
router.get('/alunos/:ra/disciplina', lista2Controller.buscarDisciplinaPorRa);
router.post('/alunos/:ra/disciplina', lista2Controller.adicionarDisciplinaPorRa);
router.put('/alunos/:ra', lista2Controller.atualizarAlunoPorRa);

module.exports = router;