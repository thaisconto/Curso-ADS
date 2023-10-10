package POO.listasExercicios.listaaula7Heranca.exercicio1;

import java.util.ArrayList;

public class Curso {
     private String nome;
    private int codigo, cargaHoraria;
    private ArrayList<Aluno> listAluno;
    
    public Curso(){
        listAluno = new ArrayList<>();
    }

    public Curso(String nome, int codigo, int cargaHoraria) {
        this(); //chama o construtor Curso vazio
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }
    
    //imprimir curso
    public String imprimir() {
            String msg = "\n===================" 
                    +"\nNome curso: "+getNome()
                    +"\nCódigo: "+getCodigo()
                    +"\nCarga horária: "+getCargaHoraria();
            return msg;
    }
     
    //imprimir curso e aluno
    public String imprimirCompleto() {
            String msg = "\n===================" 
                    +"\nNome curso: "+getNome()
                    +"\nCódigo: "+getCodigo()
                    +"\nCarga horária: "+getCargaHoraria();
            for (Aluno a : listAluno){
                msg += a.imprimir();
            }
            return msg;
    }
    

    //adicionar e remover aluno
    public ArrayList<Aluno> getListAluno(){
        return listAluno;
    }
    
    public void addAluno(Aluno aluno){
        listAluno.add(aluno);
    }
    
    public void removeAluno(Aluno aluno){
        listAluno.remove(aluno);
    }
    
    public void removeAluno(int index){
        listAluno.remove(index);
    }
    
    
    //getters and setters

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setListAluno(ArrayList<Aluno> listAluno) {
        this.listAluno = listAluno;
    } 
    
    
}
    

