import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MainForm } from '../../../shared/models/main-form';

@Component({
  selector: 'app-main-form',
  templateUrl: './main-form.component.html',
  styleUrls: ['./main-form.component.css'],
})
export class MainFormComponent implements OnInit {
  firstPartQuestions: FormGroup;

  @Output() filledForm = new EventEmitter<{ form: MainForm }>();

  activness: string = '';
  levelOfProtection: number;
  hoursPerWeek: number;
  price: number;
  placeForLiving: string = '';
  selectedSF: string = '';
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

  optionsSF = [
    { name: 'Single person', value: 'single' },
    { name: 'Familly', value: 'familly' },
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
    });
  }

  ngOnInit(): void {}
  submit(): void {
    console.log('submit');

    var newForm: MainForm = {
      activeness: this.activness === 'Active',
      hoursPerWeek: this.hoursPerWeek,
      levelOfProtection: this.levelOfProtection,
      placeForLiving: this.placeForLiving,
      price: this.price,
      type: this.selectedSF,
    };
    this.filledForm.emit({ form: newForm });
  }
}
