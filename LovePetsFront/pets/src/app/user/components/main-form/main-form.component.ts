import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-main-form',
  templateUrl: './main-form.component.html',
  styleUrls: ['./main-form.component.css'],
})
export class MainFormComponent implements OnInit {
  firstPartQuestions: FormGroup;

  activness: string;
  levelOfProtection: string;
  hoursPerWeek: string;
  price: string;
  placeForLiving: string;
  optionsPlace = [
    { name: 'Inside of house (or flat)', value: 'inside' },
    { name: 'In the garden', value: 'outside' },
    {
      name: ' In the garden or inside of house (flat)',
      value: 'insideOutside',
    },
  ];
  optionsActive = [
    { name: 'Active', value: 'active' },
    { name: 'not so active', value: 'notActive' },
  ];
  regex = '/^[0-5]+$/';

  constructor() {
    this.firstPartQuestions = new FormGroup({
      // activeness: new FormControl('', [
      //    Validators.required,
      //  ]),
      levelOfProtection: new FormControl('', [
        Validators.required,
        Validators.pattern('^[0-5]+$'),
      ]),
      hoursPerWeek: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      placeForLiving: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {}
  submit(): void {
    console.log('submit');
  }
}
