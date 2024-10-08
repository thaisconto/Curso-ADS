import { Component } from '@angular/core';
import { Tarefa } from '../models/Tarefa';

@Component({
  selector: 'app-tarefa',
  templateUrl: './tarefa.component.html',
  styleUrls: ['./tarefa.component.css'],
})
export class TarefaComponent {
  // Array de tarefas
  tarefas: Tarefa[] = [
    new Tarefa('Estudar Angular', false),
    new Tarefa('Ler um livro', true),
    new Tarefa('Fazer exercícios', false),
    new Tarefa('Comprar mantimentos', true),
    new Tarefa('Limpar a casa', false),
  ];

  // Alterna o status de conclusão da tarefa
  alternarConclusao(tarefa: Tarefa) {
    tarefa.concluida = !tarefa.concluida;
  }
}
