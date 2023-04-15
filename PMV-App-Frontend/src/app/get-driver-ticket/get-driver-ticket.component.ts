import { Component, OnInit } from '@angular/core';
import {ServiceTicketService} from "../service-ticket.service";
import {ServiceTicket} from "../model/serviceticket";
import {SharedDataService} from "../shared-data.service";

@Component({
  selector: 'app-get-driver-ticket',
  templateUrl: './get-driver-ticket.component.html',
  styleUrls: ['./get-driver-ticket.component.css']
})
export class GetDriverTicketComponent implements OnInit {

  constructor(private serviceTicketService:ServiceTicketService,private sharedDataService:SharedDataService) { }

  serviceTickets!:ServiceTicket[];

  private getDriverTickets(){
    this.serviceTicketService.getDriverTickets(this.sharedDataService.userId).subscribe(data =>{
      console.log(data);
      this.serviceTickets = data;
    }, error => console.log(error));
  }

  ngOnInit(): void {
    this.getDriverTickets();
  }

}
