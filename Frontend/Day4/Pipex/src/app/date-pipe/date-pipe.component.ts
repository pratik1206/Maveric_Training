import { Component } from '@angular/core';

@Component({
  selector: 'app-date-pipe',
  template: `
  <div>
  <h4>{{title}}</h4>

  <div>
      <p >{{ dateVal | date: 'shortTime' }}</p> (1)
      <p>{{ dateVal | date: 'shortTime' }}</p>

      <p >{{ dateVal | date:'fullDate' }}</p>
      <p>{{ dateVal | date: 'fullDate' }}</p>

      <p ngNonBindable>{{ dateVal | date: 'd/M/y' }}</p>
      <p>{{ dateVal | date: 'd/M/y' }}</p>
  </div>
</div>
  `,
  styles: [
  ]
})
export class DatePipeComponent {
   title = "this is date";
   dateVal = Date();
}
