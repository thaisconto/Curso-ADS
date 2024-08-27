import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tema2Component } from './tema2.component';

describe('Tema2Component', () => {
  let component: Tema2Component;
  let fixture: ComponentFixture<Tema2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Tema2Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tema2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
