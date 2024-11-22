import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExercicioAc2Component } from './exercicio-ac2.component';

describe('ExercicioAc2Component', () => {
  let component: ExercicioAc2Component;
  let fixture: ComponentFixture<ExercicioAc2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExercicioAc2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExercicioAc2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
