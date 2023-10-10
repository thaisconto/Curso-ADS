package POO.listasExercicios.listaaula7Heranca.exercicio2;

import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int codigo;
    private ArrayList<Automovel> listAutomovel;

    public Pessoa() {
        listAutomovel = new ArrayList<>();
    }

    public Pessoa(String nome, int codigo) {
        this(); //chama o construtor Pessoa vazio
        this.nome = nome;
        this.codigo = codigo;
    }
    
    //imprimir pessoa
    public String imprimir() {
            String msg = "\n===================" 
                    +"\nNome: "+getNome()
                    +"\nCódigo: "+getCodigo();
                    
            return msg;
    }
     
    //imprimir pessoa e automovel
    public String imprimirCompleto() {
            String msg = "\n===================" 
                    +"\nNome: "+getNome()
                    +"\nCódigo: "+getCodigo();
                    
            for (Automovel a : listAutomovel){
                msg += a.imprimir();
            }
            return msg;
    }
    

    //adicionar e remover aluno
    public ArrayList<Automovel> getListAutomovel(){
        return listAutomovel;
    }
    
    public void addAutomovel(Automovel automovel){
        listAutomovel.add(automovel);
    }
    
    public void removeAutomovel(Automovel automovel){
        listAutomovel.remove(automovel);
    }
    
    public void removeAutomovel(int index){
        listAutomovel.remove(index);
    }
    
    
    //getters and setters

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
