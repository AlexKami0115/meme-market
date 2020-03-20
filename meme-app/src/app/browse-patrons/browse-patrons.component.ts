import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../user';

@Component({
  selector: 'app-browse-patrons',
  templateUrl: './browse-patrons.component.html',
  styleUrls: ['./browse-patrons.component.css']
})
export class BrowsePatronsComponent implements OnInit {
  patronUsers: User[];
  constructor(
    public us: UserService
  ) { }

  ngOnInit(): void {
    this.us.getPatronUsers().subscribe(
      resp => {
        this.patronUsers = resp;
      }
    );
  }

}
