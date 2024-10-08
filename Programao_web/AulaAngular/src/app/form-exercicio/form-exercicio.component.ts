import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-exercicio',
  templateUrl: './form-exercicio.component.html',
  styleUrls: ['./form-exercicio.component.css']
})
export class FormExercicioComponent {

  form : FormGroup;

  constructor(){
    this.form = new FormGroup({
      ra: new FormControl('', [
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(10),
        Validators.pattern(/^\d+$/) // Validação para aceitar apenas números
        ]),
      nome: new FormControl('', Validators.required),
      curso: new FormControl('', Validators.required),
      dataMatricula: new FormControl(new Date().toISOString().split('T')[0], //padrão para data atual
        Validators.required),
      valorMensalidade: new FormControl('', Validators.required),
    });
  }

  salvar(){
    if(this.form.valid){
    console.log(this.form.value);
    }
  }
}
