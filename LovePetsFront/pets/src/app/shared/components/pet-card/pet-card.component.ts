import { Component, Input, OnInit } from '@angular/core';
import { Pet } from '../../models/pet';
import { PetsServiceService } from '../../services/pets-service.service';

@Component({
  selector: 'app-pet-card',
  templateUrl: './pet-card.component.html',
  styleUrls: ['./pet-card.component.css'],
})
export class PetCardComponent implements OnInit {
  @Input() pet: Pet;

  constructor(private petService: PetsServiceService) {}

  ngOnInit(): void {}

  delete(): void {
    this.petService.deletePet(this.pet.id + '').subscribe((res) => {
      console.log(res);
    });
  }
}
