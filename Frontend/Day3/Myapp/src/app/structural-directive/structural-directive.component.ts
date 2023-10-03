import { Component ,OnInit} from '@angular/core';
class Item{
  name:string="";
  value:string=""
}
@Component({
  selector: 'app-structural-directive',
  template:  `
    <div id="d1">
    
<h3>ng-template with ngIf</h3>
<button type="button" (click)="onToggle1()">Toggle</button>

<ng-template [ngIf]= "toggleFlag1" >
   <div>Hello World!</div>
</ng-template>

<h3>ng-template with ngIf-else</h3>

<button type="button" (click)="onToggle2()">Toggle</button>

<div *ngIf="toggleFlag2; else msgElseBlock" >
   <div>Hello World!</div>
</div>

<ng-template #msgElseBlock>
   <div>Else Block: Hello World! </div>
</ng-template>

<h3>ng-template with ngIf-then-else</h3>

<button type="button" (click)="onToggle3()">Toggle</button>

<div *ngIf="toggleFlag3; then thenBlock else elseBlock">

</div>
<ng-template #thenBlock>
    <div>Then Block: Hello World!</div>
</ng-template>
<ng-template #elseBlock>
    <div>Else Block: Hello World!</div>
</ng-template>

    </div>


    <div id="d2">

    <h3>ngTemplate with ngSwitch</h3>
    <select (change)="SetDropDownValue($event)">
  <option *ngFor="let item of items;" [value]="item.name">{{item.name}}</option>
</select>
<div [ngSwitch]='dropDownValue'>
    <h3 *ngSwitchCase="'One'">1 is selected</h3>
    <h3 *ngSwitchCase="'Two'">2 is selected</h3>
    <h3 *ngSwitchCase="'Three'">3 is selected</h3>
    <h3 *ngSwitchDefault="">You have not selected any Number</h3>
</div>


    </div>
    
    Enter the Country Side <input type="text" [(ngModel)]="newSide"/>
    <button (click)="addcountry()">New new country side</button>
    
    
    <div *ngFor=" let sides of countrysides;">
  
    <input type="radio" name="direction" (click)="myDir=sides"/>{{sides}}
    
    </div>

<!--    <input type="radio" name="direction" (click)="myDir='east'">East
 <input type="radio" name="direction" (click)="myDir='west'">West
<input type="radio" name="direction" (click)="myDir='north'">North
 <input type="radio" name="direction" (click)="myDir='south'">South   -->

<div [ngSwitch]='myDir'>
    <h3 *ngSwitchCase="'east'">East is selected</h3>
    <h3 *ngSwitchCase="'west'">West is selected</h3>
    <h3 *ngSwitchCase="'north'">North is selected</h3>
    <h3 *ngSwitchCase="'sounth'">Sounth is selected</h3>
    <h3 *ngSwitchDefault="">You have not selected any Number</h3>
</div>

   
  `,
  styles: [
  ]
})
export class StructuralDirectiveComponent implements OnInit  {
  newSide="";
  addcountry(){
    this.countrysides.push(this.newSide);
  }

  myDir = "";
  countrysides=["east","west","north","south"];

  items:Item[]=[{name:'One',value:'1'},{name:'Two',value:'2'},{name:'Three',value:'3'}]
  selectedValue:string=""
  dropDownValue = "";
  SetDropDownValue(drpValue : any) {
    this.dropDownValue = drpValue.target.value;
  }
  toggleFlag2=true
  toggleFlag3=true
  toggleFlag1=true

  constructor() { }

  ngOnInit(): void {


  }
 onToggle2(){
    alert("onToggle2 is called")
    this.toggleFlag2=!this.toggleFlag2
  }

  onToggle1(){
    alert("onToggle1 is called")
    this.toggleFlag1=!this.toggleFlag1
  }

  onToggle3(){
   alert("onToggle3 is called")
   this.toggleFlag3=!this.toggleFlag3
  }
}
