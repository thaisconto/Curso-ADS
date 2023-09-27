package POO.aula7Heranca;



/**
 *
 * @author tha_c
 */
public class mainPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Aluno aluno1 = new Aluno("123", 8.0, 7.0, "Thaís", "123456");
        Professor prof1 = new Professor("123", 'c', 2000, "Marcos", "123456");
        
        System.out.println(aluno1.imprimir());
        System.out.println(prof1.imprimir());
        
       
    }
}
