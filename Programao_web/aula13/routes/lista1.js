const express = require('express');
const router = express.Router();
const lista1Controller = require('../controllers/lista1Controller');

// Rota para obter todos os usuários
router.get('/ex1', lista1Controller.ex1);
router.get('/ex2', lista1Controller.ex2);
router.get('/ex3', lista1Controller.ex3);
router.get('/ex4', lista1Controller.ex4);
router.get('/ex5', lista1Controller.ex5);
router.get('/ex6', lista1Controller.ex6);

module.exports = router;