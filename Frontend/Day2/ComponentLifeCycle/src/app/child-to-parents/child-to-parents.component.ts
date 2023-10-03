import { Component, OnInit, Input, Output, EventEmitter  } from '@angular/core';

@Component({
  selector: 'app-child-to-parents',
  templateUrl: './child-to-parents.component.html',
  styleUrls: ['./child-to-parents.component.css']
})
export class ChildToParentsComponent {
  @Input() count: number=0;
  @Output() countChanged: EventEmitter<number> =   new EventEmitter();
  increment() {
     this.count++;
     this.countChanged.emit(this.count);
   }
 decrement() {
     this.count--;
     this.countChanged.emit(this.count);
 }

  constructor() { }

  ngOnInit(): void {
  }
}
