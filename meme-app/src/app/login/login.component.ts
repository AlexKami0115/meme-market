import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public u: User;

  constructor(
    private ls: LoginService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.u = new User;
  }


  submit(): void{
    if(this.u.username && this.u.password){
      this.ls.checkLogin(this.u).subscribe(
        resp => {
          this.u = resp;
        });
    }
    else {
      alert('Please fill out all fields.');
    }
  }

}
