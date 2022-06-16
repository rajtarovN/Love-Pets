import { Routes } from '@angular/router';
import { ViewPetComponent } from './components/view-pet/view-pet.component';
import { InputPetComponent } from './components/input-pet/input-pet.component';
import { RegistrationComponent } from './components/registration/registration.component';

export const SharedRoutes: Routes = [
  {
    path: 'pet-view',
    pathMatch: 'full',
    component: ViewPetComponent,
  },
  {
    path: 'input',
    pathMatch: 'full',
    component: InputPetComponent,
  },
  {
    path: 'registration',
    pathMatch: 'full',
    component: RegistrationComponent,
  },
];
