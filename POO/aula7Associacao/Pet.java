package POO.aula7Associacao;

public class Pet {
    private String nome, raca;
    private int idade;
    
    public Pet(){
    
    }
    
    public Pet(String nome, String raca, int idade){
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }
    
    public String getRaca() {
        return raca;
    }

    public void setRaca(String value) {
        this.raca = value;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int value) {
        this.idade = value;
    }
            
    public String imprimir() {
        String msg = "\n-----------" 
                +"\nPet: "+getNome()
                +"\nRaca: "+getRaca()
                +"\nIdade: "+getIdade();
        
        return msg;        
    }
}
