import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExemploDiretivaComponent } from './exemplo-diretiva.component';

describe('ExemploDiretivaComponent', () => {
  let component: ExemploDiretivaComponent;
  let fixture: ComponentFixture<ExemploDiretivaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ExemploDiretivaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExemploDiretivaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
