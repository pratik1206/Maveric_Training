import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DatePipeComponent } from './date-pipe/date-pipe.component';
import { NumberPipeComponent } from './number-pipe/number-pipe.component';
import { SlicePipeComponent } from './slice-pipe/slice-pipe.component';
import { JsonPipeComponent } from './json-pipe/json-pipe.component';
import { CustompipePipe } from './custompipe.pipe';
import { HttpClientModule } from '@angular/common/http';
import { HttpExampleComponent } from './http-example/http-example.component';

@NgModule({
  declarations: [
    AppComponent,
    DatePipeComponent,
    NumberPipeComponent,
    SlicePipeComponent,
    JsonPipeComponent,
    CustompipePipe,
    HttpExampleComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
