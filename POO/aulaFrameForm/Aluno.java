package POO.aulaFrameForm;

public class Aluno {
    private String txtNome, txtRA, txtCurso;


   public String imprimir(){
    return "\nNome: " + gettxtNome()
            +"\nRA: " + gettxtRA()
            +"\nCurso: " + gettxtCurso();
    }
   
   public String gettxtNome(){
       return txtNome;
   }
   
    public void settxtNome (String txtNome){
        this.txtNome = txtNome;
    }

    public String gettxtRA(){
       return txtRA;
   }
   
    public void settxtRA (String txtRA){
        this.txtRA = txtRA;
    }
    
    public String gettxtCurso(){
       return txtCurso;
   }
   
    public void settxtCurso (String txtCurso){
        this.txtCurso = txtCurso;
    }
}
