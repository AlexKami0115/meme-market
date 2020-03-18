import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-remove-user',
  templateUrl: './remove-user.component.html',
  styleUrls: ['./remove-user.component.css']
})
export class RemoveUserComponent implements OnInit {
  public username: string;

  constructor(
    private us: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  removeUser(): void {
    if(this.username){
      this.us.deleteUser(this.username).subscribe(
        resp => {
          alert('username: ' + this.username + 'deleted')
          this.router.navigate(['/home']);
        },
        error => {
          alert('Username not Found.')
        }
        );
    }
    else {
      alert('Please enter a valid username');
    }
  }
}
