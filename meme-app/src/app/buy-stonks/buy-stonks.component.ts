import { Component, OnInit } from '@angular/core';
import { UrlService } from '../services/url.service';
import { UserService } from '../services/user.service';
import { User } from '../user';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-buy-stonks',
  templateUrl: './buy-stonks.component.html',
  styleUrls: ['./buy-stonks.component.css']
})
export class BuyStonksComponent implements OnInit {
  private appUrl = this.urlService.getUrl() + 'user';
  private user: User;
  public stonks: Number;

  constructor(
    private urlService: UrlService,
    public userService: UserService,
    private router: Router
  ) { }



  ngOnInit(): void {
    this.user = this.userService.getUser();
  }

  setStonks(value: String): void {
    this.stonks = Number(value);
    console.log(this.stonks);
  }

  submit(): void {
    if (this.stonks) {
      this.user.patron.stonks += Number(this.stonks);
      this.userService.updateUser(this.user).subscribe(
        resp => {
          Swal.fire({
            icon: 'success',
            text: this.stonks + ' stonks successfully purchased.',
            showConfirmButton: false,
            timer: 2200
          })
          this.router.navigate(['/pick-card-pack']);
        }
      )
    }
  }

}
