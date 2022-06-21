import { Component, OnInit } from '@angular/core';
import { Pet } from '../../models/pet';
import { PetsServiceService } from '../../services/pets-service.service';

@Component({
  selector: 'app-view-pet',
  templateUrl: './view-pet.component.html',
  styleUrls: ['./view-pet.component.css'],
})
export class ViewPetComponent implements OnInit {
  pet: Pet;
  pets: Pet[];
  options = [
    { name: 'Lower than 1 year', value: 'lowerThanOne' },
    { name: '1', value: 'one' },
    { name: '5', value: 'five' },
    { name: '12', value: 'twelve' },
    { name: 'moreThen15', value: 'More then 15 years' },
  ];
  optionsActivness = [
    { name: 'Active', value: 'active' },
    { name: 'Not so active', value: 'notActive' },
  ];
  optionsSport = [
    { name: 'Good (Love runing for example or play something)', value: 'good' },
    {
      name: 'Not so good (Not relly active or not intrested in sport)',
      value: 'bad',
    },
  ];
  optionsRes = [
    {
      name: 'Love reserching (Love to explore new places, animals, science)',
      value: 'love',
    },
    { name: 'Not really intrested in reserching', value: 'dontLove' },
  ];

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
  optionsYN = [
    { name: 'Yess', value: 'yess' },
    { name: 'No', value: 'no' },
  ];
  optionsType = [
    { name: 'Extrovert', value: 'extrovert' },
    { name: 'Introvert', value: 'introvert' },
  ];

  constructor(private petService: PetsServiceService) {
    this.petService.getPets().subscribe((res) => {
      console.log(res);
      this.pets = res;
    });
  }

  ngOnInit(): void {}
}
