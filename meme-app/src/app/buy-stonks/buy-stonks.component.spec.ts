import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyStonksComponent } from './buy-stonks.component';

describe('BuyStonksComponent', () => {
  let component: BuyStonksComponent;
  let fixture: ComponentFixture<BuyStonksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuyStonksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuyStonksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
