import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-single-person-form',
  templateUrl: './single-person-form.component.html',
  styleUrls: ['./single-person-form.component.css']
})
export class SinglePersonFormComponent implements OnInit {

  secondPartQuestions: FormGroup;

  loveRunning: string;
  loveWalking: string;
  extroversion: string;
  introversion: string;
  levelOfStressOnJob: string;
  loveMystery: string;
  loveMeditation: string;
  levelOfPatience: string;
  levelOfPersistance: string;
  friendly: string;

  constructor() { }

  ngOnInit(): void {
    this.secondPartQuestions = new FormGroup({
      loveRunning: new FormControl('', [
         Validators.required,
       ]),
       loveWalking: new FormControl('', [
        Validators.required,
      ]),
      extroversion: new FormControl('', [
        Validators.required,
      ]),
      introversion: new FormControl('', [
        Validators.required,
      ]),
      loveMystery: new FormControl('', [
        Validators.required,
      ]),
      levelOfStressOnJob: new FormControl('', [
        Validators.required,
      ]),
      loveMeditation: new FormControl('', [
        Validators.required,
      ]),
      levelOfPatience: new FormControl('', [
        Validators.required,
      ]),
      levelOfPersistance: new FormControl('', [
        Validators.required,
      ]),
      friendly: new FormControl('', [
        Validators.required,
      ])
     });
  }
  submit(): void {
    console.log("submit")
  }


}
