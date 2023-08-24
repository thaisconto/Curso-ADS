package POO.aulaConstrutor.LISTA2.ex2;
import javax.swing.JOptionPane;

public class Main2 {
    public static void main (String[] args){
    int codigo;
    String nome, item;
    double percentualComissao, valorVenda, valorDesconto;
    Vendedor vendedor = null;

    do{
        item = JOptionPane.showInputDialog("1- Cadastrar vendedor\n2- Calcular venda\n3- Sair");
        if (item == null) {
            System.exit(0);    
        }

        switch(item){
            case "1": //criar apólice
                nome = (JOptionPane.showInputDialog("Nome: "));
                codigo = Integer.parseInt(JOptionPane.showInputDialog("Código: "));
                valorVenda = Integer.parseInt(JOptionPane.showInputDialog("Valor venda: "));
                valorDesconto = Double.parseDouble(JOptionPane.showInputDialog("Valor desconto: "));
                percentualComissao = Double.parseDouble(JOptionPane.showInputDialog("Percentual comissão: "));
            
                vendedor = new Vendedor(codigo, nome, percentualComissao);
                vendedor.setValorDesconto(valorDesconto);
                vendedor.setValorVenda(valorVenda);

                break;

            case "2": //mostrar dados
                if(vendedor == null){
                    JOptionPane.showMessageDialog(null, 
                    "Precisa cadastrar os dados",
                    "Alerta",
                    JOptionPane.ERROR_MESSAGE);
                break;
                }            
                JOptionPane.showMessageDialog(null, vendedor.imprimir());
                break;
           

            case "3": //sair
                JOptionPane.showMessageDialog(null, "Volte sempre!");
                break;

            default: //opção inválida
                JOptionPane.showMessageDialog(null, "Favor selecionar uma das opções!");
        }
    }while((!item.equals("3")));
}}


