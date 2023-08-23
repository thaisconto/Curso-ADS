package POO.LISTA1.exercicio3;
import javax.swing.JOptionPane;


public class ex3 {
     public static void main(String[] args) {
    String nome, item;
    float valorHora, qntdHora, salario, valorDesconto;
    int cracha;
    char tipoVinculo;
    Funcionario funcionario = null;

    do{
        item = JOptionPane.showInputDialog("1- Criar funcionário\n2- Mostrar folha de pagamento\n3- Alterar remuneração\n4- Sair");
        if (item == null) {
            System.exit(0);    
        }

        switch(item){
            case "1":
            //cadastrar funcionário
            cracha = Integer.parseInt(JOptionPane.showInputDialog("Cracha:"));
            nome = JOptionPane.showInputDialog("Nome:");
            valorDesconto = Float.parseFloat(JOptionPane.showInputDialog("Valor desconto:"));
               
            //VÍNCULO pode ser H ou N
            tipoVinculo = JOptionPane.showInputDialog("Tipo vínculo - H: horista ou N: normal").charAt(0);
            if (tipoVinculo == 'H' || tipoVinculo == 'h'){
                //IF horista entra com horas trabalhadas e valor hora para calcular o salário
                valorHora = Float.parseFloat(JOptionPane.showInputDialog("Valor hora:"));
                qntdHora = Float.parseFloat(JOptionPane.showInputDialog("Quantidade hora:"));
                funcionario.setvalorHora(valorHora);
                funcionario.setqntdHora(qntdHora);
                //funcionario.setsalario( como chamar o método?);
            }
            else if (tipoVinculo == 'N' || tipoVinculo == 'n'){
                //IF normal entra apenas com salário
                salario = Float.parseFloat(JOptionPane.showInputDialog("Salário:"));
                funcionario.setsalario(salario);               
            }
            else{
                JOptionPane.showMessageDialog(null, 
                    "Erro: Favor inserir H ou N para tipo de vínculo",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }                                             
            funcionario = new Funcionario();
            funcionario.setcracha(cracha);
            funcionario.setnome(nome);
            funcionario.settipoVinculo(tipoVinculo);                             
            funcionario.setvalorDesconto(valorDesconto);
            
            break;

            case "2":
            //visualizar se estiver vazio dar aviso
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
            //alterar remuneração: receber novo salário, valor hora e qtde hora dependendo do tipo vínculo
            tipoVinculo = JOptionPane.showInputDialog("Tipo vínculo - H: horista ou N: normal").charAt(0);
            if (tipoVinculo == 'H' || tipoVinculo == 'h'){
                //IF horista entra com horas trabalhadas e valor hora para calcular o salário
                valorHora = Float.parseFloat(JOptionPane.showInputDialog("Valor hora:"));
                qntdHora = Float.parseFloat(JOptionPane.showInputDialog("Quantidade hora:"));
                funcionario.setvalorHora(valorHora);
                funcionario.setqntdHora(qntdHora);
                //funcionario.setsalario( como chamar o método? );
            }
            else if (tipoVinculo == 'N' || tipoVinculo == 'n'){
                //IF normal entra apenas com salário
                salario = Float.parseFloat(JOptionPane.showInputDialog("Salário:"));
                funcionario.setsalario(salario);               
            }
            else{
                JOptionPane.showMessageDialog(null, 
                    "Erro: Favor inserir H ou N para tipo de vínculo",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
            break;
            
            case "4":
            //sair
            break;

            default:
        }    
    }while(!item.equals("4"));
}}
