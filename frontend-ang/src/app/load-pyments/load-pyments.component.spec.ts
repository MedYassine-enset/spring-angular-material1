import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadPymentsComponent } from './load-pyments.component';

describe('LoadPymentsComponent', () => {
  let component: LoadPymentsComponent;
  let fixture: ComponentFixture<LoadPymentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoadPymentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LoadPymentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
