import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SinglePerson } from '../../../shared/models/single-person';

@Component({
  selector: 'app-single-person-form',
  templateUrl: './single-person-form.component.html',
  styleUrls: ['./single-person-form.component.css'],
})
export class SinglePersonFormComponent implements OnInit {
  secondPartQuestions: FormGroup;

  @Output() filledForm = new EventEmitter<{ form: SinglePerson }>();

  levelOfStressOnJob: number;
  loveMeditation: number;
  levelOfPatience: number;
  levelOfPersistance: number;
  friendly: number;

  selectedRunning: string = '';
  selectedWalking: string = '';
  selectedType: string = '';
  selectedMystery: string = '';

  options = [
    { name: 'Yess', value: 'yess' },
    { name: 'No', value: 'no' },
  ];
  optionsType = [
    { name: 'Extrovert', value: 'extrovert' },
    { name: 'Introvert', value: 'introvert' },
  ];

  constructor() {}

  ngOnInit(): void {
    this.secondPartQuestions = new FormGroup({
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
    });
  }
  submit(): void {
    var newForm: SinglePerson = {
      activeness: this.selectedRunning === 'yess',
      extroversion: this.selectedType === 'Extrovert',
      friendly: this.friendly,
      introversion: this.selectedType === 'Introvert',
      levelOfPatience: this.levelOfPatience,
      levelOfPersistance: this.levelOfPersistance,
      levelOfStressOnJob: this.levelOfStressOnJob,
      loveMystery: this.selectedMystery === 'Yess',
      loveRunning: this.selectedRunning === 'Yess',
      loveWalking: this.selectedWalking === 'Yess',
      loveMeditation: this.loveMeditation,
    };
    console.log('submit');
    this.filledForm.emit({ form: newForm });
  }
}
