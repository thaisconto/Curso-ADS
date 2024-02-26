class Animal {
    correr() {
      console.log("Correndo...");
    }
    
    emitirSom() {
      console.log();
    }
  }
  
  class Cachorro extends Animal {
    emitirSom() {
      console.log("Au au!");
    }
  }
  
  class Gato extends Animal {
    emitirSom() {
      console.log("Miau!");
    }
  }
  
  let cachorro = new Cachorro();
  let gato = new Gato();
  
  console.log("Cachorro: ");
  cachorro.emitirSom();
  cachorro.correr();
  
  console.log("Gato: ");
  gato.emitirSom();
  gato.correr();
  