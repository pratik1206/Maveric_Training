import { TestBed } from '@angular/core/testing';

import { KukaserviceService } from './plp.service';

describe('KukaserviceService', () => {
  let service: KukaserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KukaserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
