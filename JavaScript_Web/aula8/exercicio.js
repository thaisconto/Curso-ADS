//Pegando quantidade de elementos por TagName
let h = document.getElementsByTagName('h1');
let p = document.getElementsByTagName('p');

console.log('Quantidade h: ' + h.length);
console.log('Quantidade p: ' + p.length);

// Pegando as informações
console.log('Informações sobre h: ');
console.log(h);

// Pegando elemento por ID
let header = document.getElementById('header');
console.log(header);

// Pegando elementos pelo classe do CSS
let marca = document.getElementsByClassName('marca');
console.log('Elementos que tem a classe marca são: ');
console.log(marca);

// exibindo o primeiro elemento da lista
console.log('Primeiro p é: ');
console.log(p[0]);

console.log('Primeiro h é: ');
console.log(h[0]);

// Adicionando um novo paragráfo
let novoParagrafo = document.createElement('p');
novoParagrafo.innerText = 'Isso é novo!';
novoParagrafo.style.fontSize = '50px';
novoParagrafo.style.color = 'purple';
document.body.appendChild(novoParagrafo); // adicionando ao local que quero

// Alterando o Titulo
document.getElementsByTagName('p')[0].style.color = 'red';

//Removendo elemento
document.getElementsByClassName('marca')[1].remove();

