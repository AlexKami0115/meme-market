import { Component, OnInit, OnChanges } from '@angular/core';
import { faAlignLeft } from '@fortawesome/free-solid-svg-icons';
import { UserService } from '../services/user.service';
import { User } from '../user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnChanges {
  faAlignLeft = faAlignLeft;
  public u: User;
  
  constructor(
    public userService: UserService
  ) {}

  ngOnInit(): void {
    this.u = this.userService.getUser();
  }

  ngOnChanges(): void {
    this.u = this.userService.getUser();
  }

  isUser(): boolean {
    return this.userService.isUser();
  }

  isAdmin(): boolean {
    return this.userService.isAdmin();
  }

  isPatron(): boolean {
    return this.userService.isPatron();
  }

  logOut(): User {
    return this.userService.logOut();
  }
}
