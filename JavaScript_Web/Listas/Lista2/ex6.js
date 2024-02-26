class Livro {
    constructor(titulo, paginas){
    this.titulo = titulo;
    this.paginas = paginas;
}}

let livros = [
    new Livro("Livro 1", 290),
    new Livro("Livro 2", 340),
    new Livro("Livro 3", 120)  
];

console.log("Livros: ")
console.log(livros);

let maioresDe300Paginas = livros.filter(livro => livro.paginas > 300);
console.log("Livros com mais de 300 páginas: ")
console.log(maioresDe300Paginas);