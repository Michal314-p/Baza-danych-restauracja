import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DostawaComponent } from './dostawa.component';

describe('DostawaComponent', () => {
  let component: DostawaComponent;
  let fixture: ComponentFixture<DostawaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DostawaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DostawaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
