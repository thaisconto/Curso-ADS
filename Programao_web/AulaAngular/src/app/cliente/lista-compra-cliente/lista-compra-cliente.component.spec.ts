import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCompraClienteComponent } from './lista-compra-cliente.component';

describe('ListaCompraClienteComponent', () => {
  let component: ListaCompraClienteComponent;
  let fixture: ComponentFixture<ListaCompraClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaCompraClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaCompraClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
