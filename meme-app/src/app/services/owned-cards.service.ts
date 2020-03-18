import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { OwnedCard } from '../owned-card';
 
@Injectable({
  providedIn: 'root'
})
export class OwnedCardsService {
  private appUrl = this.urlService.getUrl() + 'ownedCards';
  private headers = new HttpHeaders({
      'Content-Type': 'application/json'
  });

  constructor(
    public urlService: UrlService,
    public http: HttpClient,
    private us: UserService
    ) { }

  getOwnedCards(): OwnedCard[]{
    this.us.getLoggedUser().subscribe(
      resp => {}
    );
    return this.us.getUserObject().patron.ownedCards;
  }



}
