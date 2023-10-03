import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../model/order.model';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl = 'http://localhost:8085/order/retrieve/orders';
  private apiSaveUrl = 'http://localhost:8085/order';

  constructor(private http: HttpClient) { }

  getOrdersByUserId(userId: number): Observable<any> { 
    const url = `${this.apiUrl}/${userId}`;
    return this.http.get(url);
  }

  placeOrder( totalprice: number, userid: number): Observable<Order> {
    
    const orderRequest: Order = {
      userId: userid,
      totalAmount: totalprice
    };
    
    console.log("Order service place order request")
    Swal.fire('order placed successfully');
    return this.http.post<Order>(`${this.apiSaveUrl}/save`, orderRequest);
  }
}
