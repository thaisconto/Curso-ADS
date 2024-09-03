import { Component } from '@angular/core';

@Component({
  selector: 'app-calcular-juros-simples',
  templateUrl: './calcular-juros-simples.component.html',
  styleUrl: './calcular-juros-simples.component.css'
})
export class CalcularJurosSimplesComponent {
  public capitalInicial : number = 0;
  public taxaJuros : number = 0;
  public tempo : number = 0;
  public juros : number = 0;
  public montante : number =0;
  public imgDinheiro : string = "https://static.vecteezy.com/ti/vetor-gratis/t1/8084989-dinheiro-saco-e-pilha-de-moeda-de-ouro-vetor.jpg";

  public calcularJuros(){
    this.juros = this.capitalInicial * (this.taxaJuros/100) * this.tempo;
    this.montante = this.juros + this.capitalInicial;
  }

}
