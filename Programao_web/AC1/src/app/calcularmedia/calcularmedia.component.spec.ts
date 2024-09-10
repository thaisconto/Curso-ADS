import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalcularmediaComponent } from './calcularmedia.component';

describe('CalcularmediaComponent', () => {
  let component: CalcularmediaComponent;
  let fixture: ComponentFixture<CalcularmediaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CalcularmediaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalcularmediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
