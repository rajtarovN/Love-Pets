import { TestBed } from '@angular/core/testing';

import { UsesrServiceService } from './usesr-service.service';

describe('UsesrServiceService', () => {
  let service: UsesrServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsesrServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
