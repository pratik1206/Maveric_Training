import { Component, OnInit } from '@angular/core';
import { OrderService } from '../service/order.service'
import {EcommerceserviceService} from '../service/user.service';
@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

 
  orderDetails: any; 
  constructor(private orderService: OrderService,public userService: EcommerceserviceService) { }

  ngOnInit() {
    const userId = this.userService.getStoreUserId();

    this.orderService.getOrdersByUserId(userId).subscribe(
      (orderDetails) => {
        this.orderDetails = orderDetails;
        console.log('Order Details:', orderDetails);
      },
      (error) => {
        console.error('Error fetching order details:', error);
      }
    );
  }

}
