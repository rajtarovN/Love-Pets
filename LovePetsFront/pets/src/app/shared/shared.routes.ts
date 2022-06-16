import { Routes } from "@angular/router";
import { NavBarComponent } from "./components/nav-bar/nav-bar.component";

export const SharedRoutes: Routes = [
  {
    path: 'nav-bar',
    pathMatch: 'full',
    component: NavBarComponent,
  },
  
];
