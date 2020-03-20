import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { OwnedCard } from '../owned-card';
import { UserService } from '../services/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-other-users-collection',
  templateUrl: './other-users-collection.component.html',
  styleUrls: ['./other-users-collection.component.css']
})
export class OtherUsersCollectionComponent implements OnInit {
  public user: User;
  public otherUser: User;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    public us: UserService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.user = this.us.getUser();
    this.getUser();
    
  }

  getUser(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.us.getUserById(id)
      .subscribe(resp => {
        this.otherUser = resp
        if(this.user.id === this.otherUser.id){
          this.router.navigate(['/view-collection']);
        }
      });
  }

  goBack(): void {
    this.location.back();
  }
}
