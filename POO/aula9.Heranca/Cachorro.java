package POO.aula9;

public class Cachorro extends Animal{

    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void falar() {
        System.out.println("Auauauauauau");
    }
    
    
}

