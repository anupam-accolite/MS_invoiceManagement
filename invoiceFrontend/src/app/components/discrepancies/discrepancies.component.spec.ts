import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscrepanciesComponent } from './discrepancies.component';

describe('DiscrepanciesComponent', () => {
  let component: DiscrepanciesComponent;
  let fixture: ComponentFixture<DiscrepanciesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiscrepanciesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscrepanciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
