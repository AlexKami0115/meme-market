import { Component, OnInit } from '@angular/core';
import { faAlignLeft } from '@fortawesome/free-solid-svg-icons';
import { UserService } from '../services/user.service';
import { User } from '../user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  faAlignLeft = faAlignLeft;
  public u: User;
  
  constructor(
    public userService: UserService
  ) {this.u = this.userService.getUser(); console.log('user info', this.u) }

  ngOnInit(): void {
  }

  isUser(): boolean {
    return this.userService.isUser();
  }

  isAdmin(): boolean {
    return this.userService.isAdmin();
  }

  logOut(): User {
    return this.userService.logOut();
  }
}
