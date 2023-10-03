import { Component } from '@angular/core';

@Component({
  selector: 'app-angular-tutorial',
  template: `
  <nav>
  <ul>
    <li>
      <a routerLink="pipe" routerLinkActive="active">Pipe</a>  &nbsp;&nbsp;&nbsp;
      <a routerLink="directive">Directive</a>  &nbsp;&nbsp;&nbsp;
      
   </li>
  </ul>
</nav>
<router-outlet></router-outlet>
  `,
  styles: [
  ]
})
export class AngularTutorialComponent {

}
