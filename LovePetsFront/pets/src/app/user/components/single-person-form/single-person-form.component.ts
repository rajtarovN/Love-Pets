import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SinglePerson } from '../../../shared/models/single-person';
import { ChoosePetComponent } from '../choose-pet/choose-pet.component';
import { MatDialog } from '@angular/material/dialog';

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

  choosenPet: string = '';

  options = [
    { name: 'Yess', value: 'yess' },
    { name: 'No', value: 'no' },
  ];
  optionsType = [
    { name: 'Extrovert', value: 'extrovert' },
    { name: 'Introvert', value: 'introvert' },
  ];

  constructor(public dialog: MatDialog) {}

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
      afraidOf: [],
      alergic: [],
      liveWith: [],
      wantedPet: this.choosenPet,
    };
    console.log('submit');
    this.filledForm.emit({ form: newForm });
  }
  choosePet(): void {
    const dialogRef = this.dialog.open(ChoosePetComponent, {
      width: '250px',
      height: '300px',
      // background: 'white',
      autoFocus: false,
      data: { a: 'A' },
    });
    dialogRef.afterClosed().subscribe((result) => {
      if (result != null) {
        console.log(result);
        this.choosenPet = result;
        this.submit();
      }
    });
  }
}
