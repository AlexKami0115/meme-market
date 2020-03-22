import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public username: string;
  public password: string;

  constructor(
    private us: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  submit(): void{
    if(this.username && this.password){
      this.us.checkLogin(this.username, this.password).subscribe(
        resp => {
          Swal.fire({
            icon: 'success',
            text: 'Login success.',
            showConfirmButton: false,
            timer: 1700
          })
          if (resp) this.router.navigate(['/home']);
        },
        error => {
          Swal.fire({
            icon: 'error',
            text: 'Incorrect username or password!',
          })
        }
        );
    }
    else {
      Swal.fire({
        icon: 'error',
        text: 'Please fill out both fields.',
      })
    }
  }

}
