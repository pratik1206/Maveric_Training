import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/model';
import { WishListRequest } from '../model/wishlist-request.model';


@Injectable({
  providedIn: 'root'
})
export class WishlistService {
  private baseUrl = 'http://localhost:8087/wishlist';
  

  constructor(private httpClient: HttpClient) { }

  getWishlist(userId: any): Observable<any> {
    console.log("sdsd");
    
    return this.httpClient.get(this.baseUrl+"/list/"+userId);
  }

  deleteProduct(productId: any, userId: any): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/delete/${productId}/${userId}`);
  }

  // addToWishlist(data:any){
  //   return this.httpClient.post(this.baseUrl+'/add',data)
  // }

  addToWishlist(product: Product, userid: number, quantity: number): Observable<WishListRequest> {
    const wishListRequest: WishListRequest = {
      productId: product.productId.toString(),
      userId: userid, // Replace with the actual user ID
      quantity: quantity,
    };
    console.log("Wishlist service addtowishlist request")
    return this.httpClient.post<WishListRequest>(`${this.baseUrl}/add`, wishListRequest);
  }

}
