import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientsInboxComponent } from './clients-inbox.component';

describe('ClientsInboxComponent', () => {
  let component: ClientsInboxComponent;
  let fixture: ComponentFixture<ClientsInboxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientsInboxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientsInboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
