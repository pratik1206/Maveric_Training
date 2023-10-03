import { Component } from '@angular/core';

@Component({
  selector: 'app-json-pipe',
  template: `
    <p>
      json-pipe works!
    </p>
    <p>Without JSON pipe:</p>
<pre>{{object}}</pre>
<p>With JSON pipe:</p>
<pre>{{object | json}}</pre>
  `,
  styles: [
  ]
})
export class JsonPipeComponent {
  object: Object = {foo: 'bar', baz: 'qux', nested: {xyz: 3, numbers: [1, 2, 3, 4, 5]}};
}
