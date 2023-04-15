
import { Observable } from 'rxjs';
import { Usercred } from './usercred';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private baseUrl:string;
  private httpClient:HttpClient;

  constructor(httpClient:HttpClient) {
    this.baseUrl = "http://localhost:8282/user/login";
    this.httpClient = httpClient;
   }

  public login(usercred:Usercred):Observable<Object>{
    const headers = new HttpHeaders({Authorization:'Basic '+btoa(usercred.userName+":"+usercred.password)});
    return this.httpClient.get(this.baseUrl, {headers, responseType:'text' as 'json'});
  }

}
