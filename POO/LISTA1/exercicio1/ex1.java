package POO.LISTA1.exercicio1;
import javax.swing.JOptionPane;

public class ex1 {
          
    public static void main(String[] args) {
      String CPF, nome, item;
      char sexo;
      int idade;
      Pessoa pessoa = null;

        do{
            item = JOptionPane.showInputDialog("1- Criar pessoa\n2- Mostrar pessoa\n3- Sair");
            if (item == null) {
                System.exit(0);    
        }

        switch(item){
            case "1":
                //cadastrar pessoa
               CPF = JOptionPane.showInputDialog("CPF:");
               nome = JOptionPane.showInputDialog("Nome:");
               sexo = JOptionPane.showInputDialog("Sexo:").charAt(0);
               idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));

               pessoa = new Pessoa();
               pessoa.setCPF(CPF);
               pessoa.setnome(nome);
               pessoa.setsexo(sexo);
               pessoa.setidade(idade);

            break;

            case "2":
            //visualizar, se estiver vazio dar aviso
                if(pessoa == null){
                    JOptionPane.showMessageDialog(null, 
                                "Precisa cadastrar uma pessoa",
                                "Alerta",
                                JOptionPane.ERROR_MESSAGE);
                break;
                }
            
            JOptionPane.showMessageDialog(null, pessoa.imprimir());
            break;

            case "3":
            //sair, inserir volte sempre
            break;
            
            default:
            //opção inválida
        }
        
    }while(!item.equals("3"));
}}


