import { Component, OnInit } from '@angular/core';
import { ServiceTicketService } from "../service-ticket.service";
import { Servicereport } from "../model/servicereport";

@Component({
  selector: 'app-service-ticket-report',
  templateUrl: './service-ticket-report.component.html',
  styleUrls: ['./service-ticket-report.component.css']
})
export class ServiceTicketReportComponent implements OnInit {
  year!: number;
  serviceTicketReport!: Servicereport;

  constructor(private serviceTicketService: ServiceTicketService) { }

  getYearlyReport() {
    this.serviceTicketService.getServiceTicketReportOfYear(this.year).subscribe(data => {
      this.serviceTicketReport = data;
      //console.log(data);
    }, error => console.log(error));
  }

  ngOnInit(): void {
  }

  getMonths(): string[] {
    if (this.serviceTicketReport) {
      return Object.keys(this.serviceTicketReport);
    }
    return [];
  }


}
