import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { PagenotFoundComponent } from './pagenot-found/pagenot-found.component';
import { AngularTutorialComponent } from './angular-tutorial/angular-tutorial.component';
import { PipeExampleComponent } from './pipe-example/pipe-example.component';
import { DirectiveExampleComponent } from './directive-example/directive-example.component';
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    PagenotFoundComponent,
    AngularTutorialComponent,
        PipeExampleComponent,
    DirectiveExampleComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
