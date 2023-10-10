package POO.listasExercicios.listaaula7Heranca.exercicio1;

public class Aluno {
    private String nome, ra;

    public Aluno() {
    }

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }
    
    //imprimir aluno
    public String imprimir() {
        String msg = "\n-----------" 
                +"\nNome: "+getNome()
                +"\nRA: "+getRa();
                      
        return msg;        
    }
    
    //getters and setters

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
    
    
    
}


