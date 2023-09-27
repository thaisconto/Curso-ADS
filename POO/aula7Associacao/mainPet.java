package POO.aula7Associacao;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tha_c
 */
public class mainPet {

    /**
     * @param args the command line arguments
     */
    
    /*
    criar menu
    1 - cadastrar tutor
    2 - Pet (pergunte quem é o tutor - CPF)
    3 - listar tutores com seus pets
    4 - sair
    */
    
    public static void main(String args[]) {
        String item, nome, cpf, buscarCpf, raca;
        int idade;
        Pet pet = null;
        Tutor tutor = null;
        ArrayList<Tutor> listTutor = new ArrayList<>(); 
       
                          
        do{
        item = JOptionPane.showInputDialog("1- Cadastrar tutor\n2- Cadastrar Pet\n3- Mostrar\n4- Sair");
        if (item == null) {
            System.exit(0);    
        }

        switch(item){
            case "1":
            //cadastrar tutor: nome, cpf
                nome = (JOptionPane.showInputDialog("Nome: ")); 
                cpf = (JOptionPane.showInputDialog("CPF: "));
                
                tutor = new Tutor (nome, cpf);
                listTutor.add(tutor);                       
                break;

            case "2":
                //cadastrar pet (pergunte quem é o tutor - CPF)
                Tutor tutorX;
                
                buscarCpf = JOptionPane.showInputDialog("Insira o CPF do tutor: ");
                 for (int i=0; i < listTutor.size(); i++) {
                    if (listTutor.get(i).getCpf().equals(buscarCpf)) {
                       tutorX = listTutor.get(i);
                       nome = (JOptionPane.showInputDialog("Nome Pet: "));
                       raca = (JOptionPane.showInputDialog("Raça: ")); 
                       idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
                       
                       pet = new Pet (nome, raca, idade);
                       tutorX.addPet(pet);
                    }
                  }
                 
                 
                 
                 break;

            case "3":
                //mostrar, se estiver vazio dar aviso
                if (listTutor.isEmpty())
                     {JOptionPane.showMessageDialog( null, "Nenhum dado cadastrado");
                }
                else{
                    String str = "";
                    for (int i = 0; i < listTutor.size(); i++){
                    str += "\n--------\n";
                    str += listTutor.get(i).imprimir();
                }
                JOptionPane.showMessageDialog( null, str);
            }
                break;
                     
            
            case "4":
                //sair
                JOptionPane.showMessageDialog(null, "Volte sempre!");
                break;

                default:
                JOptionPane.showMessageDialog(null, "Favor selecionar uma das opções!");
        }    
    }while(!item.equals("4"));
}}


