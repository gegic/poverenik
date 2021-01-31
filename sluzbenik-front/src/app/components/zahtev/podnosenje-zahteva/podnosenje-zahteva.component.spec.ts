import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PodnosenjeZahtevaComponent } from './podnosenje-zahteva.component';

describe('PodnosenjeZahtevaComponent', () => {
  let component: PodnosenjeZahtevaComponent;
  let fixture: ComponentFixture<PodnosenjeZahtevaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PodnosenjeZahtevaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PodnosenjeZahtevaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
