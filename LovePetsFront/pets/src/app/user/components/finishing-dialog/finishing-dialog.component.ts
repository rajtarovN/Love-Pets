import { Component, Inject, Input, OnInit } from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialog,
  MatDialogConfig,
  MatDialogRef,
} from '@angular/material/dialog';
import { Pet } from '../../../shared/models/pet';

@Component({
  selector: 'app-finishing-dialog',
  templateUrl: './finishing-dialog.component.html',
  styleUrls: ['./finishing-dialog.component.css'],
})
export class FinishingDialogComponent implements OnInit {
  img: string = 'assets/images/dog.png';
  constructor(
    public dialogRef: MatDialogRef<FinishingDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { pet: Pet }
  ) {
    this.img = 'assets/images/' + data.pet.type + '.png';
  }
  ngOnInit(): void {
    this.img = 'assets/images/' + this.data.pet.type + '.png';
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
