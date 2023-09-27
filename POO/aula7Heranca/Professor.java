package POO.aula7Heranca;

public class Professor extends Pessoa {
    
    private String cracha;
    private char tipoVinculo;
    private double salario;

    public Professor() {
    }

    public Professor(String cracha, char tipoVinculo, double salario, String nome, String cpf) {
        super(nome, cpf);
        this.cracha = cracha;
        this.tipoVinculo = tipoVinculo;
        this.salario = salario;
    }
    

    public String getCracha() {
        return cracha;
    }

    public char getTipoVinculo() {
        return tipoVinculo;
    }

    public double getSalario() {
        return salario;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public void setTipoVinculo(char tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
      
    public String imprimir() {
        String msg = "\n-----------" 
                +"\nProfessor: "+getNome()
                +"\nCPF: "+getCpf()
                +"\nCracha: " + getCracha()
                +"\nTipo Vínculo: "+getTipoVinculo()
                +"\nSalário: R$ "+getSalario();                        
        return msg;      
    }  
    
}
