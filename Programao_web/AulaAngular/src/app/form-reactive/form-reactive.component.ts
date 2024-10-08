import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-reactive',
  templateUrl: './form-reactive.component.html',
  styleUrls: ['./form-reactive.component.css']
})
export class FormReactiveComponent {
  form : FormGroup;

  constructor(){
    this.form = new FormGroup({
      nome: new FormControl('já começa escrito', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      celular: new FormControl(''),
    });
  }

  salvar(){
    console.log(this.form.value);
  }

}
