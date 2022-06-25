import { Component, Inject, Input, OnInit } from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialog,
  MatDialogConfig,
  MatDialogRef,
} from '@angular/material/dialog';
import { Pet } from '../../../shared/models/pet';
import { PetsServiceService } from '../../../shared/services/pets-service.service';

@Component({
  selector: 'app-choose-pet',
  templateUrl: './choose-pet.component.html',
  styleUrls: ['./choose-pet.component.css'],
})
export class ChoosePetComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<ChoosePetComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { a: string },
    private petService: PetsServiceService
  ) {}

  options = [{ name: 'Introvert', value: '0' }];
  selectedPet: 0;
  ngOnInit(): void {
    this.getAllPets();
  }

  getAllPets(): void {
    this.petService.getNames().subscribe((res) => {
      console.log(res);
      this.options = res;
    });
  }

  close(): void {
    this.dialogRef.close(null);
  }
  submit(): void {
    console.log('a', this.selectedPet);
    this.dialogRef.close(this.selectedPet);
  }
}
