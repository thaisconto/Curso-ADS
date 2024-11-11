const express = require('express');
const router = express.Router();
const professorController = require('../controllers/professorController.js');

router.get('/', professorController.obterTodos);
router.get('/:id', professorController.buscarProfessorPorId);
router.get('/:id/turmas', professorController.buscarTurmasPorIdProfessor);
router.put('/:id', professorController.atualizarProfessorPorId);
router.post('/:id/turmas', professorController.adicionarTurmaParaProfessorPorId);
router.get('/departamento/:departamento', professorController.listarProfessoresPorDepartamento);
router.delete('/:id', professorController.removerProfessor);

module.exports = router;