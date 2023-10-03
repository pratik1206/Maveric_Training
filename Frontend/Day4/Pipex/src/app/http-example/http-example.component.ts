import { Component } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-http-example',
  template: `

    <p>
      http-example works!
    </p>
    <h2>User List</h2>
<table border=" 2px black">

  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Website</th>
      <th>Address</th>
      <th>Company</th>
    </tr>
  </thead>
  <tbody>
  <tr
  *ngFor="let user of users; let even = even"
  [ngStyle]="{ 'background-color': even ? '#CCC' : '' }"
>
      <td>{{ user.id }}</td>
      <td>{{ user.name }}</td>
      <td>{{ user.email }}</td>
      <td>{{ user.phone }}</td>
      <td>{{ user.website }}</td>
      <td>{{ user.address | json }}</td>
      <td>{{ user.company | json }}</td>
    </tr>
  </tbody>
</table>

  `,
  styles: [
    
  ]
})
export class HttpExampleComponent {

  users:any=[]
  constructor(private httpClient: HttpClient){}

  ngOnInit(){
    this.httpClient.get("https://jsonplaceholder.typicode.com/users").subscribe(
      data =>{
      console.log(data);
      this.users = data;
    })

    console.log(this.users)
  }
}
