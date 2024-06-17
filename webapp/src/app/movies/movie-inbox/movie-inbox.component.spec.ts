import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieInboxComponent } from './movie-inbox.component';

describe('MovieInboxComponent', () => {
  let component: MovieInboxComponent;
  let fixture: ComponentFixture<MovieInboxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieInboxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieInboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
