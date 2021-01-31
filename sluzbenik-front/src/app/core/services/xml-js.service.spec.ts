import { TestBed } from '@angular/core/testing';

import { XmlJsService } from './xml-js.service';

describe('XmlJsService', () => {
  let service: XmlJsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(XmlJsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
