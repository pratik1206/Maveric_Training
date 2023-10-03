import { HttpClient, HttpHeaders } from "@angular/common/http";

import { Injectable } from "@angular/core";

import { Observable, Subject, throwError } from "rxjs";

import { catchError } from "rxjs/operators";

import { Cart } from "../model/cart.model";

import { Product } from "../model/model";

 

@Injectable({ providedIn: 'root' })

export class CartService {

  userId: number;

  estimatedTotalAmount: number = 0;

  private totalQuantity: number = 0;

  cartSubject = new Subject();

  private cart: {product: Product; quantity: number;}[] = [];

  constructor(private http: HttpClient) {

    this.userId=0;

  }

  baseUrl = 'http://localhost:8083/cartservice';

  private fetchCategory: string = 'http://localhost:8083/product/p';

 

  // private userCartCounts: Map<string, number> = new Map<string, number>();

  private cartItemCountSubject = new Subject<number>();

 

  // Observable to allow components to subscribe to cart item count changes

  cartItemCount$ = this.cartItemCountSubject.asObservable();

 

  updateCartItemCount(count: number) {

    this.cartItemCountSubject.next(count);

  }

 

   // Get the cart item count for a specific user

  //  getCartItemCount(userId: string): Observable<any> {

  //   return this.getCartByUserId(userId);

  // }

 

  // getCartItemCount(userId: string): number {

  //   return this.userCartCounts.get(userId) || 0;

  // }

 

  getCategory(productId:any): Observable<Cart>

  {

    const url = `${this.fetchCategory}/${productId}`;

    return this.http.get<any>(url);

  }

 

  total_price(price: number, quantity: number)

  {

    console.log(price*quantity);  

    return price*quantity;

  }

 

  updateEstimatedTotalAmount(userId:any)

  {

    this.getCartByUserId(userId).subscribe((cartItems: Cart[]) => {

      this.estimatedTotalAmount = 0;

      this.cartSubject.next(cartItems.length);

      for (const cartItem of cartItems) {

        this.estimatedTotalAmount += cartItem.total_price;

      }

      this.estimatedTotalAmount = Math.round(this.estimatedTotalAmount * 100) / 100;

    });

  }

 

  addToCart(product: Product, userid: number, quantity: number): Observable<Cart> {

    const totalprice_product = this.total_price(product.price,quantity);

    const cartRequest: Cart = {

      price: product.price,

      total_price: totalprice_product,

      productId: product.productId.toString(),

      userId: userid,

      quantity: quantity,

    };

    // Update the total quantity

    this.totalQuantity += quantity;

    this.cartItemCountSubject.next(this.totalQuantity);

    console.log("Wishlist service addtowishlist request")

    return this.http.post<Cart>(`${this.baseUrl}/add`, cartRequest);

  }

 

  getAllCarts(): Observable<any> {

    return this.http.get(`${this.baseUrl}/all`);

  }

 

  getCartByUserId(myuserId:any):Observable<any>

  {

    return this.http.get(`${this.baseUrl}/byUserId/${myuserId}`);

  }

 

  deleteCartByCartId(cartId: any): Observable<any> {

    const url = `${this.baseUrl}/delete/${cartId}`;

    return this.http.delete<void>(url);

  }

 

  deleteCartByUserId(userId: any): Observable<any> {

    const url = `${this.baseUrl}/deletes/${userId}`;

    return this.http.delete(url, { responseType: 'text' }).pipe(

      catchError((error: any) => {

        console.error('Error deleting cart:', error);

        return throwError(error);

      })

    );

  }

 

  updateCart(cartItem: Cart): Observable<Cart> {

    const url = `${this.baseUrl}/add`;

    const httpOptions = {

      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),

    };

    return this.http

      .post<Cart>(url, cartItem, httpOptions)

      .pipe(catchError(this.handleError));

  }

 

  private handleError(error: any) {

    console.error('An error occurred:', error);

    return throwError(error);

  }

}