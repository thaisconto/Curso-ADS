import { Component } from '@angular/core';
import { Cliente } from 'src/app/models/Cliente';

@Component({
  selector: 'app-lista-cliente',
  templateUrl: './lista-cliente.component.html',
  styleUrls: ['./lista-cliente.component.css'],
})
export class ListaClienteComponent {
  clientes: Cliente[] = [
    { id: 1, nome: 'João', celular: '999999999', email: 'teste@teste' },
    { id: 2, nome: 'José', celular: '999999999', email: 'teste@teste' },
    { id: 3, nome: 'Maria', celular: '999999999', email: 'teste@teste' },
  ];
}
