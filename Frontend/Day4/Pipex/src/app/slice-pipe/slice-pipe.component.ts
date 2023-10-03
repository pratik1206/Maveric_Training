import { Component } from '@angular/core';

@Component({
  selector: 'app-slice-pipe',
  template: `
  <div>
  <p>{{str}}[0:4]: '{{str | slice:0:4}}' - output is expected to be 'abcd'</p>
  <p>{{str}}[4:0]: '{{str | slice:4:0}}' - output is expected to be ''</p>
  <p>{{str}}[-4]: '{{str | slice:-4}}' - output is expected to be 'ghij'</p>
  <p>{{str}}[-4:-2]: '{{str | slice:-4:-2}}' - output is expected to be 'gh'</p>
  <p>{{str}}[-100]: '{{str | slice:-100}}' - output is expected to be 'abcdefghij'</p>
  <p>{{str}}[100]: '{{str | slice:100}}' - output is expected to be ''</p>

  </div>
  `,
  styles: [
  ]
})
export class SlicePipeComponent {
  // str: string = 'abcdefghij';
 str = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
}
