import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceTicketReportComponent } from './service-ticket-report.component';

describe('ServiceTicketReportComponent', () => {
  let component: ServiceTicketReportComponent;
  let fixture: ComponentFixture<ServiceTicketReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceTicketReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceTicketReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
