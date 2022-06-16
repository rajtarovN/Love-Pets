import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-main-form',
  templateUrl: './main-form.component.html',
  styleUrls: ['./main-form.component.css']
})
export class MainFormComponent implements OnInit {

  firstPartQuestions: FormGroup;

  activeness: string;
  levelOfProtection: string;
  hoursPerWeek: string;
  price: string;
  placeForLiving: string;
  regex = '/^[0-5]+$/';

  constructor() {
     this.firstPartQuestions = new FormGroup({
      // activeness: new FormControl('', [
      //    Validators.required,
      //  ]),
       levelOfProtection: new FormControl('', [
        Validators.required,
        Validators.pattern(
          '^[0-5]+$'
        ),
      ]),
      hoursPerWeek: new FormControl('', [
        Validators.required,
      ]),
      price: new FormControl('', [
        Validators.required,
      ]),
      placeForLiving: new FormControl('', [
        Validators.required,
      ])
     });
   }

  ngOnInit(): void {
  }
  submit(): void {
    console.log("submit")
  }

}
