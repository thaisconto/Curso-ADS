package POO.listasExercicios.LISTA3.pessoa;

public class Pessoa {
     private String txtCpf, txtNome;
    private char txtSexo;
    private int txtIdade;

    public String imprimir(){
    return "\nNome: " + gettxtNome()
            +"\nCPF: " + gettxtCpf()
            +"\nSexo: " + gettxtSexo()
            +"\nIdade: " + gettxtIdade();
    }
    
    public String gettxtNome(){
       return txtNome;
   }
   
    public void settxtNome (String txtNome){
        this.txtNome = txtNome;
    }
    
    public String gettxtCpf(){
       return txtCpf;
   }
   
    public void settxtCpf (String txtCpf){
        this.txtCpf = txtCpf;
    }
    
    public char gettxtSexo(){
       return txtSexo;
   }
   
    public void settxtSexo (char txtSexo){
        this.txtSexo = txtSexo;
    }
    
    public int gettxtIdade(){
       return txtIdade;
   }
   
    public void settxtIdade (int txtIdade){
        this.txtIdade = txtIdade;
    }
    
}

