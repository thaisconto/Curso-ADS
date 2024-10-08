import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormExercicioComponent } from './form-exercicio.component';

describe('FormExercicioComponent', () => {
  let component: FormExercicioComponent;
  let fixture: ComponentFixture<FormExercicioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormExercicioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormExercicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
