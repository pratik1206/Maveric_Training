import { Component,OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-component-a',
  template: `
  <div>
  <h1>component-a works!</h1>
  Enter your name <input type="text" [(ngModel)]="name"/>

  <button (click)="toggleMethods()">{{ isSet ? 'SET' : 'GET' }}</button>
</div>
  `,
  styles: [
  ]
})
export class ComponentAComponent  implements OnInit{
  name: string = '';

  isSet: boolean = false;

 

  constructor(private dataService: DataService) {}

 

  ngOnInit(): void {}

 

  toggleMethods() {

    if (this.isSet) {

      console.log('Setting Component A Name: ' + this.name);

      this.dataService.setName(this.name);

    } else {

      console.log('Getting Component A Name: ' + this.name);

      this.name = this.dataService.getName();

    }

 

    this.isSet = !this.isSet;

  }
}
