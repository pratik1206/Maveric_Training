import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { WishlistService} from '../service/wishlist.service';
import { WishListRequest } from '../model/wishlist-request.model';
import { Product } from '../model/model';
import { Observable } from 'rxjs';
import { EcommerceserviceService } from '../service/user.service';
import Swal from 'sweetalert2';
import { CartService } from '../service/cart.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {
  wishLists: WishListRequest[];
  products:any
  userId:any
  constructor(private http: HttpClient,private route :Router,
    private cartService:CartService, private wishlistService: WishlistService,private userService:EcommerceserviceService, private router: ActivatedRoute
    ) {
      this.wishLists=[];
      // this.userId =localStorage.getItem('userId')
      

    }
  ngOnInit(): void {
    this.getWishlist()
    
  }
 
  fetchImages:any[] =[];
    

  getWishlist() {
    
    console.log("dcds");

    this.wishlistService.getWishlist(this.userService.storeUserId).subscribe((x:any)=>{
      console.log(x);
      this.products=x
      this.products=x.sort((a:any,b:any)=>b.name-a.name)
      console.log(x.sort((a:any,b:any)=>b.price-a.price));
      
      for (const item of this.products) {
        this.cartService.getCategory(item.productId).subscribe((productdetails: any) => {
          const product = { productId: item.productId, productName: productdetails.name, categoryId: productdetails.categoryId };
          this.fetchImages.push(product);
          console.log(this.fetchImages);
        });
      }

    })

    
      
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


  deleteproduct(data:any){
    console.log(data);
    
   this.wishlistService.deleteProduct(data,this.userService.storeUserId).subscribe(()=>{
      console.log("deleted");  
     this.getWishlist()
      this.route.navigateByUrl("/wishlist")
     Swal.fire('wishlist item deleted');

      
    })
  }

  navigateToProductDetails(productId: string) {
    this.route.navigate(['/product', productId]);
  }

  navigateBackToPLP() {
    this.route.navigate(['../'], { relativeTo: this.router });
  

}

}