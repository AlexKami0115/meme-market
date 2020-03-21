import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeSelectCardsComponent } from './trade-select-cards.component';

describe('TradeSelectCardsComponent', () => {
  let component: TradeSelectCardsComponent;
  let fixture: ComponentFixture<TradeSelectCardsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeSelectCardsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeSelectCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
