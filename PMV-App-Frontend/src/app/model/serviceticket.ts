import { Car } from './car';

export class ServiceTicket {
  serviceTicketId!: number;
  car!: Car;
  lastServiceMileage!: number;
  lastServiceDate!: string;
  serviceDescription!: string;
  serviceCost!: number;
  upcomingServiceDate!: string;
  engineerName!: string;
  isServiceDone!:boolean;

  constructor() {
  }
}
