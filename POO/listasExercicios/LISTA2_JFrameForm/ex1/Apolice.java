package POO.listasExercicios.LISTA2_JFrameForm.ex1;

public class Apolice {
    private int numero, idade;
    private String nome;
    private double valorAutomovel, valorApolice;
    private char sexo;
    

        public Apolice(int numero, String nome, int idade, char sexo, double valorAutomovel){
        this.numero = numero;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.valorAutomovel = valorAutomovel;
    }
    
    public String imprimir(){
        return "\nNúmero: " + getNumero()
                +"\nNome: " + getNome()
                +"\nIdade: " + getIdade()
                +"\nSexo: " + getSexo()
                +"\nValor automóvel: " + getValorAutomovel()
                +"\n-----------------------------"
                +"\nValor apolice: " + getValorApolice();
    }

    public double calcularApolice(){
        if (sexo == 'M' && idade <= 25){
        valorApolice = valorAutomovel * 10/100;
        return valorApolice;    
        } 
        else if (sexo == 'M' && idade >25){
        valorApolice = valorAutomovel * 5/10;
        return valorApolice;    
        }
        else {
        valorApolice = valorAutomovel * 2/100;
        return valorApolice;
        }
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public double getValorAutomovel() {
        return valorAutomovel;
    }
    public void setValorAutomovel(double valorAutomovel) {
        this.valorAutomovel = valorAutomovel;
    }
    public double getValorApolice() {
        return calcularApolice();
    }
    public void setValorApolice(double valorApolice) {
        this.valorApolice = valorApolice;
    }
    
}
