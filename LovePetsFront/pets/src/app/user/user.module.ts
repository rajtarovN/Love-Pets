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
//import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { ToastrModule } from 'ngx-toastr';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';

@NgModule({
  declarations: [
    MainFormComponent,
    SinglePersonFormComponent,
    FamilyFormComponent,
    UserDashboardComponent,
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild(UserRoutes),
    HttpClientModule,
    MaterialModule,
    ToastrModule.forRoot({
      timeOut: 3000,
      positionClass: 'toast-top-right',
      preventDuplicates: true,
    }),
  ],
})
export class UserModule {}
