import { TestBed } from '@angular/core/testing';

import { ZahtevEditService } from './zahtev-edit.service';

describe('ZahtevEditService', () => {
  let service: ZahtevEditService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZahtevEditService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
