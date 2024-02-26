class Carro {
    constructor(marca, ano){
    this.marca = marca;
    this.ano = ano;
}}

let carros = [
    new Carro("Marca 1", 1994),
    new Carro("Marca 2", 2010),
    new Carro("Toyota", 2022)  
];

console.log("Carros: ")
console.log(carros);

let primeiroToyota = carros.find(carro => carro.marca == "Toyota");
console.log("Primeiro carro da marca Toyota: ");
console.log(primeiroToyota);

let maiores2010 = carros.filter(carro => carro.ano > 2010);
console.log("Carros fabricados após 2010: ")
console.log(maiores2010);