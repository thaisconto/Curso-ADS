import { Component } from '@angular/core';

@Component({
  selector: 'app-imc',
  templateUrl: './imc.component.html',
  styleUrl: './imc.component.css'
})

export class ImcComponent {
  peso: number = 0;
  altura: number = 0;
  imc: number | null = null;
  classificacao: string = '';

  calcularIMC(){
    if (this.peso > 0 && this.altura > 0) {
      this.imc = this.peso / (this.altura * this.altura);
      this.classificarIMC(this.imc);
    } else {
      this.imc = null;
      this.classificacao = 'Por favor, insira valores válidos.';
    }
  }

  classificarIMC(imc: number): void {
    if (imc < 18.5) {
      this.classificacao = 'Abaixo do peso';
    } else if (imc >= 18.5 && imc <= 24.9) {
      this.classificacao = 'Peso normal';
    } else if (imc >= 25 && imc <= 29.9) {
      this.classificacao = 'Sobrepeso';
    } else if (imc >= 30 && imc <= 34.9) {
      this.classificacao = 'Obesidade grau I';
    } else if (imc >= 35 && imc <= 39.9) {
      this.classificacao = 'Obesidade grau II';
    } else if (imc >= 40) {
      this.classificacao = 'Obesidade grau III';
    }
  }
}
