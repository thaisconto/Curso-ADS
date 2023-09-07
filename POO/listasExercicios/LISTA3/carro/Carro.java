package POO.listasExercicios.LISTA3.carro;

public class Carro {
    private String txtModelo, txtMarca, txtCor;
    private int txtAnoFabricacao;
    
    public String imprimir(){
        return "\nModelo: " + gettxtModelo()
               + "\nMarca: " + gettxtMarca()
               + "\nCor: " + gettxtCor()
               + "\nAno de Fabricação: " + gettxtAnoFabricacao();
}

public String gettxtModelo(){
       return txtModelo;
   }
   
public void settxtModelo (String txtModelo){
      this.txtModelo = txtModelo;    
    
}
public String gettxtMarca(){
       return txtMarca;
   }
   
public void settxtMarca (String txtMarca){
      this.txtMarca = txtMarca;    
    
}
public String gettxtCor(){
       return txtCor;
   }
   
public void settxtCor (String txtCor){
      this.txtCor = txtCor;    
    
}
public int gettxtAnoFabricacao(){
       return txtAnoFabricacao;
   }
   
public void settxtAnoFabricacao (int txtAnoFabricacao){
      this.txtAnoFabricacao = txtAnoFabricacao;    
    
}
}
