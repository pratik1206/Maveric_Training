import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  productForm = this.formBuilder.group({
    userId:[2],
    productId:[''],
    name: ['', Validators.required],
    quantity: [''],
    price: [0, Validators.required],
    timestamp: [new Date()]
  });
 
  Url = 'http://localhost:8080/wishlist/add';
  constructor(public httpclient:HttpClient,public formBuilder:FormBuilder) { }
  submit(){
    
  }
  onSubmit(){
    console.log(this.productForm.value);
    this.httpclient.post(this.Url,this.productForm.value).subscribe(()=>{
      console.log("added");
      
      
    })
  }

  ngOnInit(): void {
  }

}
