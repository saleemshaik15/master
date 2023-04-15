import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {CarService} from "../car.service";
import {Car} from "../model/car";

@Component({
  selector: 'app-get-cars',
  templateUrl: './get-cars.component.html',
  styleUrls: ['./get-cars.component.css']
})
export class GetCarsComponent implements OnInit {

  cars!: Car[];

  constructor(private router:Router, private carService:CarService) {}

  public getCars(){
    this.carService.getAllCars().subscribe(data => {
        console.log(data);
        this.cars = data;
        //this.showSuccess();
        //this.goToAllCars();
      },
      error => console.log(error));
  }

  ngOnInit(): void {
    this.getCars()
  }

  goToAddCarForm(): void {
    this.router.navigate(['/create-car']);
  }

}
