class Produto {
    constructor(nome, preco){
    this.nome = nome;
    this.preco = preco;
}}

let produtos = [
    new Produto("Produto 1", 29.9),
    new Produto("Produto 2", 3.55),
    new Produto("Produto 3", 167.99)  
];

console.log("Produtos: ")
console.log(produtos);

let aumento = produtos.map(produto => produto.preco * 1.1);

console.log("Produtos com aumento de 10%: ")
console.log(aumento);

let produtoMaior100 = produtos.find(produto => produto.preco > 100);
console.log("Produto caro: ");
console.log(produtoMaior100);