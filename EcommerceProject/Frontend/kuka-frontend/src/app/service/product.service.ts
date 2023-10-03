// src/app/services/product.service.ts

import { Injectable } from '@angular/core';
import { Product } from '../model/model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {

  private apiUrl = 'http://localhost:8082/product/p'; 

  constructor(private http: HttpClient) {}

  getProductDetails(productId: String): Observable<Product> {
    const url = `${this.apiUrl}/${productId}`;

    return this.http.get<Product>(url);
  }

}
