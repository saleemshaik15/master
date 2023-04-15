import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { GetCarsComponent } from "./get-cars/get-cars.component";
import { CreateCarComponent } from './create-car/create-car.component';
import { CreateTicketComponent } from "./create-ticket/create-ticket.component";
import { GetDriverTicketComponent } from "./get-driver-ticket/get-driver-ticket.component";
import { ServiceTicketReportComponent } from "./service-ticket-report/service-ticket-report.component";

const routes: Routes = [
  {path: '', redirectTo:'login', pathMatch:'full'},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'create-car', component: CreateCarComponent },
  {path: 'cars', component: GetCarsComponent },
  {path: 'create-ticket', component: CreateTicketComponent },
  {path: 'get-driver-ticket', component: GetDriverTicketComponent },
  {path: 'get-service-tickets-report', component: ServiceTicketReportComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{scrollPositionRestoration: 'top'})],
  exports: [RouterModule]
})

export class AppRoutingModule { }
