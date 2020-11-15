import { TestBed } from '@angular/core/testing';

import { RestAppService } from './rest-app.service';

describe('RestAppService', () => {
  let service: RestAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
