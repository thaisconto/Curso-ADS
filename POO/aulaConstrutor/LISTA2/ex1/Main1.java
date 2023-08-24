package POO.aulaConstrutor.LISTA2.ex1;
import javax.swing.JOptionPane;

public class Main1 {
    public static void main(String[] args) {
    int numero, idade;
    String nome, item;
    double valorAutomovel, valorApolice;
    char sexo;
    Apolice apolice = null;
    

    do{
        item = JOptionPane.showInputDialog("1- Criar apólice\n2- Ver dados apólice\n3- Sair");
        if (item == null) {
            System.exit(0);    
        }

        switch(item){
            case "1": //criar apólice
                nome = (JOptionPane.showInputDialog("Nome: "));
                numero = Integer.parseInt(JOptionPane.showInputDialog("Número: "));
                idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
                sexo = (JOptionPane.showInputDialog("Sexo: ").charAt(0));
                valorAutomovel = Double.parseDouble(JOptionPane.showInputDialog("Valor automóvel: "));
                
                apolice = new Apolice(numero, nome, idade, sexo, valorAutomovel);

                break;

            case "2": //mostrar dados
                if(apolice == null){
                    JOptionPane.showMessageDialog(null, 
                    "Precisa cadastrar os dados",
                    "Alerta",
                    JOptionPane.ERROR_MESSAGE);
                break;
                }            
                JOptionPane.showMessageDialog(null, apolice.imprimir());
                break;
           

            case "3": //sair
                JOptionPane.showMessageDialog(null, "Volte sempre!");
                break;

            default: //opção inválida
                JOptionPane.showMessageDialog(null, "Favor selecionar uma das opções!");
        }
    }while((!item.equals("3")));
}}
