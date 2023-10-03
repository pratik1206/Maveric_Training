import { Component, OnInit } from '@angular/core';

import { CartService } from 'src/app/service/cart.service';

import { Cart } from 'src/app/model/cart.model';

import { HttpErrorResponse } from '@angular/common/http';

import { Router } from '@angular/router';

import { OrderService } from 'src/app/service/order.service';

import { EcommerceserviceService } from 'src/app/service/user.service';

import { Order } from 'src/app/model/order.model';

import Swal from 'sweetalert2';

import { Subject } from 'rxjs';

 

@Component({

  selector: 'app-cart-list',

  templateUrl: './cart-list.component.html',

  styleUrls: ['./cart-list.component.css']

})

 

export class CartListComponent implements OnInit {

  userId: number;

  cartItemCount: number = 0;  

 

  constructor(public cartService: CartService,

    private router: Router,

    private orderService: OrderService,

    private userService: EcommerceserviceService) {

      localStorage.getItem('items')

      this.userId=0;

  }

 

  rowData: any;

  imageName:any;

  fetchImages:any[] =[];

 

  columnDefs = [

    { headerName: 'User Id', field: 'userId' },

    { headerName: 'Product Id', field: 'productId' },

    { headerName: 'Quantity', field: 'quantity' },

    { headerName: 'Price', field: 'price' },

    { headerName: 'Total Price', field: 'total_price' },

  ];

 

  ngOnInit(): void {

   

    this.userId= this.userService.storeUserId;

    this.loadCarts(this.userId);

     // Corrected: Use cartItemCount$ instead of cartService.subject$

     this.cartService.cartItemCount$.subscribe((count) => {

      this.cartItemCount = count;

    });

  }

 

  loadCarts(myUserId:any) {

    this.cartService.getCartByUserId(this.userId).subscribe((carts: any) => {

      this.rowData = carts;

      // if(this.rowData){
      //   console.log(this.rowData.length);
      //   this.cartService.cartSubject.next(this.rowData.length);
        
      // }
      
      console.log(this.userService.items);

      this.userService.items=this.rowData.length;

      if(this.rowData){

      for (const item of this.rowData) {

        this.cartService.getCategory(item.productId).subscribe((productdetails: any) => {

          const product = { productId: item.productId, productName: productdetails.name, categoryId: productdetails.categoryId };

          this.fetchImages.push(product);

          console.log(this.fetchImages);

 

        });

      }

      const currentCount = this.rowData.length; // Adjust this based on your cart data

      this.cartService.updateCartItemCount(currentCount);

      this.cartService.updateEstimatedTotalAmount(this.userId);

    }      

    });

  }

 

  getProductById(productId: string): string | undefined {

    const product = this.fetchImages.find(item => item.productId === productId);

    return product ? product.productName : undefined;

  }

 

  getImagebyProductId(productId: string)

  {

    const product = this.fetchImages.find(item=>item.productId ===productId)

    return product ? product.categoryId : undefined;

  }

 

  deleteRecord(cartIdToDelete: any) {

    this.cartService.deleteCartByCartId(cartIdToDelete).subscribe({

      next: (res)=>{

        if(res){          

          this.loadCarts(this.userId);

          alert('cart deleted successfully..')

        }

      },

      error: (error:HttpErrorResponse)=>{

        alert(error.message)

      }

    });

  }

 

  decreaseQuantity(cartItem: Cart) {

    if (cartItem.quantity > 1) {

      cartItem.quantity--;

      this.updateCart(cartItem);

    }

  }

 

  increaseQuantity(cartItem: Cart) {

    cartItem.quantity++;

    this.updateCart(cartItem);

  }

 

  updateCart(cartItem: Cart) {

    this.cartService.updateCart(cartItem).subscribe({

      next: (res)=>{

        if(res){          

          this.loadCarts(this.userId);

          alert('Quantity updated successfully..');

          this.cartService.updateEstimatedTotalAmount(this.userId);

        }

      },

      error: (error:HttpErrorResponse)=>{

        alert(error.message)

      }

    });

  }

 

  deleteCart(userIdToDelete: any) {

    this.cartService.deleteCartByUserId(userIdToDelete).subscribe({

      next: (res)=>{

        if(res){          

          this.loadCarts(userIdToDelete);

          //alert('cart deleted successfully..')

        }

      },

      error: (error:HttpErrorResponse)=>{

        alert(error.message)

      }

    });

  }

 

  placeOrder( totalAmount: number) {

    this.orderService.placeOrder(totalAmount,this.userId).subscribe({

      next: (response: Order) => {

        console.log(`order placed successfully`);

        console.log(response);

        Swal.fire('order placed successfully');

        this.cartService.updateEstimatedTotalAmount(this.userId);

        this.router.navigate(['/cart']);

        this.deleteCart(this.userId);

        this.cartService.cartSubject.next(0);

      },

      error: (error: any) => {

        console.error('Error adding to wishlist:', error);

      },

    });

  }

}