import { Component } from '@angular/core';

@Component({
  selector: 'app-feature',
  templateUrl: './feature.component.html',
  styleUrl: './feature.component.css'
})
export class FeatureComponent {
  public numero1 : number = 0;
  public numero2 : number = 0;
  public resultado : number = 0;
  public caminhoLogo : string = "https://facens.br/wp-content/uploads/2021/03/logo-f.png";

  public somar(){
    this.resultado = this.numero1 + this.numero2;
  }
}
