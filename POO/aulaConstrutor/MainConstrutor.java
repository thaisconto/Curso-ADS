package POO.aulaConstrutor;

public class MainConstrutor {
    public static void main(String[] args) {
        //nesse caso eu instaciei o aluno já com os atrubutos, não preciso dar set depois
        Aluno aluno1 = new Aluno("Thaís", "123", "POO");
        
        Aluno aluno2 = new Aluno("123");
        System.out.println(aluno2.imprimir());

        Pessoa pessoa1 = new Pessoa("123", "Pessoa");
        pessoa1.setcarteiraMotorista("ab");
        System.out.println(pessoa1.imprimir());
}}
