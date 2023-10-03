import { Component } from '@angular/core';

@Component({
  selector: 'app-number-pipe',
  template: `
  <div>
    
  <!--output '2.718'-->
  <p>e (no formatting): {{e | number}}</p>

<!--output '002.71828'-->
<p>e (3.1-5): {{e | number:'3.1-5'}}</p>

<!--output '0,002.71828'-->
<p>e (4.5-5): {{e | number:'4.5-5'}}</p>

<!--output '0 002,71828'-->
<p>e (french): {{e | number:'4.5-5':'fr'}}</p>



<!--output '3.14'-->
<p>pi (no formatting): {{pi | number}}</p>

<!--output '003.14'-->
<p>pi (3.1-5): {{pi | number:'3.1-5'}}</p>

<!--output '003.14000'-->
<p>pi (3.5-5): {{pi | number:'3.5-5'}}</p>

<!--output '-3' / unlike '-2' by Math.round()-->
<p>-2.5 (1.0-0): {{-2.5 | number:'1.0-0'}}</p>
</div>
  `,
  styles: [
  ]
})
export class NumberPipeComponent {
  e=2.718;
  pi=3.14
}
