import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClientModule } from '@angular/common/http';
import { OrderListComponent } from './order-list/order-list.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PLPPageComponent } from './plp-page/plp-page.component';
import { HeaderComponent } from './header/header.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CommonModule } from '@angular/common';
import { CartListComponent } from './cart/cart-list/cart-list.component';
import { WishlistComponent } from './wishlist/wishlist.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    PageNotFoundComponent,
    OrderListComponent,
    PLPPageComponent,
    ProductDetailsComponent,
    CartListComponent,
    HeaderComponent,
    WishlistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
