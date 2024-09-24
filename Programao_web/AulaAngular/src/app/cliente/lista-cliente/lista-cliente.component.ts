import { Component } from '@angular/core';
import { Cliente } from '../../models/Cliente';

@Component({
  selector: 'app-lista-cliente',
  templateUrl: './lista-cliente.component.html',
  styleUrl: './lista-cliente.component.css'
})
export class ListaClienteComponent {
  clientes: Cliente[] = [
    {id:1, nome:'Thais', celular: '11999999999', email:'email@email.com'},
    {id:2, nome:'Marcos', celular: '22999999999', email:'email@email.com'},
    {id:3, nome:'Gustavo', celular: '33999999999', email:'email@email.com'},
];
}
