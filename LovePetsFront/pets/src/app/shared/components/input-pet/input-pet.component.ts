import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatIconModule, MatIconRegistry } from '@angular/material/icon';
import { Pet } from '../../models/pet';
import { PetsServiceService } from '../../services/pets-service.service';
import { ElementForList } from '../../models/ElementForList';

@Component({
  selector: 'app-input-pet',
  templateUrl: './input-pet.component.html',
  styleUrls: ['./input-pet.component.css'],
})
export class InputPetComponent implements OnInit {
  secondPartQuestions: FormGroup;

  name: string;
  physiclyActive: string;
  introvertEkstrovert: string;
  personalities: string;
  extroversion: string;
  introversion: string;
  levelOfStressOnJob: number;

  levelOfPatience: number;
  levelOfPersistance: number;
  friendly: number;
  hoursPerWeek: number;
  price: number;
  adoptableOnKids: number;
  levelOfActivity: number;
  degreeOfMolting: number;
  levelOfProtection: number;

  selectedRunning: string = '';
  loveMeditation: number = 0;
  selectedWalking: string = '';
  selectedType: string = '';
  selectedMystery: boolean = true;
  selectedIntrovertExtrovert: boolean = true;
  selectedMoreTime: '';
  selectedResersching: '';
  selectedActivness: '';
  selectedSport: '';
  selectedYears: number = -1;
  placeForLiving: string = '';

  listLiveWith: ElementForList[] = [];

  optionsPlace = [
    { name: 'Inside of house (or flat)', value: 'inside' },
    { name: 'In the garden', value: 'outside' },
    {
      name: ' In the garden or inside of house (flat)',
      value: 'insideOutside',
    },
  ];

  optionsYN = [
    { name: 'Yess', value: true },
    { name: 'No', value: false },
  ];

  options = [
    { name: 'Lower than 1 year', value: 0 },
    { name: '1', value: 1 },
    { name: '5', value: 5 },
    { name: '12', value: 12 },
    { name: 'moreThen15', value: 16 },
  ];
  optionsActivness = [
    { name: 'Active', value: 'active' },
    { name: 'Not so active', value: 'notActive' },
  ];
  optionsSport = [
    { name: 'Good (Love runing for example or play something)', value: true },
    {
      name: 'Not so good (Not relly active or not intrested in sport)',
      value: false,
    },
  ];
  optionsRes = [
    {
      name: 'Love reserching (Love to explore new places, animals, science)',
      value: true,
    },
    { name: 'Not really intrested in reserching', value: false },
  ];

  optionsType = [
    { name: 'Introvert', value: false },
    { name: 'Extrovert', value: true },
  ];
  selectedSF: string = '';

  optionsActive = [
    { name: 'Active', value: true },
    { name: 'not so active', value: false },
  ];

  constructor(private petService: PetsServiceService) {}

  ngOnInit(): void {
    this.secondPartQuestions = new FormGroup({
      levelOfProtection: new FormControl(),
      hoursPerWeek: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      loveRunning: new FormControl('', [Validators.required]),
      loveWalking: new FormControl('', [Validators.required]),
      extroversion: new FormControl('', [Validators.required]),
      introversion: new FormControl('', [Validators.required]),
      loveMystery: new FormControl('', [Validators.required]),
      levelOfStressOnJob: new FormControl('', [Validators.required]),
      loveMeditation: new FormControl('', [Validators.required]),
      levelOfPatience: new FormControl('', [Validators.required]),
      levelOfPersistance: new FormControl('', [Validators.required]),
      friendly: new FormControl('', [Validators.required]),
      adoptableOnKids: new FormControl('', [Validators.required]),
      levelOfActivity: new FormControl('', [Validators.required]),
      degreeOfMolting: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
    });
    this.listLiveWith = [
      {
        id: 1,
        type: 'dog',
        checked: false,
        img: 'assets/images/dog.png',
      },
      {
        id: 2,
        type: 'bird',
        checked: false,
        img: 'assets/images/bird.png',
      },
      {
        id: 3,
        type: 'cat',
        checked: false,
        img: 'assets/images/cat.png',
      },
      {
        id: 4,
        type: 'snake',
        checked: false,
        img: 'assets/images/snake.png',
      },
      {
        id: 5,
        type: 'bummy',
        checked: false,
        img: 'assets/images/bunny.png',
      },
      {
        id: 4,
        type: 'mouse',
        checked: false,
        img: 'assets/images/mouse.png',
      },
    ];
  }
  submit(): void {
    if (localStorage.getItem('username') !== 'admin') {
      alert('You are not admin, so you cant add pet');
    } else {
      let listChoosenPets = this.listLiveWith.filter((item) => item.type);

      var pet: Pet = {
        name: this.name,
        type: this.selectedType,
        hoursPerWeek: this.hoursPerWeek,
        price: this.price,
        adoptableOnKids: this.adoptableOnKids,
        minYears: this.selectedYears,
        levelOfActivity: this.levelOfActivity,
        degreeOfMolting: this.degreeOfMolting,
        placeForLiving: this.placeForLiving,
        levelOfProtection: this.levelOfProtection,
        extroversion: this.selectedIntrovertExtrovert,
        introversion: !this.selectedIntrovertExtrovert,
        levelOfStressOnJob: this.levelOfActivity,
        loveMystery: this.selectedMystery,
        loveMeditation: this.loveMeditation,
        levelOfPatience: this.levelOfPatience,
        levelOfPersistance: this.levelOfPersistance,
        notLiveWith: this.filterList(listChoosenPets),
      };
      this.petService.addPet(pet).subscribe((res) => {
        console.log(res);
        if (res === null) {
          alert('Something went wrong');
        } else if (res.name == null) {
          alert('Something went wrong');
        } else {
          alert('Successfuly added pet');
        }
      });
    }
  }

  get result() {
    return this.listLiveWith.filter((item) => item.checked);
  }

  changeCheckbox(event: Event) {
    console.log(event.target);
  }
  filterList(newList: ElementForList[]): string[] {
    let lista: string[] = [];
    for (let i = 0; i < newList.length; i++) {
      lista.push(newList[i].type);
    }
    return lista;
  }
}
