import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from '../model/car';
import { Driver } from '../model/driver';
import { CarService } from '../car.service';
import { UserService } from '../user.service';
import { SharedDataService } from '../shared-data.service';

@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})

export class CreateCarComponent implements OnInit {

  car: Car = new Car();
  driver: Driver = new Driver();
  carService :CarService;
  userService:UserService;
  router:Router;

  constructor(carService:CarService, private sharedDataService: SharedDataService, router:Router, userService:UserService) {
    this.router = router;
    this.carService = carService;
    this.car.driver = this.driver;
    this.userService = userService;
   }

  ngOnInit(): void { }

  onSubmit() { this.addCar(); }

  addCar() {
    this.carService.createCar(this.car).subscribe(data => {
      console.log(data);
      alert("Car Created Successfully.")
      this.goToAllCars();
    },
    error => console.log(error));
  }

  goToAllCars() { this.router.navigate(['/cars']); }

}
