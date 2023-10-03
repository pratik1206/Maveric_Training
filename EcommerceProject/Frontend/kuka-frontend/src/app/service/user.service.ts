import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

@Injectable({

  providedIn: 'root'

})

export class EcommerceserviceService {
  items:any;
  loggedIn:boolean=false;

  storeUserId: any;

  username: any = '';
  userDetails:any;

  url :string = 'http://localhost:8089/users/user/registeration';

  url1 :string ='http://localhost:8089/users/user/login';

  constructor(private http:HttpClient) {

      // this.storeUserId = 0; // Initialize with a default value

   }

  register(reg:any): Observable<any>{

    console.log(reg);

    return this.http.post(this.url,reg);

  }

  login(credentials: any): Observable<any> {

    return this.http.post(this.url1, credentials, { responseType: 'text' });

  }

  setStoreUserId(userId: any) {

    this.storeUserId = userId;

  }

  getStoreUserId() {

    return this.storeUserId;

  }

  setUsername(username: any) {
    this.username = username;
  }

  getUsername() {
    return this.username;
  }

  }

 