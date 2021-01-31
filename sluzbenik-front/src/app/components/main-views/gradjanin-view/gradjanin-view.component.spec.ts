import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradjaninViewComponent } from './gradjanin-view.component';

describe('GradjaninViewComponent', () => {
  let component: GradjaninViewComponent;
  let fixture: ComponentFixture<GradjaninViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradjaninViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GradjaninViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
