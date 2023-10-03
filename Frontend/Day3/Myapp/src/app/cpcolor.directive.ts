import { Directive,Input,ElementRef } from '@angular/core';

@Directive({
  selector: '[appCPColor]'
})
export class CPColorDirective {

  
  @Input() cpColor: string="";
  constructor(private elRef: ElementRef) { 
  }
  // ngAfterViewInit(): void {
  //   this.elRef.nativeElement.style.color = this.cpColor;
  // }
  // @HostListener('input') onInput() {
  //   this.elRef.nativeElement.style.color = this.cpColor;
  // }
  applyColor() {
    this.elRef.nativeElement.style.color = this.cpColor;
  }
}
