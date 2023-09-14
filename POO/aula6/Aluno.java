package POO.aula6;

public class Aluno {
    // atributos
    private String nome;
    private String ra;
    private String curso;

    // Modificadores e Acessores
    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    // ===============================
    public String imprimir() {
        String msg = "\n===================" 
                +"\nNome: "+getNome()
                +"\nCurso: "+getCurso()
                +"\nRA: "+getRa();
        
        return msg;
    }
}
