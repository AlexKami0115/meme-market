import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherUsersCollectionComponent } from './other-users-collection.component';

describe('OtherUsersCollectionComponent', () => {
  let component: OtherUsersCollectionComponent;
  let fixture: ComponentFixture<OtherUsersCollectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherUsersCollectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherUsersCollectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
