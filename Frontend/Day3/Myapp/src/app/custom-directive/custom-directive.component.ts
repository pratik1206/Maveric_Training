import { Component } from '@angular/core';
import { ChangeTextDirective } from '../change-text.directive';
@Component({
  selector: 'app-custom-directive',
  template: `

  <div>
  <input type="text" [(ngModel)]="titleColor" placeholder="Enter your favorite color">
  <button (click)="applyTextColor(titleColor)">Apply Color</button>
  <h4 appCPColor [cpColor]="titleColor">Text with Dynamic Color</h4>
</div> 

  <!-- Enter ur favorite Color<input type="text" [(ngModel)]="titleColor"/>{{titleColor}}-->
<div>
<h4 appCPColor [cpColor]="titleColor"> cpColor Directive Demo using Bracket []</h4>
<h4 appCPColor bind-cpColor="titleColor"> cpColor Directive Demo using bind- prefix  </h4>
<h4 appCPColor cpColor="{{titleColor}}"> cpColor Directive Demo using Interpolation</h4>
</div>

    <p>
      <span ChangeTextDirective>Welcome to {{title}}</span>
      
    </p>
    <div appChangeText ></div>

    <div appMyDate></div>
  `,
  styles: [
  ]
})
export class CustomDirectiveComponent {
  title = "Custome Directives"
  titleColor=""
  applyTextColor(newColor: string) {
    if (newColor.trim() !== "") {
      this.titleColor = newColor;
    }
  }
}
