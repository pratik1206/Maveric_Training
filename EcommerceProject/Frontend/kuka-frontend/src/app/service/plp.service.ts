import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KukaserviceService {
  // url :string = 'http://localhost:8080/product/list';

  // category:any;
  // constructor(private http:HttpClient) {}
  // categories:any;
    
  // getProduct():Observable<any>{
  //   console.log('shagchasgc');
  //     return this.http.get(this.url);
  //   }

  private baseUrl: string = 'http://localhost:8082/product/c';
  private baseUrl1: string = 'http://localhost:8082/product/n';


  constructor(private http: HttpClient) {}

  getProductsByCategory(categoryId: string): Observable<any[]> {
    // if(categoryId!=0){
      const url = `${this.baseUrl}/${categoryId}`;
      return this.http.get<any[]>(url);
   
  }
  getProductsBySearchQuery(query: string): Observable<any[]> {
    const url = `${this.baseUrl1}/${query}`;
    return this.http.get<any[]>(url);
  }
  
}
