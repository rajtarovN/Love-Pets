import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainFormComponent } from './components/main-form/main-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from '../root/material-module';
import { UserRoutes } from './user.routes';
import { SinglePersonFormComponent } from './components/single-person-form/single-person-form.component';
import { FamilyFormComponent } from './components/family-form/family-form.component';



@NgModule({
  declarations: [
    MainFormComponent,
    SinglePersonFormComponent,
    FamilyFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild(UserRoutes),
    HttpClientModule,
    MaterialModule
  ]
})
export class UserModule { }
