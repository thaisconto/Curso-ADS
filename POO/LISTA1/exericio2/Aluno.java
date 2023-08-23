package POO.LISTA1.exericio2;

public class Aluno {
    private String RA, nome, situacao;
    private float AC1, AC2, AG, AF, media;
    
        public String getRA(){
            return RA;
        }
        public void setRA(String value){
            this.RA = value;
        }
        public String getnome(){
            return nome;
        }
        public void setnome(String value){
            this.nome = value;
        }
        public float getAC1(){
            return AC1;
        }
        public void setAC1(float value){
            this.AC1 = value;
        }
        public float getAC2(){
            return AC2;
        }
        public void setAC2(float value){
            this.AC2 = value;
        }
        public float getAG(){
            return AG;
        }
        public void setAG(float value){
            this.AG = value;
        }
        public float getAF(){
            return AF;
        }
        public void setAF(float value){
            this.AF = value;
        }

        public float getmedia(){
            return calcularMedia();
        }
        public void setmedia(float value){
            this.media = value;
        }     
        public String getsituacao(){
            return verificarAprovacao();
        }
        public void setsitucao(String value){
            this.situacao = value;
        }

        public String imprimir(){
            String msg = "\n===================" 
                +"\nRA: "+getRA()
                +"\nNome: "+getnome()
                +"\nAC1: "+getAC1()
                +"\nAC2: "+getAC2()
                +"\nAG: "+getAG()
                +"\nAF: "+getAF()
                +"\nMédia: "+ getmedia()
                +"\nSituação: "+getsituacao()
                ;
        
        return msg;    
        }

        public float calcularMedia(){
            media = (AC1 * 0.15f) + (AC2 * 0.30f) + (AG * 0.10f) + (AF * 0.45f);
            return media;

        }

        public String verificarAprovacao(){
            if (getmedia() <= 5){
                situacao = "Reprovado";
            }else {situacao = "Aprovado";};

        }

}
