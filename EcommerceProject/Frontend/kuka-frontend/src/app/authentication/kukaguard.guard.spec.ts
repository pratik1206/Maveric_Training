import { TestBed } from '@angular/core/testing';

import { KukaguardGuard } from './kukaguard.guard';

describe('KukaguardGuard', () => {
  let guard: KukaguardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(KukaguardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
