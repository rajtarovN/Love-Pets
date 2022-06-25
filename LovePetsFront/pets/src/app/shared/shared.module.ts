import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MaterialModule } from '../root/material-module';
import { ViewPetComponent } from './components/view-pet/view-pet.component';
import { RouterModule } from '@angular/router';
import { SharedRoutes } from './shared.routes';
import { PetCardComponent } from './components/pet-card/pet-card.component';
import { MatCardModule } from '@angular/material/card';
import { InputPetComponent } from './components/input-pet/input-pet.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './components/registration/registration.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    NavBarComponent,
    ViewPetComponent,
    PetCardComponent,
    InputPetComponent,
    RegistrationComponent,
    LoginComponent,
  ],
  imports: [
    MaterialModule,
    CommonModule,
    RouterModule.forChild(SharedRoutes),
    MatCardModule,
    ReactiveFormsModule,
    HttpClientModule,
    MaterialModule,
  ],
  exports: [ViewPetComponent],
})
export class SharedModule {}
