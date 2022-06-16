import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SinglePersonFormComponent } from './single-person-form.component';

describe('SinglePersonFormComponent', () => {
  let component: SinglePersonFormComponent;
  let fixture: ComponentFixture<SinglePersonFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SinglePersonFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SinglePersonFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
