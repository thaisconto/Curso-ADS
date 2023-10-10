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

    //para fazer sobrecarga de construtores, cada um precisa ter parametros diferentes,
    //mesmo que o construtor tenha o mesmo nome
    public Aluno(String RA){
        this.RA = RA;
   }
   

   public String imprimir(){
    return "Nome: " + getNome()
            +"RA: " + getRA()
            +"Curso: " + getCurso();

    }
   //também pode fazer sobrecarga de métodos
   public double caluclaMedia(double n1, double n2){
    return (n1+n2)/2;
   }

   //vamos supor que algumas materias tenham quatro notas
   public double caluclaMedia(double n1, double n2, double n3, double n4){
    return (n1+n2+n3+n4)/4;
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
