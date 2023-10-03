import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {EcommerceserviceService} from '../service/user.service';
import { CartService } from '../service/cart.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  {
  items:any =0;

  cartItemCount: number = 0;

  categories: { id: string, name: string }[] = [
    // { id: '0', name: "All" },
    { id: '151839', name: "Robots" }, 
    { id: '216292', name: "Controllers" },
    { id: 'SIC-1108226', name: "Software" }, 
    { id: '50098132', name: "Components" }, 
    { id: 'P06-02-0005-01', name: "Services" }, 
  ];

 constructor(private router: Router,

    private cartService: CartService, public userService : EcommerceserviceService) {

    // console.log(localStorage.getItem('items'));

   
  }
  ngOnInit(): void {

    if(localStorage.getItem('userId')){
      this.cartService.getCartByUserId(localStorage.getItem('userId')).subscribe((cartItems) => {

        this.items = cartItems.length;
  
      });

    }
  

    // Subscribe to cart item count changes
   

    this.cartService.cartSubject.subscribe(cartCount =>{

      this.items=cartCount;

    });


    this.cartService.cartItemCount$.subscribe((count) => {

      this.cartItemCount = count;

    });

  }
  logout(){

    localStorage.removeItem('items')

  }

  isLoginPageOrRegisterPage(): boolean {
    return this.router.url.includes('/login') || this.router.url.includes('/register');
  }
 
  getUsername() {
    return this.userService.username;
  }

  selectCategory(categoryId: string) {
    this.router.navigate(['/plp/c', categoryId]); // Pass categoryId directly, no need for object
  }
  searchQuery:any

  onSearch() {
    if (this.searchQuery) {
      // Navigate to PLP page with the search query as a route parameter
      console.log(this.searchQuery);
      this.router.navigate(['/plp/n/search', this.searchQuery]);
    }
}

 }
