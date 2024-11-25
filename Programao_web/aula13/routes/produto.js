const express = require('express');
const router = express.Router();
const produtoController = require('../controllers/produtoController.js');

router.get('/', produtoController.obterTodos);
router.post('/', produtoController.inserir);

module.exports = router;