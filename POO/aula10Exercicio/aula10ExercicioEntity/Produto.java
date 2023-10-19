package POO.aula10Exercicio.aula10ExercicioEntity;

public class Produto {
    String nome;
    int ID, quantidadeProduto;
    double valorProduto;

    public Produto() {
    }
   
    public Produto(int ID, String nome, int quantidadeProduto, double valorProduto) {
        this.nome = nome;
        this.ID = ID;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
    }

    
    public String imprimir() {
        String mensagem =  
                "\nID: "+getID()
                +"\nNome: "+getNome()
                +"\nQuantidade: "+getQuantidadeProduto()
                +"\nValor: " +getValorProduto();
               
                       
        return mensagem;
    }
    
    
    public String getNome() {
        return nome;
    }

    

    public int getID() {
        return ID;
    }

    public String getIDString() {
        return Integer.toString(ID);
    }
    
            
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    
    
}
