import { Component, OnInit } from '@angular/core';
import { FormBuilder, MaxLengthValidator, Validators } from '@angular/forms';
import { EcommerceserviceService } from '../service/user.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent  {
  constructor(
    private fb:FormBuilder,
    private router:Router,
    private ecomservice : EcommerceserviceService){}
  
  
    registrationForm = this.fb.group({
    username: ['',[Validators.required]],
    password: ['',[Validators.required]],
    email:['',[Validators.required,Validators.email]]

  })

  get username(){
    return this.registrationForm.get('username')
  }
  get password(){
    return this.registrationForm.get('password')
  }
  get email(){
    return this.registrationForm.get('email')
  }


  navigateToLogin() {
    this.router.navigateByUrl('/login'); 
  }
  

  onSubmit() {
    if (this.registrationForm.valid) {
      // If the form is valid, submit the registration data
      this.ecomservice.register(this.registrationForm.value).subscribe(
        (success) => {
          console.log(success);
           
          Swal.fire('Registration success')
          this.navigateToLogin();
        },
        (error) => {
          
          console.error(error);
          Swal.fire('User Already Existed,Please login.')
          //alert(error.error);
        
        }
      );
    } else {
      // If the form is invalid, mark all form controls as touched to display error messages
      this.registrationForm.markAllAsTouched();
    }
  }
}  
