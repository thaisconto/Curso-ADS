import { Component } from '@angular/core';

@Component({
  selector: 'app-exemplo-diretiva',
  templateUrl: './exemplo-diretiva.component.html',
  styleUrl: './exemplo-diretiva.component.css'
})
export class ExemploDiretivaComponent {
  mostrarDivIf: boolean = true;
  cidade: string = '';
  listClientes: any[] = [
    { nome: 'João', cidade: 'São Paulo', celular: '11998989898' },
    { nome: 'Maria', cidade: 'Rio de Janeiro', celular: '21998989898' },
    { nome: 'José', cidade: 'Curitiba', celular: '41998989898' },
  ];

}
