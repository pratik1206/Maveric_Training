import { Component,OnInit } from '@angular/core';
import { Product } from '../Product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  template: `
  <h1>Product List</h1>
  <div class='table-responsive'>
      <table class='table'>
          <thead>
              <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Price</th>
              </tr>
          </thead>
          <tbody>
              <tr *ngFor="let product of products;">
                  <td>{{product.productID}}</td>
                  <td><a [routerLink]="['detail',product.productID]">{{product.name}} </a> </td>
                  <td>{{product.price}}</td>
              </tr>
          </tbody>
      </table>
  </div>
   
  <router-outlet></router-outlet>
  `,
  styles: [
  ]
})
export class ProductComponent {
  products:Product[]=[];


  constructor(private productService:ProductService){
   }


ngOnInit(): void {
  this.products=this.productService.getProducts();
}
}
