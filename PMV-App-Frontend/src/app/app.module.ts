import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { HeaderComponentComponent } from './header-component/header-component.component';
import { FooterComponentComponent } from './footer-component/footer-component.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { UserService } from './user.service';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import { GetCarsComponent } from './get-cars/get-cars.component';
import { GetDriverTicketComponent } from './get-driver-ticket/get-driver-ticket.component';
import { ServiceTicketReportComponent } from './service-ticket-report/service-ticket-report.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon'
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    CreateCarComponent,
    HeaderComponentComponent,
    FooterComponentComponent,
    LoginComponent,
    LogoutComponent,
    CreateTicketComponent,
    GetCarsComponent,
    GetDriverTicketComponent,
    ServiceTicketReportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
