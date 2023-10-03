import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ProductService } from '../service/product.service'; 
import { CartService } from '../service/cart.service'; 
import { Product } from '../model/model'; 
import { WishlistComponent } from '../wishlist/wishlist.component'; 
import { WishlistService } from '../service/wishlist.service';
import { WishListRequest } from '../model/wishlist-request.model';
import { EcommerceserviceService } from '../service/user.service';
import { Cart } from '../model/cart.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css'],
})
export class ProductDetailsComponent {
  selectedProduct: Product | null = null;
  // userId: number = null;
  quantity: number = 1;
  productImages: string[] = []; // Array to store product image URLs
  selectedImageIndex: number = 0; // Index of the currently selected image
  userId: number;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService,
    private cartService: CartService,
    private wishlistService: WishlistService,
    private userService: EcommerceserviceService
  ) {
    this.userId = 0;
  }

  ngOnInit(): void {
    // Fetch product details based on the 'productId' route parameter
    const productId = this.route.snapshot.paramMap.get('productId');
    if (productId) {
      this.productService.getProductDetails(String(productId)).subscribe({
        next: (product: Product) => {
          this.selectedProduct = product;

          this.productImages = [
            './assets/images/product1.jpg',
            './assets/images/product2.jpg',
            './assets/images/product3.jpg',
            './assets/images/product4.jpg',
            // Add more image URLs as needed
          ];
        },
        error: (error) => {
          console.error('Error fetching product details:', error);
          // Handle error, e.g., display an error message or redirect to an error page
          this.router.navigate(['/error']); // Redirect to an error page
        },
      });

      this.userId = this.userService.getStoreUserId();
    }
  }

  increaseQuantity() {
    this.quantity++;
  }

  decreaseQuantity() {
    if (this.quantity > 1) {
      this.quantity--;
    }
  }

  // addToCart(product: Product, quantity: number) {
  //   this.cartService.addToCart(product, quantity);
  //   this.router.navigate(['/cart']); // Navigate to the cart page
  // }

  addToCart(product: Product, quantity: number) {

    this.cartService.addToCart(product,this.userId, quantity).subscribe({

      next: (response: Cart) => {

        // Handle successful addition to the cart

        console.log(`Added ${product.name} ${product.productId} to the cart`);

        this.cartService.updateEstimatedTotalAmount(this.userId);

        // Update the cart item count in the header component

      // this.cartService.updateCartItemCount(this.userId,count);

        //this.router.navigate(['/cart']);

        Swal.fire("Product added to cart")

      },

      error: (error: any) => {

        // Handle error

        console.error('Error adding to wishlist:', error);

      },

    });

  }

  addToWishlist(product: Product, quantity: number) {
    this.wishlistService.addToWishlist(product,this.userId, quantity).subscribe({
      next: (response: WishListRequest) => {
        // Handle successful addition to the wish list
        console.log(`Added ${product.name} to the wishlist`);
        Swal.fire('product added to wishlist');

        // this.router.navigate(['/wishlist']);
      },
      error: (error: any) => {
        // Handle error
        console.error('Error adding to wishlist:', error);
      },
    });
  }

  // Function to handle clicking the Previous button
  previousImage() {
    this.selectedImageIndex = (this.selectedImageIndex - 1 + this.productImages.length) % this.productImages.length;
  }

  // Function to handle clicking the Next button
  nextImage() {
    this.selectedImageIndex = (this.selectedImageIndex + 1) % this.productImages.length;
  }
}