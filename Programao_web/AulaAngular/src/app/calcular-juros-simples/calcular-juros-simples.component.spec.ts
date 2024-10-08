import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalcularJurosSimplesComponent } from './calcular-juros-simples.component';

describe('CalcularJurosSimplesComponent', () => {
  let component: CalcularJurosSimplesComponent;
  let fixture: ComponentFixture<CalcularJurosSimplesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalcularJurosSimplesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalcularJurosSimplesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
