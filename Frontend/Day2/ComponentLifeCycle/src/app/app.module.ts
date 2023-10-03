import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ChildComponent } from './child/child.component';
import { ChildToParentsComponent } from './child-to-parents/child-to-parents.component';
import { ParentComponentComponent } from './parent-component/parent-component.component';

@NgModule({
  declarations: [
    AppComponent,
    ChildComponent,
    ChildToParentsComponent,
    ParentComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
