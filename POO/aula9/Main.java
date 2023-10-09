package POO.aula9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro("Stefani", 17);
        Gato cat = new Gato("Mel", 4);
        Capivara cap = new Capivara("Voto", 121);
        
        ArrayList<Animal> lstAnimais = new ArrayList<>();
        lstAnimais.add(dog);
        lstAnimais.add(cat);
        lstAnimais.add(cap);
        
        for (Animal ani : lstAnimais) {
            ani.falar();
        } 
    }
}
