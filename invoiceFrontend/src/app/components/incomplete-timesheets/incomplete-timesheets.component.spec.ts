import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncompleteTimesheetsComponent } from './incomplete-timesheets.component';

describe('IncompleteTimesheetsComponent', () => {
  let component: IncompleteTimesheetsComponent;
  let fixture: ComponentFixture<IncompleteTimesheetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncompleteTimesheetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncompleteTimesheetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
