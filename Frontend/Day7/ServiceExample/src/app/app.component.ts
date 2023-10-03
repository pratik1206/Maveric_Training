import { Component } from '@angular/core';
import { TimeService } from './time.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'ServiceExample';
  currentTime;
  currentDate;
  constructor(private timeService:TimeService){
    this.currentDate = this.timeService.getTime().toLocaleDateString();
    this.currentTime = this.timeService.getTime().toLocaleTimeString();
  }
}
