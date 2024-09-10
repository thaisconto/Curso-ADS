import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConversortemperaturaComponent } from './conversortemperatura.component';

describe('ConversortemperaturaComponent', () => {
  let component: ConversortemperaturaComponent;
  let fixture: ComponentFixture<ConversortemperaturaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ConversortemperaturaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConversortemperaturaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
