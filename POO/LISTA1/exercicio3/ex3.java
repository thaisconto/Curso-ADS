package POO.LISTA1.exercicio3;
import javax.swing.JOptionPane;

import POO.LISTA1.exericio2.Aluno;

public class ex3 {
     public static void main(String[] args) {
    String nome, item;
    float valorHora, qntdHora, salario, valorDesconto, valorReceber;
    int cracha;
    int tipoVinculo; //deveria ser char H ou N
    Funcionario funcionario = null;

        do{
            item = JOptionPane.showInputDialog("1- Criar funcionário\n2- Mostrar folha de pagamento\n3- Alterar remuneração\n4- Sair");
            if (item == null) {
                System.exit(0);    
        }

        switch(item){
            case "1":
            //cadastrar funcionário
               cracha = JOptionPane.showInputDialog("Cracha:");
               nome = JOptionPane.showInputDialog("Nome:");
               valorDesconto = JOptionPane.showInputDialog("Valor desconto:");
               
               //VÍNCULO pode ser H ou N
               tipoVinculo = JOptionPane.showInputDialog("Tipo vínculo:");
               
               //IF - H – horista (entra com horas trabalhadas e valor hora para calcular o salário)
               valorHora = JOptionPane.showInputDialog("Valor hora:");
               qntdHora = JOptionPane.showInputDialog("Quantidade hora:");
               //IF - N – normal (entra apenas com salário
               salario = JOptionPane.showInputDialog("Salário:");
               

               funcionario = new Funcionario();
               funcionario.setcracha(cracha);
               funcionario.setnome(nome);
               funcionario.settipoVinculo(tipoVinculo);
               funcionario.setvalorHora(valorHora);
               funcionario.setqntdHora(qntdHora);
               funcionario.setsalario(salario);
               funcionario.setvalorDesconto(valorDesconto);
               
            break;

            case "2":
            //visualizar
            //se estiver vazio dar aviso
                if(funcionario == null){
                    JOptionPane.showMessageDialog(null, 
                                "Precisa cadastrar os dados",
                                "Alerta",
                                JOptionPane.ERROR_MESSAGE);
            break;
                }
            
            JOptionPane.showMessageDialog(null, funcionario.imprimir());
                break;

            case "3":
            //alterar remuneração
            //eceber novamente salário ou valor hora e qtde hora dependendo do tipo vínculo
            break;
            
            case "4":
            //sair
            break;

            default:
        }        

    }while(!item.equals("3"));
}}


}
