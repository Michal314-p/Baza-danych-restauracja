import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogDostawaComponent } from './dialog-dostawa.component';

describe('DialogDostawaComponent', () => {
  let component: DialogDostawaComponent;
  let fixture: ComponentFixture<DialogDostawaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogDostawaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogDostawaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
