import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Family } from '../../../shared/models/family';
import { MainForm } from '../../../shared/models/main-form';
//tultip

@Component({
  selector: 'app-family-form',
  templateUrl: './family-form.component.html',
  styleUrls: ['./family-form.component.css'],
})
export class FamilyFormComponent implements OnInit {
  secondPartQuestions: FormGroup;

  @Output() filledForm = new EventEmitter<{ form: Family }>();

  selectedIntrovertExtrovert: '';
  selectedMoreTime: '';
  selectedResersching: '';
  selectedActivness: '';
  selectedSport: '';
  selectedYears: '';

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
  optionsMoreTime = [
    { name: 'Yess', value: 'yess' },
    { name: 'No', value: 'no' },
  ];
  optionsType = [
    { name: 'Introvert', value: 'introvert' },
    { name: 'Extrovert', value: 'ekstrovert' },
  ];

  @Input() mainForm: MainForm;

  constructor(private fb: FormBuilder, public router: Router) {
    this.secondPartQuestions = this.fb.group({});
  }

  ngOnInit(): void {}
  submit(): void {
    if (
      this.selectedIntrovertExtrovert === undefined ||
      this.selectedMoreTime === undefined ||
      this.selectedResersching === undefined ||
      this.selectedActivness === undefined ||
      this.selectedSport === undefined ||
      this.selectedYears === undefined
    ) {
      console.log('not good');
    } else {
      if (
        this.selectedIntrovertExtrovert === '' ||
        this.selectedMoreTime === '' ||
        this.selectedResersching === '' ||
        this.selectedActivness === '' ||
        this.selectedSport === '' ||
        this.selectedYears === ''
      ) {
        console.log('los unos');
      } else {
        var family: Family = {
          activeness: this.selectedActivness,
          childrenYears: this.selectedYears,
          goodInSport: this.selectedSport,
          moreTime: this.selectedMoreTime,
          physiclyActive: this.selectedActivness,
          loveReserching: this.selectedResersching,
          introvertEkstrovert: this.selectedIntrovertExtrovert,
        };
        console.log(family);
        this.filledForm.emit({ form: family });
      }
    }
  }
}
