import { Component, OnInit } from '@angular/core';
import { KukaserviceService } from '../service/plp.service';
import { Product } from '../model/model';
import { ActivatedRoute, Router } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-plp-page',
  templateUrl: './plp-page.component.html',
  styleUrls: ['./plp-page.component.css']
})
export class PLPPageComponent implements OnInit {
  products: Product[] = [];

  constructor(
    private route: ActivatedRoute,
    private KukaserviceService: KukaserviceService,
    private cartService :CartService
  ) {}

  ngOnInit(): void {
    // Subscribe to route parameter changes to get the categoryId
    this.route.paramMap.subscribe(params => {

      console.log(params);
      console.log(params.get('categoryId'));
      const categoryId = String(params.get('categoryId'));
      const searchQuery = params.get('searchQuery');
      console.log(searchQuery);
      console.log(categoryId);
      if (searchQuery) {
        // Fetch products by search query
        this.getProductsBySearchQuery(searchQuery);
      } else {
        // Fetch products by category ID
        this.getProductsByCategory(categoryId);
      }
    });

    this.cartService.getCartByUserId(localStorage.getItem('userId')).subscribe((rowData)=>{   
    const currentCount = rowData.length;   
    this.cartService.updateCartItemCount(currentCount);      
    this.cartService.updateEstimatedTotalAmount(localStorage.getItem('userId'));   
    });

  }

  // Function to fetch products by category ID
  getProductsByCategory(categoryId: string) {
    this.KukaserviceService.getProductsByCategory(categoryId).subscribe((data: Product[]) => {
      this.products = data;
      console.log(this.products);
    });
  }
  // Function to fetch products by search
  getProductsBySearchQuery(query: string) {
    this.KukaserviceService.getProductsBySearchQuery(query).subscribe((data: Product[]) => {
      this.products = data;
    });
  }
}
