import { Injectable, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { EcommerceserviceService } from '../service/user.service';
import { LoginComponent } from '../login/login.component';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class KukaguardGuard implements CanActivate {
  constructor(private userservice:EcommerceserviceService,private router:Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
        if(localStorage.getItem('token')){
          this.userservice.setStoreUserId(localStorage.getItem('userId'));
          this.userservice.setUsername(localStorage.getItem('username'));
          return true;
        }
        this.router.navigateByUrl('/login');
        Swal.fire("user is not authenticated");
        
        return false;
   
      /*  if(this.userservice.loggedIn){
        return true;
      }
      this.router.navigateByUrl('/login')
     return false;
  }*/
  
}
}
