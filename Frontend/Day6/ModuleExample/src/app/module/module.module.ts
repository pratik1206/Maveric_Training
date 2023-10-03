import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from '../home/home.component';
import { ContactComponent } from '../contact/contact.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path : 'home',
    component : HomeComponent
  },
  {
    path : 'contact',
    component : ContactComponent
  }
  
];
@NgModule({
  declarations: [
    HomeComponent,
    ContactComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    HomeComponent ,
    ContactComponent,
    RouterModule
  ]

  

})
export class ModuleModule {

 }
