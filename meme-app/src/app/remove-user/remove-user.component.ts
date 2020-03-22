import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { User } from '../user';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-remove-user',
  templateUrl: './remove-user.component.html',
  styleUrls: ['./remove-user.component.css']
})
export class RemoveUserComponent implements OnInit {
  public username: string;
  patronUsers: User[];

  constructor(
    private us: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.us.getPatronUsers().subscribe(
      resp => {
        this.patronUsers = resp;
      }
    );
  }

  removeUser(): void {
    if(this.username){
      this.us.deleteUser(this.username).subscribe(
        resp => {
          Swal.fire({
            icon: 'success',
            text: 'User: ' + this.username + ' removed.',
            showConfirmButton: false,
            timer: 2000
          })
          this.router.navigate(['/home']);
        },
        error => {
          Swal.fire({
            icon: 'error',
            text: 'Username not found.',
          })
        }
        );
    }
    else {
      Swal.fire({
        icon: 'error',
        text: 'Please enter a valid username.',
      })
    }
  }
}
