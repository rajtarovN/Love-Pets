import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputPetComponent } from './input-pet.component';

describe('InputPetComponent', () => {
  let component: InputPetComponent;
  let fixture: ComponentFixture<InputPetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InputPetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InputPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
