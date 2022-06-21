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

  selectedIntrovertExtrovert: undefined;
  selectedMoreTime: undefined;
  selectedResersching: undefined;
  selectedActivness: undefined;
  selectedSport: undefined;
  selectedYears: -1;

  options = [
    { name: 'Lower than 1 year', value: 0 },
    { name: '1', value: 1 },
    { name: '5', value: 5 },
    { name: '12', value: 12 },
    { name: 'moreThen15', value: 15 },
  ];
  optionsActivness = [
    { name: 'Active', value: true },
    { name: 'Not so active', value: false },
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
  optionsMoreTime = [
    { name: 'Yess', value: true },
    { name: 'No', value: false },
  ];
  optionsType = [
    { name: 'Introvert', value: false },
    { name: 'Extrovert', value: true },
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
      this.selectedYears == -1
    ) {
      console.log('not good');
    } else {
      if (this.selectedYears == -1) {
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
