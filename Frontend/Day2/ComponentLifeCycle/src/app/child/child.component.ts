// import { Component, OnInit, Input, SimpleChanges} from '@angular/core';

// @Component({
//   selector: 'app-child',
//   // templateUrl: './child.component.html',
//   template:`
//     THis is messaage from child{{message}} 
//   `,
//   styleUrls: ['./child.component.css']
// })
// export class ChildComponent {

  
//   @Input() message: string;
//   temp:string = "";
//   constructor() {
//     console.log("ChildComponent Constructor")
//   }

//   ngOnChanges(changes: SimpleChanges) {
//     console.log("ngOnChanges")
//      for (let propName in changes) {
//       let chng = changes[propName];
//        let cur  = JSON.stringify(chng.currentValue);
//        let prev = JSON.stringify(chng.previousValue);
//        console.log(`propName: currentValue = cur, previousValue = prev`);
//      }
//   }

//   ngAfterViewInit(){
//     console.log("ngAfterViewInit() is called");
//   }

//   ngOnInit() {
//     console.log("ngOnInit")
//     this.temp=this.message;
//     console.log(this.message)
//     console.log(this.temp)
//   }

//   ngOnDestroy(){
//     alert("ngOnDestroy() is called  ")
//   }

//     // @Input("mycount") count : number = 0;

    

//     // ngOnChanges(args: any[]) {
//     //   console.log("onChange called")
//     //     console.log("Changing", args)
//     //   }

//       // ngOnChanges(changes: SimpleChanges) {
//       //   console.log("ngOnChanges")
//       //   console.log(changes)
//       //    for (let propName in changes) {
//       //     let chng = changes[propName];
//       //      let cur  = JSON.stringify(chng.currentValue);
//       //      let prev = JSON.stringify(chng.previousValue);
           
//       //      console.log('propName: currentValue ='+cur+", previousValue = prev"+prev);
//       //    }
//       // }
// }
