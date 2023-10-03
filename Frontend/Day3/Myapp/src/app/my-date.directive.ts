import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appMyDate]'
})
export class MyDateDirective {

  constructor(element: ElementRef,renderer: Renderer2) {
    var today=new Date().toDateString();
    console.log(today);

    console.log("Renderer"+renderer.selectRootElement)
    console.log("Element "+element.nativeElement)
    renderer.setProperty(element.nativeElement,'innerHTML',today);

   }
}
