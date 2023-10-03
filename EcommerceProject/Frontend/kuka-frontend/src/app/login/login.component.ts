import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { EcommerceserviceService } from '../service/user.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(
    private fb: FormBuilder,
    private userService: EcommerceserviceService,
    private router:Router
    ){ }


  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });


  onSubmit() {

    if (this.loginForm.valid) {

      this.userService.login(this.loginForm.value).subscribe(

        (response: any) => {

          if (response) {

            console.log('Received Token:', JSON.parse(response));

            let res=JSON.parse(response);
            let username=res.userDetails.username;
            //this.userService.setUsername(username);
            //console.log(username);

            let storeUserId = res.userDetails.id;
            //this.userService.loggedIn=true;//setting the service var as true for successful logged of customer

           // this.userService.setStoreUserId(storeUserId);

           // console.log(storeUserId);
            
            //this.userService.userDetails=response;

            //console.log(this.userService.userDetails);

            localStorage.setItem('token', res.token);
            console.log("token in localstorage", localStorage.getItem('token'));

            localStorage.setItem('userId',res.userDetails.id);
            console.log("userId in localstorage ",localStorage.getItem('userId'));

            localStorage.setItem('username',res.userDetails.username);
            console.log("username in localstorage ",localStorage.getItem('username'));
            

            console.log(res.token);

           // Swal.fire('Login success');

           this.router.navigate(['plp/c',151839]);

          } else {

            console.error('Login failed: No token received.');

            Swal.fire('Login failed');

          }

        },

        (error) => {

          console.error('Login failed:', error);

          console.log(error);

          alert(error.error);

        }

      );

    }

  }

}