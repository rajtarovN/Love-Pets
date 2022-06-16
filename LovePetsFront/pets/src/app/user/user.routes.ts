import { Routes } from "@angular/router";
import { MainFormComponent } from "./components/main-form/main-form.component";
import { SinglePersonFormComponent } from "./components/single-person-form/single-person-form.component";
import { FamilyFormComponent } from "./components/family-form/family-form.component";

export const UserRoutes: Routes = [
  {
    path: 'main-form',
    pathMatch: 'full',
    component: MainFormComponent,
  },
  {
    path: 'single-person-form',
    pathMatch: 'full',
    component: SinglePersonFormComponent,
  },
  {
    path: 'family-form',
    pathMatch: 'full',
    component: FamilyFormComponent,
  },
  
];
