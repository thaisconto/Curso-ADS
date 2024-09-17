import { Component } from '@angular/core';

@Component({
  selector: 'app-exemplo-diretiva',
  templateUrl: './exemplo-diretiva.component.html',
  styleUrl: './exemplo-diretiva.component.css'
})
export class ExemploDiretivaComponent {
  mostrarDivIf : boolean = true;
  listClientes : any[] = [
    {nome:'Thais', cidade: 'Sorocaba', celular: '11999999999'},
    {nome:'Marcos', cidade: 'Natal', celular: '22999999999'},
    {nome:'Gustavo', cidade: 'São Paulo', celular: '33999999999'},
    ];
  cidade : string = "";

}
