import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './root/app-routing.module';
import { AppComponent } from './root/app.component';
import { UserModule } from './user/user.module';
import { SharedModule } from './shared/shared.module';
import { NavBarComponent } from './shared/components/nav-bar/nav-bar.component';
//import { ViewPetComponent } from './shared/components/view-pet/view-pet.component';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    UserModule,
    SharedModule,
    AppRoutingModule,
  ],
  //exports: [ViewPetComponent],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
