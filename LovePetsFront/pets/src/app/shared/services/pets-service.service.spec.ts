import { TestBed } from '@angular/core/testing';

import { PetsServiceService } from './pets-service.service';

describe('PetsServiceService', () => {
  let service: PetsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PetsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
