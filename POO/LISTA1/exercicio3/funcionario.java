package POO.LISTA1.exercicio3;

public class Funcionario {
    private String nome;
    private float valorHora, qntdHora, salario, valorDesconto, valorReceber;
    int cracha;
    int tipoVinculo; //deveria ser char H ou N

        public String getnome(){
            return nome;
        }
        public void setnome(String value){
            this.nome = value;
        }
        public float getvalorHora(){
            return valorHora;
        }
        public void setvalorHora(float value){
            this.valorHora = value;
        }
        public float getqntdHora(){
            return qntdHora;
        }
        public void setqntdHora(float value){
            this.qntdHora = value;
        }
        public float getsalario(){
            return salario;
        }
        public void setsalario(float value){
            this.salario = value;
        }
        public float getvalorDesconto(){
            return valorDesconto;
        }
        public void setvalorDesconto(float value){
            this.valorDesconto = value;
        }
        public int getcracha(){
            return cracha;
        }
        public void setcracha(int value){
            this.cracha = value;
        }
        public int gettipoVinculo(){
            return tipoVinculo;
        }
        public void settipoVinculo(int value){
            this.tipoVinculo = value;
        }     
        public float getvalorReceber(){
            return valorReceber;
        }
        public void setvalorReceber(float value){
            this.valorReceber = value;
        } 

        public String imprimir(){
            String msg = "\n===================" 
                +"\nCrachá: "+getcracha()
                +"\nNome: "+getnome()
                +"\nTipo Vínculo: "+gettipoVinculo()
                +"\nSalário: "+getsalario()
                +"\nDesconto: "+getvalorDesconto()
                +"\nValor a receber: "+getvalorReceber();
        
        return msg;    
        }

        public float calcularSalario(){
           valorReceber = valorHora * qntdHora;
            return valorReceber;
        }

        public float calcularValorReceber(){
            valorReceber = salario - valorDesconto;
            return valorReceber;
            
        }

}
