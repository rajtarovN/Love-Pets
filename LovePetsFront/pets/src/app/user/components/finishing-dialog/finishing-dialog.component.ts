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
  constructor(
    public dialogRef: MatDialogRef<FinishingDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { pet: Pet }
  ) {}
  ngOnInit(): void {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
