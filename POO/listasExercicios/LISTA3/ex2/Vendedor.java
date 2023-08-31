package POO.listasExercicios.LISTA3.ex2;

public class Vendedor {
    private int codigo;
    private String nome;
    private double percentualComissao, valorVenda, valorDesconto;

    public Vendedor(){

    }

    public Vendedor(int codigo, String nome, double percentualComissao){
        this.codigo = codigo;
        this.nome = nome;
        this.percentualComissao = percentualComissao;
    }

    public double calcularPagamentoComissao(double valorVenda){
        return valorVenda * percentualComissao /100;
    }

    public double calcularPagamentoComissao(double valorVenda, double valorDesconto){
        return calcularPagamentoComissao(valorVenda) - valorDesconto;

    }

    public String imprimir(){
        return "Codigo: " + getCodigo()
                +"\nNome: " + getNome()
                +"\nValor venda: " + getValorVenda()
                +"\n%Comissão: " + getPercentualComissao()
                +"\nDesconto: " + getValorDesconto()
                +"\nValor a pagar: "+ calcularPagamentoComissao(valorVenda, valorDesconto);
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPercentualComissao() {
        return percentualComissao;
    }
    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }
    public double getValorDesconto() {
        return valorDesconto;
    }
    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
    public double getValorVenda() {
        return valorVenda;
    }
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
