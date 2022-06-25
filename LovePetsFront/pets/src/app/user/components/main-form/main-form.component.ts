import { LocationStrategy } from '@angular/common';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MainForm } from '../../../shared/models/main-form';
import { ElementForList } from '../../../shared/models/ElementForList';

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

  list: ElementForList[] = [];
  listAlergic: ElementForList[] = [];
  listLiveWith: ElementForList[] = [];

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

  ngOnInit(): void {
    this.list = [
      {
        id: 11,
        type: 'dog',
        checked: false,
        img: 'assets/images/dog.png',
      },
      {
        id: 12,
        type: 'bird',
        checked: false,
        img: 'assets/images/bird.png',
      },
      {
        id: 13,
        type: 'cat',
        checked: false,
        img: 'assets/images/cat.png',
      },
      {
        id: 14,
        type: 'snake',
        checked: false,
        img: 'assets/images/snake.png',
      },
      {
        id: 15,
        type: 'bummy',
        checked: false,
        img: 'assets/images/bunny.png',
      },
      {
        id: 16,
        type: 'mouse',
        checked: false,
        img: 'assets/images/mouse.png',
      },
    ];
    this.listAlergic = [
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
    this.listLiveWith = [
      {
        id: 5,
        type: 'dog',
        checked: false,
        img: 'assets/images/dog.png',
      },
      {
        id: 6,
        type: 'bird',
        checked: false,
        img: 'assets/images/bird.png',
      },
      {
        id: 7,
        type: 'cat',
        checked: false,
        img: 'assets/images/cat.png',
      },
      {
        id: 8,
        type: 'snake',
        checked: false,
        img: 'assets/images/snake.png',
      },
      {
        id: 9,
        type: 'bummy',
        checked: false,
        img: 'assets/images/bunny.png',
      },
      {
        id: 10,
        type: 'mouse',
        checked: false,
        img: 'assets/images/mouse.png',
      },
    ];
  }
  submit(): void {
    console.log('submit');
    let afraidOfL = this.filterList(this.list.filter((item) => item.checked));
    let liveWithL = this.filterList(
      this.listLiveWith.filter((item) => item.checked)
    );
    let alergicL = this.filterList(
      this.listAlergic.filter((item) => item.checked)
    );

    var newForm: MainForm = {
      activeness: this.activness === 'Active',
      hoursPerWeek: this.hoursPerWeek,
      levelOfProtection: this.levelOfProtection,
      placeForLiving: this.placeForLiving,
      price: this.price,
      type: this.selectedSF,
      liveWith: liveWithL,
      afraidOf: afraidOfL,
      alergic: alergicL,
    };

    this.filledForm.emit({ form: newForm });
  }

  filterList(newList: ElementForList[]): any {
    let lista: String[] = [];
    for (let i = 0; i < newList.length; i++) {
      lista.push(newList[i].type);
    }
    return lista;
  }

  get result() {
    return this.list.filter((item) => item.checked);
  }

  changeCheckbox(event: Event) {
    console.log(event.target);
  }
}
