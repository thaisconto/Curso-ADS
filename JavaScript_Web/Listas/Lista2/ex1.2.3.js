class Usuario {
    constructor(nome, idade){
    this.nome = nome;
    this.idade = idade;
}}

let usuarios = [
    new Usuario("Thais", 29),
    new Usuario("Marcos", 34),
    new Usuario("Gustavo", 6)  
];

console.log("Usuários: ")
console.log(usuarios);

let nomesMaisculos = usuarios.map(usuario => usuario.nome.toUpperCase());
console.log("Usuários com letra maiúscula: ")
console.log(nomesMaisculos);

let maioresDeDezoito = usuarios.filter(usuario => usuario.idade > 18);
console.log("Usuários com idade maior que 18: ")
console.log(maioresDeDezoito);

let usuarioEntre25e30 = usuarios.find(usuario => usuario.idade >= 25 && usuario.idade <=30);
console.log("Primeiro usuário com idade de 25 a 30: ");
console.log(usuarioEntre25e30);