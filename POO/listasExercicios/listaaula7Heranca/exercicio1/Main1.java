package POO.listasExercicios.listaaula7Heranca.exercicio1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main1 {
public static void main(String args[]) {
        String nome, ra, item, buscarCurso, buscarAluno;
        int codigo, cargaHoraria;
        Aluno aluno = null;
        Curso curso = null;
        ArrayList<Curso> listCurso = new ArrayList<>();
        
       
                          
        do{
        item = JOptionPane.showInputDialog("1 - Criar curso\n2 - Criar aluno\n3 - Remover aluno\n4 - Mostrar cursos\n5 - Mostrar alunos\n6 - Sair");
        if (item == null) {
            System.exit(0);    
        }

        switch(item){
            case "1":
            //Criar curso: codigo, nome, cargaHoraria
                nome = (JOptionPane.showInputDialog("Nome: ")); 
                codigo = Integer.parseInt(JOptionPane.showInputDialog("Código: "));
                cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Carga Horária: "));
                
                curso = new Curso (nome, codigo, cargaHoraria);
                listCurso.add(curso);                       
                break;

            case "2":
                //criar aluno: nome, ra (pergunte qual curso - Código)
                Curso cursoX;
                
                buscarCurso = JOptionPane.showInputDialog("Insira o nome do curso do aluno: ");
                 for (int i=0; i < listCurso.size(); i++) {
                    if (listCurso.get(i).getNome().equals(buscarCurso)) {
                       cursoX = listCurso.get(i);
                       nome = (JOptionPane.showInputDialog("Nome aluno: "));
                       ra = (JOptionPane.showInputDialog("RA: ")); 
                                              
                       aluno = new Aluno (nome, ra);
                       cursoX.addAluno(aluno);
                    }
                  }            
                 
                 break;

            case "3":
                //remover aluno
                 Curso cursoY;
                
                buscarCurso = JOptionPane.showInputDialog("Insira o curso do aluno: ");
                 for (int i=0; i < listCurso.size(); i++) {
                    if (listCurso.get(i).getNome().equals(buscarCurso)) {
                       cursoY = listCurso.get(i);
                   /*   */ 
                       buscarAluno = (JOptionPane.showInputDialog("Digite o RA do aluno: "));
                       for (int x=0; x < cursoY.getListAluno().size(); x++) {
                           if (cursoY.getListAluno().get(x).getRa().equals(buscarAluno)){
                           cursoY.removeAluno(x);
                           
                            }                  
                                              
                }}}
                break;
            
                        
            case "4":
                //Mostrar cursos, se estiver vazio dar aviso
                if (listCurso.isEmpty())
                     {JOptionPane.showMessageDialog( null, "Nenhum dado cadastrado");
                }
                else{
                    String str = "";
                    for (int i = 0; i < listCurso.size(); i++){
                    str += "\n--------\n";
                    str += listCurso.get(i).imprimir();
                }
                JOptionPane.showMessageDialog( null, str);
            }
                break;
                     
            case "5":
                //Mostrar alunos, se estiver vazio dar aviso
                if (listCurso.isEmpty())
                     {JOptionPane.showMessageDialog( null, "Nenhum dado cadastrado");
                }
                else{
                    String str = "";
                    for (int i = 0; i < listCurso.size(); i++){
                    str += "\n--------\n";
                    str += listCurso.get(i).imprimirCompleto();
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