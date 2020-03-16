import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

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

  isPatron(): boolean {
    return this.userService.isPatron();
  }

}
