import { Component, OnInit } from '@angular/core';
import { faAlignLeft } from '@fortawesome/free-solid-svg-icons';
import { User } from '../user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  faAlignLeft = faAlignLeft;

  constructor(
    public userService: UserService
  ) { }

  ngOnInit(): void {
  }

  isUser(): boolean {
    return this.userService.isUser();
  }

  isAdmin(): boolean {
    return this.userService.isAdmin();
  }

}
