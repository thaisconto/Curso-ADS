package POO.aulaConstrutor;

public class Aluno {
    private String nome, RA, curso;

    //criar construtor, dentro do construtor já posso colocar os parâmetros
    //nesse caso só vou conseguir instaciar o objeto aluno se tiver colocado os parÂmetro obrigatórios
    public Aluno(String nome, String RA, String curso){        
        this.nome = nome;
        this.RA = RA;
        this.curso = curso;
    }
   
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRA() {
        return RA;
    }
    public void setRA(String rA) {
        RA = rA;
    }
    
}
