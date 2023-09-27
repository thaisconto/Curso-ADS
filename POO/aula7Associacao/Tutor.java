package POO.aula7Associacao;

import java.util.ArrayList;

/**
 *
 * @author tha_c
 */
public class Tutor {
    private String nome, cpf;
    private ArrayList<Pet> listPet;
     
    public Tutor() {
         listPet = new ArrayList<>();
     }
         
    public Tutor(String nome, String cpf){
        this(); //chama o construtor Tutor vazio
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
           return nome;
       }

    public void setNome(String value) {
        this.nome = value;
    }
        
    public String getCpf() {
           return cpf;
       }

    public void setCpf(String value) {
            this.cpf = value;
    }

    public String imprimir() {
            String msg = "\n===================" 
                    +"\nNome Tutor: "+getNome()
                    +"\nCPF: "+getCpf();
            for (Pet p : listPet){
                msg += p.imprimir();
            }

            return msg;
    }
    
    //criando métodos para adicionar e remover pet da lista
    
    public ArrayList<Pet> getListPet(){
        return listPet;
    }
    
    public void addPet(Pet pet){
        listPet.add(pet);
    }
    
    public void removePet(Pet pet){
        listPet.remove(pet);
    }
    
    public void removePet(int index){
        listPet.remove(index);
    }
    
    
    

}