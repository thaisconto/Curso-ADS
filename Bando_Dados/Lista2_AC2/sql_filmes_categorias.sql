-- criar tabela filmes

CREATE TABLE Filmes(
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
titulo varchar(30) NOT NULL,
sinopse varchar(300) NOT NULL,
estudio varchar(30) NOT NULL,
categoria_id int NOT NULL,
FOREIGN KEY (categoria_id) references Categorias (ID)
);

-- criar tabela categorias

CREATE TABLE Categorias (
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nome_categoria varchar(30) NOT NULL,
publico_alvo varchar(30) NOT NULL
);

-- inserir dados produtos: id, titulo, sinopse, estudio, categoria_id
INSERT INTO Filmes VALUES (null, "Sonic", 
"O porco-espinho Sonic é teletransportado para a Terra. Após causar uma pane elétrica em parte dos Estados Unidos, ele precisa escapar do maligno cientista Dr. Robotnik.",
 "esudio 1", 1);
INSERT INTO Filmes VALUES (null, "Kung Fu Panda", 
"Po é um panda que trabalha na loja de macarrão da sua família e sonha em transformar-se em um mestre de kung fu. Seu sonho se torna realidade quando, inesperadamente, ele deve cumprir uma profecia antiga e estudar a arte marcial com seus ídolos, os Cinco Furiosos. Po precisa de toda a sabedoria, força e habilidade que conseguir reunir para proteger seu povo de um leopardo da neve malvado.", 
"estudio 2", 2);
INSERT INTO Filmes VALUES (null, "Toy story", 
"O aniversário do garoto Andy está chegando e seus brinquedos ficam nervosos, temendo que ele ganhe novos brinquedos que possam substituí-los. Liderados pelo caubói Woody, o brinquedo predileto de Andy, eles recebem Buzz Lightyear, o boneco de um patrulheiro espacial, que logo passa a receber mais atenção do garoto. Com ciúmes, Woody tenta ensiná-lo uma lição, mas Buzz cai pela janela. É o início da aventura do caubói, que precisa resgatar Buzz para limpar sua barra com os outros brinquedos", 
"estudio 3", 3);
INSERT INTO Filmes VALUES (null, "Mosntro S.A.", 
"A maior fábrica de monstros do mundo conta com James Sullivan, um dos monstros mais assustadores, que tem o pelo azul e chifres, além de seu assistente e melhor amigo Mike, um monstro verde de um olho só. Eles têm por missão assustar as crianças, que são consideradas tóxicas pelos monstros e cujo contato com eles seria catastrófico para seu mundo. Porém, ao visitar o mundo dos humanos a trabalho, Mike e Sully conhecem a garota Boo, que acaba sem querer indo parar no mundo dos monstros.",
"estudio 3", 1);
INSERT INTO Filmes VALUES (null, "Elementos", 
"Em uma cidade onde os habitantes de fogo, água, terra e ar convivem, uma jovem mulher flamejante e um rapaz que vive seguindo o fluxo descobrem algo surpreendente, porém elementar: o quanto eles têm em comum.", 
"estudio", 2);
INSERT INTO Filmes VALUES (null, "VIVA",
 "Apesar da proibição da música por gerações de sua família, o jovem Miguel sonha em se tornar um músico talentoso como seu ídolo Ernesto de la Cruz. Desesperado para provar seu talento, Miguel se encontra na deslumbrante e colorida Terra dos Mortos. Depois de conhecer um charmoso malandro chamado Héctor, os dois novos amigos embarcam em uma jornada extraordinária para desvendar a verdadeira história por trás da história da família de Miguel.",
 "estudio x", 3);
INSERT INTO Filmes VALUES (null, "De volta para o futuro", 
"O adolescente Marty McFly é transportado para 1955 quando uma experiência do excêntrico cientista Doc Brown dá errado. Ele viaja pelo tempo em um carro modificado e acaba conhecendo seus pais ainda jovens. O problema é que Marty pode deixar de existir porque ele interferiu na rotina dos pais, que correm o risco de não se apaixonar mais. Para complicar ainda mais a situação, Marty precisa voltar para casa a tempo de salvar o cientista.",
 "estudio y", 3);
INSERT INTO Filmes VALUES (null, "Como treinar o seu dragão", 
"Soluço é um jovem viking que não tem capacidade para lutar contra os dragões, como é a tradição local. Sua vida muda quando ele ajuda um dragão que lhe mostra toda a verdade. Juntos, eles tentam provar que dragões e humanos podem ser amigos.", 
"estuios aaa", 1);

-- inserir dados categorias: id, nome,publico
INSERT INTO Categorias VALUES (null, "ação", "todos");
INSERT INTO Categorias VALUES (null, "aventura", "criancas");
INSERT INTO Categorias VALUES (null, "animação", "família");

-- consultar dados

SELECT * 
FROM Filmes left
join Categorias
on Categorias.id = Filmes.categoria_id;