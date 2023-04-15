import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class SharedDataService {

  public username!: string;
  public password!: string;
  public role!:string;
  public userId!: number

  constructor() { }
}
