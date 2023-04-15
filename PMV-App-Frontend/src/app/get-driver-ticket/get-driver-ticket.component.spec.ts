import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDriverTicketComponent } from './get-driver-ticket.component';

describe('GetDriverTicketComponent', () => {
  let component: GetDriverTicketComponent;
  let fixture: ComponentFixture<GetDriverTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDriverTicketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetDriverTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
