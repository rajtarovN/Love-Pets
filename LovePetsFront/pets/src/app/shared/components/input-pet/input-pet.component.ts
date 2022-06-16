import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatIconModule, MatIconRegistry } from '@angular/material/icon';

@Component({
  selector: 'app-input-pet',
  templateUrl: './input-pet.component.html',
  styleUrls: ['./input-pet.component.css'],
})
export class InputPetComponent implements OnInit {
  secondPartQuestions: FormGroup;

  name: string;
  childrenYears: string;
  goodInSport: string;
  physiclyActive: string;
  loveReserching: string;
  moreTime: string;
  introvertEkstrovert: string;
  personalities: string;
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
  hoursPerWeek: string;
  price: string;
  placeForLiving: string;
  adoptableOnKids: string;
  levelOfActivity: string;
  degreeOfMolting: string;

  constructor() {}

  ngOnInit(): void {
    this.secondPartQuestions = new FormGroup({});
  }
  submit(): void {}
}
