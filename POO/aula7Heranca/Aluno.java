package POO.aula7Heranca;

public class Aluno extends Pessoa{
    private String ra;
    double nota1, nota2, media;

    public Aluno() {
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Aluno(String ra, double nota1, double nota2, String nome, String cpf) {
        super(nome, cpf);
        this.ra = ra;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

       
    public double media(){
        return ((nota1 + nota2)/2);
    }

    
    public String imprimir() {
        String msg = "\n-----------" 
                +"\nAluno: "+getNome()
                +"\nCPF: "+getCpf()
                +"\nRA: "+getRa()
                +"\nNota 1: "+getNota1()
                +"\nNota 2: "+getNota2()
                +"\nMédia: "+media();                        
        return msg;      
    }

}
