import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-form-template-drive',
  templateUrl: './form-template-drive.component.html',
  styleUrls: ['./form-template-drive.component.css']
})
export class FormTemplateDriveComponent {

  cliente : any  = {};

  salvar(form: NgForm){
    if(form.valid){
      console.log(this.cliente);
    }
  }

}
