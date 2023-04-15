import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usercred } from '../usercred';
import { UserService } from '../user.service';
import { SharedDataService } from '../shared-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  userCred: Usercred = new Usercred();

  constructor(private router: Router, private userService: UserService, private sharedDataService: SharedDataService) { }
  
  ngOnInit(): void { }

  login() { this.authenticate(); }

  authenticate() {
    console.log(this.userCred.userName + "-" + this.userCred.password);
    this.userService.login(this.userCred).subscribe(data => {
      const dataArray = (data as string).split("-");
      const username = dataArray[0];
      const role = dataArray[1];
      const userId = Number(dataArray[2]);
      this.sharedDataService.username = username;
      this.sharedDataService.password = this.userCred.password;
      this.sharedDataService.role = role;
      this.sharedDataService.userId = userId;
      if (role == "ROLE_ADMIN") {
        this.router.navigate(['/create-car']);
      } else if (role == "ROLE_ENG") {
        this.router.navigate(['/create-ticket']);
      } else if (role == "ROLE_DRIVER") {
        this.router.navigate(['/get-driver-ticket']);
      } else if (role == "ROLE_MANAGER") {
        this.router.navigate(['/get-service-tickets-report']);
      }
    },
    error => console.log(error));
  }

}
