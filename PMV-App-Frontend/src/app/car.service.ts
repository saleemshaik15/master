import { Car } from './model/car';
import { Observable } from 'rxjs';
import { Usercred } from './usercred';
import { Injectable } from '@angular/core';
import { SharedDataService } from './shared-data.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class CarService {

  baseUrl:string;

  constructor(private httpClient: HttpClient, private sharedDataService: SharedDataService) {
    this.baseUrl = "http://localhost:8282/car";
   }

   public createCar(car:Car): Observable<Car>{
    //console.log(this.sharedDataService.username+"-"+this.sharedDataService.password);
    const headers = new HttpHeaders({Authorization:'Basic '+btoa(this.sharedDataService.username+":"+this.sharedDataService.password)});
    //return this.httpClient.get(this.baseUrl, {headers, responseType:'text' as 'json'});
    return this.httpClient.post<Car>(`${this.baseUrl}/create`,car,{headers});
   }

   public getAllCars(): Observable<Car[]>{
    const headers = new HttpHeaders({Authorization:'Basic '+btoa(this.sharedDataService.username+":"+this.sharedDataService.password)});
    return this.httpClient.get<Car[]>(`${this.baseUrl}/all`,{headers});
   }

}
