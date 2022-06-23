import { Component, OnInit } from '@angular/core';
import { MainForm } from '../../../shared/models/main-form';
import { SinglePerson } from '../../../shared/models/single-person';
import { Family } from '../../../shared/models/family';
import { FormServiceService } from '../../services/form-service/form-service.service';
import { FinishingDialogComponent } from '../../components/finishing-dialog/finishing-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { Pet } from '../../../shared/models/pet';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
})
export class UserDashboardComponent implements OnInit {
  state: number = 1;
  mainInfo: MainForm;
  famillyInfo: Family;
  singlePersonInfo: SinglePerson;
  constructor(
    private formService: FormServiceService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {}

  onFormInputed(eventData: { form: MainForm }) {
    console.log(eventData.form);
    this.mainInfo = eventData.form;
    if (eventData.form.type === 'Single person') {
      this.state = 2;
    } else if (eventData.form.type === 'Familly') {
      this.state = 3;
    }
  }

  onSingleFormInputed(eventData: { form: SinglePerson }) {
    console.log(eventData.form);
    this.singlePersonInfo = eventData.form;
    //todo slanje
    this.singlePersonInfo.activeness = this.mainInfo.activeness;
    this.singlePersonInfo.hoursPerWeek = this.mainInfo.hoursPerWeek;
    this.singlePersonInfo.placeForLiving = this.mainInfo.placeForLiving;
    this.singlePersonInfo.price = this.mainInfo.price;
    this.singlePersonInfo.afraidOf = this.mainInfo.afraidOf;
    this.singlePersonInfo.alergic = this.mainInfo.alergic;
    this.singlePersonInfo.liveWith = this.mainInfo.liveWith;
    if (this.singlePersonInfo.wantedPet === '') {
      this.formService
        .sendSinglepersonForm(this.singlePersonInfo)
        .subscribe((res) => {
          console.log(res);
        });
    } else {
      this.formService
        .backwardSinglePerson(this.singlePersonInfo)
        .subscribe((res) => {
          console.log(res);
        });
    }
  }
  onFamillyFormInputed(eventData: { form: Family }) {
    console.log(eventData.form);
    this.famillyInfo = eventData.form;

    this.famillyInfo.activeness = this.mainInfo.activeness;
    this.famillyInfo.hoursPerWeek = this.mainInfo.hoursPerWeek;
    this.famillyInfo.placeForLiving = this.mainInfo.placeForLiving;
    this.famillyInfo.price = this.mainInfo.price;
    this.famillyInfo.afraidOf = this.mainInfo.afraidOf;
    this.famillyInfo.alergic = this.mainInfo.alergic;
    this.famillyInfo.liveWith = this.mainInfo.liveWith;

    if (this.famillyInfo.wantedPet === '') {
      this.formService.sendFamilyForm(this.famillyInfo).subscribe((res) => {
        console.log(res);
        if (res != null) {
          const dialogRef = this.dialog.open(FinishingDialogComponent, {
            panelClass: 'my-class',
            data: { pet: res },
          });
        } else {
          let pet1: Pet = {
            name: 'There is no pet for you at this moment. :(',
            type: '',
            hoursPerWeek: 0,
            price: 0,
            adoptableOnKids: 0,
            minYears: 0,
            levelOfActivity: 0,
            degreeOfMolting: 0,
            placeForLiving: '',
            levelOfProtection: 0,
            extroversion: true,
            introversion: true,
            levelOfStressOnJob: 0,
            loveMystery: true,
            loveMeditation: 0,
            levelOfPatience: 0,
            levelOfPersistance: 0,
            notLiveWith: [],
          };
          const dialogRef = this.dialog.open(FinishingDialogComponent, {
            panelClass: 'my-class',
            data: { pet: pet1 },
          });
        }
      });
    } else {
      this.formService.backwardFamily(this.famillyInfo).subscribe((res) => {
        console.log(res);
        if (res != null) {
          const dialogRef = this.dialog.open(FinishingDialogComponent, {
            panelClass: 'my-class',
            data: { pet: res },
          });
        } else {
          let pet1: Pet = {
            name: 'There is no pet for you at this moment. :(',
            type: '',
            hoursPerWeek: 0,
            price: 0,
            adoptableOnKids: 0,
            minYears: 0,
            levelOfActivity: 0,
            degreeOfMolting: 0,
            placeForLiving: '',
            levelOfProtection: 0,
            extroversion: true,
            introversion: true,
            levelOfStressOnJob: 0,
            loveMystery: true,
            loveMeditation: 0,
            levelOfPatience: 0,
            levelOfPersistance: 0,
            notLiveWith: [],
          };
          const dialogRef = this.dialog.open(FinishingDialogComponent, {
            panelClass: 'my-class',
            data: { pet: pet1 },
          });
        }
      });
    }
  }
}
