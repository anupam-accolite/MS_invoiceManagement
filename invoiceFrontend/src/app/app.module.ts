import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

//Materials
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';


import { UtilisationComponent } from './components/utilisation/utilisation.component';
import { ProjectionComponent } from './components/projection/projection.component';
import { InvoicesComponent } from './components/invoices/invoices.component';
import { TfrComponent } from './components/tfr/tfr.component';
import { IncompleteTimesheetsComponent } from './components/incomplete-timesheets/incomplete-timesheets.component';
import { ExperienceComponent } from './components/experience/experience.component';
import { DiscrepanciesComponent } from './components/discrepancies/discrepancies.component';

import {LoginService} from './services/login.service';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
{path:'login',component:LoginComponent},
{path:'home',component:HomeComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    HomeComponent,
    UtilisationComponent,
    ProjectionComponent,
    InvoicesComponent,
    TfrComponent,
    IncompleteTimesheetsComponent,
    ExperienceComponent,
    DiscrepanciesComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes,{useHash:true}),
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
     ReactiveFormsModule,
     HttpClientModule, 
     
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
