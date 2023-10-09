public class Desenvolvedor {
    private String nome, cpf;
    private char genero;
    private double valorHora, qtdHoras;

    public Desenvolvedor() {
    }

    public Desenvolvedor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    
    public String imprimir() {
        String mensagem =  
                "\nNome: "+getNome()
                +"\nCPF: "+getCpf()
                +"\nGênero: "+getGenero()
                +"\nValor Hora: " +getValorHora();
                       
        return mensagem;
    }
    
    public String imprimir(double qtdHoras) {
        String mensagem =  
                "\nNome: "+getNome()
                +"\nCPF: "+getCpf()
                +"\nGênero: "+getGenero()
                +"\nValor Hora: " +getValorHora()
                +"\nQuantidade Horas: "+getQtdHoras()
                +"\nSalário R$ "+calculaSalario(qtdHoras);
                       
        return mensagem;
    }
    public double calculaSalario(double qtdHOras){
        return qtdHoras * valorHora;
    }
    
    public double getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(double qtdHoras) {
        this.qtdHoras = qtdHoras;
    }
    
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public char getGenero() {
        return genero;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
    
    
    
    
}
