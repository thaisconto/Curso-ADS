package POO.listasExercicios.LISTA1.exericio2;
import javax.swing.JOptionPane;

public class ex2 {
     public static void main(String[] args) {
    String RA, nome, item;
    float AC1, AC2, AG, AF;
    Aluno aluno = null;

    do{
            item = JOptionPane.showInputDialog("1- Criar aluno\n2- Mostrar aluno\n3- Sair");
            if (item == null) {
                System.exit(0);    
            }

        switch(item){
            case "1":
                //cadastrar aluno
               RA = JOptionPane.showInputDialog("RA:");
               nome = JOptionPane.showInputDialog("Nome:");
               AC1 = Float.parseFloat(JOptionPane.showInputDialog("AC1:"));
               AC2 = Float.parseFloat(JOptionPane.showInputDialog("AC2:"));
               AG = Float.parseFloat(JOptionPane.showInputDialog("AG:"));
               AF = Float.parseFloat(JOptionPane.showInputDialog("AF:"));

               aluno = new Aluno();
               aluno.setRA(RA);
               aluno.setnome(nome);
               aluno.setAC1(AC1);
               aluno.setAC2(AC2);
               aluno.setAG(AG);
               aluno.setAF(AF);
               
            break;

            case "2":
            //visualizar se estiver vazio dar aviso
                if(aluno == null){
                JOptionPane.showMessageDialog(null, 
                "Precisa cadastrar um aluno",
                "Alerta",
                JOptionPane.ERROR_MESSAGE);
            break;
            }            
            JOptionPane.showMessageDialog(null, aluno.imprimir());
            break;

            case "3":
            //sair
            JOptionPane.showMessageDialog(null, "Volte sempre");
            break;

            default:
            JOptionPane.showMessageDialog(null, "Favor selecionar uma opção!");
        }        

    }while(!item.equals("3"));
}}

