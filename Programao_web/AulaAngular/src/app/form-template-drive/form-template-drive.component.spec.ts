import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTemplateDriveComponent } from './form-template-drive.component';

describe('FormTemplateDriveComponent', () => {
  let component: FormTemplateDriveComponent;
  let fixture: ComponentFixture<FormTemplateDriveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormTemplateDriveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormTemplateDriveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
