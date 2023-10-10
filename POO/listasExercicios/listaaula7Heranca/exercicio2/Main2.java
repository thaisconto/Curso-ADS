package POO.listasExercicios.listaaula7Heranca.exercicio2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main2 {

   
    public static void main(String args[]) {
        String nome, marca, modelo, item, buscarPessoa;
        int codigo;
        Automovel automovel = null;
        Pessoa pessoa = null;
        ArrayList<Pessoa> listPessoa = new ArrayList<>();
       
       
                          
        do{
        item = JOptionPane.showInputDialog("1 - Criar pessoa\n2 - Criar automóvel\n3 - Transferir automóvel\n4 - Mostrar pessoas\n5 - Mostrar autómoveis e pessoas\n6 - Sair");
        if (item == null) {
            System.exit(0);    
        }

        switch(item){
            case "1":
            //Criar pessoa: codigo, nome
                
                nome = (JOptionPane.showInputDialog("Nome: ")); 
                codigo = Integer.parseInt(JOptionPane.showInputDialog("Código: "));
                
                pessoa = new Pessoa (nome, codigo);
                listPessoa.add(pessoa);                       
                
                break;

            case "2":
                //Criar automóvel: marca, modelo (pergunte qual pessoa - nome)
                Pessoa pessoaX;
                
                buscarPessoa = JOptionPane.showInputDialog("Insira o nome da pessoa: ");
                 for (int i=0; i < listPessoa.size(); i++) {
                    if (listPessoa.get(i).getNome().equals(buscarPessoa)) {
                       pessoaX = listPessoa.get(i);
                       marca = (JOptionPane.showInputDialog("Marca: "));
                       modelo = (JOptionPane.showInputDialog("Modelo: ")); 
                                              
                       automovel = new Automovel (marca, modelo);
                       pessoaX.addAutomovel(automovel);
                    }
                  }            
                 
                 break;

            case "3":
                //Transferir automóvel (usuário seleciona a pessoa de origem e o seu automóvel e escolhe a pessoa de destino. O automóvel é excluído de um e inserido no outro)
                 
             break;
            
                        
            case "4":
                //Mostrar pessoas, se estiver vazio dar aviso
                if (listPessoa.isEmpty())
                     {JOptionPane.showMessageDialog( null, "Nenhum dado cadastrado");
                }
                else{
                    String str = "";
                    for (int i = 0; i < listPessoa.size(); i++){
                    str += "\n--------\n";
                    str += listPessoa.get(i).imprimir();
                }
                JOptionPane.showMessageDialog( null, str);
            }
                break;
                     
            case "5":
         //Mostrar automóvel e pessoa 
                if (listPessoa.isEmpty())
                     {JOptionPane.showMessageDialog( null, "Nenhum dado cadastrado");
                }
                else{
                    String str = "";
                    for (int i = 0; i < listPessoa.size(); i++){
                    str += "\n--------\n";
                    str += listPessoa.get(i).imprimirCompleto();
                }
                JOptionPane.showMessageDialog( null, str);
            }
                break;
            
                
            case "6":
                //sair
                JOptionPane.showMessageDialog(null, "Volte sempre!");
                break;

                default:
                JOptionPane.showMessageDialog(null, "Favor selecionar uma das opções!");
        }    
    }while(!item.equals("6"));
}
}