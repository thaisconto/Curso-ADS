package POO.listasExercicios.listaaula7Heranca.exercicio2;

public class Automovel {
    private String marca, modelo;

    public Automovel() {
    }

    public Automovel(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
   
   //imprimir automovel
    public String imprimir() {
        String msg = "\n-----------" 
                +"\nMarca: "+getMarca()
                +"\nModelo: "+getModelo();
                      
        return msg;        
    }
    
    //getters and setters

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}


