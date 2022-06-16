import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MaterialModule } from '../root/material-module';



@NgModule({
  declarations: [
    NavBarComponent
  ],
  imports: [
    MaterialModule,
    CommonModule
  ]
})
export class SharedModule { }
