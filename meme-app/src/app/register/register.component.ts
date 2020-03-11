import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public u: User;

  constructor(
    private us: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.u = new User;
  }

  submit(): void{
    if(this.u.username && this.u.password){
      this.us.registerUser(this.u).subscribe(
        resp => {
          this.u = resp;
        }
      );
    }else{
      alert('Please fill out all fields')
    }
  }

}
