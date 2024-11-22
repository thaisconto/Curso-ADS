import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-exercicio-ac2',
  templateUrl: './exercicio-ac2.component.html',
  styleUrls: ['./exercicio-ac2.component.css']
})
export class ExercicioAc2Component {
  form: FormGroup;
  listaDeCompras: any[] = [];
  mostrarTabela: boolean = false; // Variável para controlar a exibição da tabela

  constructor() {
    this.form = new FormGroup({
      produto: new FormControl('', Validators.required),
      unidade: new FormControl('', Validators.required),
      quantidade: new FormControl('', Validators.required),
    });
  }

  adicionar() {
    if (this.form.valid) {
      this.listaDeCompras.push(this.form.value);
      this.form.reset(); // Limpa o formulário após adicionar
    }
  }

  listar() {
    this.mostrarTabela = true; // Ativa a exibição da tabela
  }
}
