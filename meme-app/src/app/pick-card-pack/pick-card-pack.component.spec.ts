import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PickCardPackComponent } from './pick-card-pack.component';

describe('PickCardPackComponent', () => {
  let component: PickCardPackComponent;
  let fixture: ComponentFixture<PickCardPackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PickCardPackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PickCardPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
