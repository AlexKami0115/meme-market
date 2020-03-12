import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

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
          if (resp) this.router.navigate(['/home']);
        },
        error => {
          alert('Incorrect username or password.')
        }
        );
    }
    else {
      alert('Please fill out all fields.');
    }
  }

}
