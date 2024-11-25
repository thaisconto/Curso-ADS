import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { ExercicioAc2Component } from './exercicio-ac2.component';

describe('ExercicioAc2Component', () => {
  let component: ExercicioAc2Component;
  let fixture: ComponentFixture<ExercicioAc2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ExercicioAc2Component],
      imports: [ReactiveFormsModule, HttpClientTestingModule],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExercicioAc2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have an empty form initially', () => {
    expect(component.form.valid).toBeFalsy();
    expect(component.form.get('produto')?.value).toBe('');
    expect(component.form.get('quantidade')?.value).toBe('');
    expect(component.form.get('unidade')?.value).toBe('');
  });

  it('should validate form input', () => {
    component.form.patchValue({ produto: 'Arroz', quantidade: 1, unidade: 'kg' });
    expect(component.form.valid).toBeTruthy();
  });
});
