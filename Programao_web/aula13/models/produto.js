const mongoose = require('mongoose');
const Produto = mongoose.model('Produto', {
    produto: String,
    quantidade: Number,
    unidade: String,
});
module.exports = Produto;