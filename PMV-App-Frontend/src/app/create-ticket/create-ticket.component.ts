import { Component, OnInit } from '@angular/core';
import {Car} from "../model/car";
import {Driver} from "../model/driver";
import {CarService} from "../car.service";
import {ServiceTicketService} from "../service-ticket.service";
import {ServiceTicket} from "../model/serviceticket";

@Component({
  selector: 'app-crete-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})

export class CreateTicketComponent implements OnInit {
  cars!:Car[];
  serviceTicket: ServiceTicket = new ServiceTicket();
  constructor(private carService:CarService, private serviceTicketService:ServiceTicketService) {
  }

  ngOnInit(): void { this.getAllCars(); }

  createServiceTicket(){
    console.log(this.serviceTicket);
    this.serviceTicketService.createTicket(this.serviceTicket).subscribe(data => {
      console.log(data);
      alert("Service Ticket created.")
    }, error => console.log(error));
  }

  getAllCars() {
    this.carService.getAllCars().subscribe(data => {
      this.cars = data;
      console.log(this.cars);
    }, error => console.log(error));
  }

}
