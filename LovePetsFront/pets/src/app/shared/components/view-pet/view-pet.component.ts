import { Component, OnInit } from '@angular/core';
import { Pet } from '../../models/pet';

@Component({
  selector: 'app-view-pet',
  templateUrl: './view-pet.component.html',
  styleUrls: ['./view-pet.component.css'],
})
export class ViewPetComponent implements OnInit {
  pet: Pet;
  pets: Pet[];

  constructor() {
    this.pet = {
      id: 1,
      name: 'zlatni retriver',
      type: 'pas',
      hoursPerWeek: 12,
      price: 12,
      adoptableOnKids: 12,
      minYears: 21,
      levelOfActivity: 21,
      degreeOfMolting: 12,
      placeForLiving: 'House',
      levelOfProtection: 12,
      extroversion: true,
      introversion: false,
      levelOfStressOnJob: 12,
      loveMystery: true,
      loveMeditation: true,
      levelOfPatience: 2,
      levelOfPersistance: 2,
    };
    var pet2 = {
      id: 1,
      name: 'zlatni retriver',
      type: 'pas',
      hoursPerWeek: 12,
      price: 12,
      adoptableOnKids: 12,
      minYears: 21,
      levelOfActivity: 21,
      degreeOfMolting: 12,
      placeForLiving: 'House',
      levelOfProtection: 12,
      extroversion: true,
      introversion: false,
      levelOfStressOnJob: 12,
      loveMystery: true,
      loveMeditation: true,
      levelOfPatience: 2,
      levelOfPersistance: 2,
    };
    this.pets = [this.pet, pet2, pet2, this.pet];
  }

  ngOnInit(): void {}
}
