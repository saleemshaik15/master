import {Observable} from "rxjs";
import { Injectable } from '@angular/core';
import {ServiceTicket} from "./model/serviceticket";
import {Servicereport} from "./model/servicereport";
import {SharedDataService} from "./shared-data.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})

export class ServiceTicketService {

  baseUrl:string;

  constructor(private httpClient:HttpClient, private sharedDataService:SharedDataService) {
    this.baseUrl = "http://localhost:8282/ticket/";
  }

  getDriverTickets(driverId: number): Observable<ServiceTicket[]> {
      const headers = new HttpHeaders({Authorization:'Basic '+btoa(this.sharedDataService.username+":"+this.sharedDataService.password)});
      return this.httpClient.get<ServiceTicket[]>(`${this.baseUrl}driver/`+driverId,{headers});
  }

  createTicket(serviceTicket: ServiceTicket): Observable<ServiceTicket> {
      const headers = new HttpHeaders({Authorization:'Basic '+btoa(this.sharedDataService.username+":"+this.sharedDataService.password)});
      return this.httpClient.post<ServiceTicket>(`${this.baseUrl}create`,serviceTicket,{headers});
  }

  getServiceTicketReportOfYear(year: number): Observable<Servicereport> {
      const headers = new HttpHeaders({Authorization:'Basic '+btoa(this.sharedDataService.username+":"+this.sharedDataService.password)});
      return this.httpClient.get<Servicereport>(`${this.baseUrl}report/`+year,{headers});
  }

}
