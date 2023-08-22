package POO.LISTA1.exercicio1;

public class Pessoa {
    private String CPF, nome;
    private int sexo; //deveria ser char
    private int idade;

        public String getCPF(){
            return CPF;
        }
        public void setCPF(String value){
            this.CPF = value;
        }
        public String getnome(){
            return nome;
        }
        public void setnome(String value){
            this.nome = value;
        }
        public int getsexo(){
            return sexo;
        }
        public void setsexo(int value){
            this.sexo = value;
        }
        public int getidade(){
            return idade;
        }
        public void setidade(int value){
            this.idade = value;
        }

        public String imprimir(){
            String msg = "\n===================" 
                +"\nCPF: "+getCPF()
                +"\nNome: "+getnome()
                +"\nSexo: "+getsexo()
                +"\nIdade: "+getidade();
        
        return msg;
    
        }
    
}
