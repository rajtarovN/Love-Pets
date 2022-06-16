import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
//tultip

@Component({
  selector: 'app-family-form',
  templateUrl: './family-form.component.html',
  styleUrls: ['./family-form.component.css']
})
export class FamilyFormComponent implements OnInit {
  secondPartQuestions: FormGroup;

  childrenYears: string;
  goodInSport: string;
  physiclyActive: string;
  loveReserching: string;
  moreTime: string;
  introvertEkstrovert: string;
  personalities: string;

  constructor() { 
    this.secondPartQuestions = new FormGroup({
      childrenYears: new FormControl('', [
         Validators.required,
       ]),
       goodInSport: new FormControl('', [
        Validators.required,
      ]),
      physiclyActive: new FormControl('', [
        Validators.required,
      ]),
      loveReserching: new FormControl('', [
        Validators.required,
      ]),
      moreTime: new FormControl('', [
        Validators.required,
      ]),
      introvertEkstrovert: new FormControl('', [
        Validators.required,
      ]),
      personalities: new FormControl('', [
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
