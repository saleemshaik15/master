import { Driver } from './driver';
import { ServiceTicket } from './serviceticket';

export class Car {
  plateNo!: string;
  carModel!: string;
  manufacturingYear!: number;
  upcomingServiceDate!: string;
  driver!: Driver;
  serviceTickets!: ServiceTicket[];
  isServiceDone!: boolean;

  constructor(){
    
  }


  // constructor(
  //   plateNo: string,
  //   carModel: string,
  //   manufacturingYear: number,
  //   upcomingServiceDate: string,
  //   driver: Driver,
  //   serviceTickets: ServiceTicket[],
  //   isServiceDone: boolean
  // ) {
  //   this.plateNo = plateNo;
  //   this.carModel = carModel;
  //   this.manufacturingYear = manufacturingYear;
  //   this.upcomingServiceDate = upcomingServiceDate;
  //   this.driver = driver;
  //   this.serviceTickets = serviceTickets;
  //   this.isServiceDone = isServiceDone;
  // }
}
