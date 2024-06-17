import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalInboxComponent } from './rental-inbox.component';

describe('RentalInboxComponent', () => {
  let component: RentalInboxComponent;
  let fixture: ComponentFixture<RentalInboxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RentalInboxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RentalInboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
