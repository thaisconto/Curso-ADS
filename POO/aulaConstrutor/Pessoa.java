package POO.aulaConstrutor;

public class Pessoa {
    String CPF, nome, carteiraMotorista;


    //criar construtor pessoa onde só CPF e nome são obrigatórios
    public Pessoa(String CPF, String nome){
        this.CPF = CPF;
        this.nome = nome;        
    }

    public String getcarteiraMotorista() {
        return carteiraMotorista;
    }
    public void setcarteiraMotorista(String curso) {
        this.carteiraMotorista = carteiraMotorista;
    }

    public String imprimir(){
        return "Nome: " + nome   
                +"\nCPF: " + CPF
                +"\nCarteira motorista: " + getcarteiraMotorista();
    }
  
}
