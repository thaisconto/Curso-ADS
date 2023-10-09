package POO.aula9;

public class Gato extends  Animal{

    public Gato(String nome, int idade) {
        super(nome, idade);
    }
    
    @Override
    public void falar() {
        System.out.println("Miauauauauauauau");
    }
}

