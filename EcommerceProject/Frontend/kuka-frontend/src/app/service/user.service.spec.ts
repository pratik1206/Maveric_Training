import { TestBed } from '@angular/core/testing';

import { EcommerceserviceService } from './user.service';

describe('EcommerceserviceService', () => {
  let service: EcommerceserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EcommerceserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
