import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCardPackComponent } from './view-card-pack.component';

describe('ViewCardPackComponent', () => {
  let component: ViewCardPackComponent;
  let fixture: ComponentFixture<ViewCardPackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCardPackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCardPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
