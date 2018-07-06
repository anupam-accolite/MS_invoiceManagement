import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TfrComponent } from './tfr.component';

describe('TfrComponent', () => {
  let component: TfrComponent;
  let fixture: ComponentFixture<TfrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TfrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TfrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
