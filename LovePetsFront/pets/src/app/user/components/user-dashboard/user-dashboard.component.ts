import { Component, OnInit } from '@angular/core';
import { MainForm } from '../../../shared/models/main-form';
import { SinglePerson } from '../../../shared/models/single-person';
import { Family } from '../../../shared/models/family';
import { FormServiceService } from '../../services/form-service/form-service.service';
import { FinishingDialogComponent } from '../../components/finishing-dialog/finishing-dialog.component';
import { MatDialog } from '@angular/material/dialog';

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
    this.formService
      .sendSinglepersonForm(this.singlePersonInfo)
      .subscribe((res) => {
        console.log(res);
      });
  }
  onFamillyFormInputed(eventData: { form: Family }) {
    console.log(eventData.form);
    this.famillyInfo = eventData.form;

    this.famillyInfo.activeness = this.mainInfo.activeness;
    this.famillyInfo.hoursPerWeek = this.mainInfo.hoursPerWeek;
    this.famillyInfo.placeForLiving = this.mainInfo.placeForLiving;
    this.famillyInfo.price = this.mainInfo.price;

    this.formService.sendFamilyForm(this.famillyInfo).subscribe((res) => {
      console.log(res);
      const dialogRef = this.dialog.open(FinishingDialogComponent, {
        panelClass: 'my-class',
        data: { pet: res },
      });
    });
  }
}
