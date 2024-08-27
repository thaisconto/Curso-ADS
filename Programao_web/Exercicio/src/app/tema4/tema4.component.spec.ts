import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tema4Component } from './tema4.component';

describe('Tema4Component', () => {
  let component: Tema4Component;
  let fixture: ComponentFixture<Tema4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Tema4Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tema4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
