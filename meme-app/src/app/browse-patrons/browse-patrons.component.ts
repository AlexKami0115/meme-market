import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-browse-patrons',
  templateUrl: './browse-patrons.component.html',
  styleUrls: ['./browse-patrons.component.css']
})
export class BrowsePatronsComponent implements OnInit {

  constructor(
    public us: UserService
  ) { }

  ngOnInit(): void {
  }

}
