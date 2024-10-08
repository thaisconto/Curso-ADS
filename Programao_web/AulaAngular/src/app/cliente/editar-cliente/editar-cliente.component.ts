import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrls: ['./editar-cliente.component.css'],
})
export class EditarClienteComponent implements OnInit {
  id: number = 0;
  constructor(public route: ActivatedRoute) {}
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'] ?? 0;
  }
}
