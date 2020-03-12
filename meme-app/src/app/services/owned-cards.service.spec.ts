import { TestBed } from '@angular/core/testing';

import { OwnedCardsService } from './owned-cards.service';

describe('OwnedCardsService', () => {
  let service: OwnedCardsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OwnedCardsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
