import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BrowsePatronsComponent } from './browse-patrons.component';

describe('BrowsePatronsComponent', () => {
  let component: BrowsePatronsComponent;
  let fixture: ComponentFixture<BrowsePatronsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BrowsePatronsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BrowsePatronsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
