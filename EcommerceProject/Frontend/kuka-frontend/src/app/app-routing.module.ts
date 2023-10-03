import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {OrderListComponent} from './order-list/order-list.component'
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PLPPageComponent } from './plp-page/plp-page.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { CartListComponent } from './cart/cart-list/cart-list.component';
import { KukaguardGuard } from './authentication/kukaguard.guard';
import { HeaderComponent } from './header/header.component';

const routes: Routes = [
  { path:'register',component: RegistrationComponent},
  { path: 'login', component: LoginComponent},
  { path: 'orders', component: OrderListComponent,canActivate:[KukaguardGuard] }, 
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Default to "All" category
  { path: 'plp/c/:categoryId', component: PLPPageComponent,canActivate:[KukaguardGuard] },
  {path: 'product/:productId', component: ProductDetailsComponent,canActivate:[KukaguardGuard]},
  {path: 'wishlist', component: WishlistComponent,canActivate:[KukaguardGuard]},
  {path: 'cart', component: CartListComponent,canActivate:[KukaguardGuard]},
  {path: 'header', component : HeaderComponent,canActivate:[KukaguardGuard]},
  {
    path: 'plp/n/search/:searchQuery',// Define the route with a parameter
 component: PLPPageComponent, // Use the PLPPageComponent for this route
  },
  {path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
