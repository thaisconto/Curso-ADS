package POO.listasExercicios.ExercicioAvaliativo;

public class Pet {
    
    private String nome, raca;
    private int idade;
    private char sexo;

   
   public String imprimir() {
        String mensagem =  
                "\nNome: "+getNome()
                +"\nRaça: "+getRaca()
                +"\nIdade: "+getIdade()
                +"\nSexo: " +getSexo();
                
        
        return mensagem;
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
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char value) {
        this.sexo = value;
    }
    
       
}
