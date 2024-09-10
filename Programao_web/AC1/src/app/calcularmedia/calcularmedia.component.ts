import { Component } from '@angular/core';

@Component({
  selector: 'app-calcularmedia',
  templateUrl: './calcularmedia.component.html',
  styleUrl: './calcularmedia.component.css'
})
export class CalcularmediaComponent {
  public ac1: number = 0;
  public ac2: number = 0;
  public ag: number = 0;
  public af: number = 0;
  public mediaFinal: number = 0;
  public status: string = '';

  calcularMedia(){
    this.mediaFinal = (this.ac1 * 0.15) + (this.ac2 * 0.30) + (this.ag * 0.10) + (this.af * 0.45);

    if (this.mediaFinal >= 5) {
      this.status = 'Aprovado';
    } else {
      this.status = 'Reprovado';
    }
  }

}
