import { Injectable } from '@angular/core';
import { User } from '../user';
import { Trade } from '../trade';
import { UrlService } from './url.service';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { OwnedCard } from '../owned-card';

@Injectable({
  providedIn: 'root'
})
export class TradeService {
  private appUrl = this.urlService.getUrl() + 'trade';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
});
  public loggedUser: User;
  public otherUser: User;
  public trade: Trade;


  constructor(
    private urlService: UrlService,
    private http: HttpClient
  ) { }

  addTrade(t: Trade): Observable<Trade> {
    const body = JSON.stringify(t);
    return this.http.post(this.appUrl, body, 
    {headers: this.headers, withCredentials: true})
    .pipe( 
      map(resp => resp as Trade)
    );
  }

  submitTrade(tc: OwnedCard[]){
    this.trade.patronOne = this.loggedUser.patron;
    this.trade.patronTwo = this.otherUser.patron;
    this.trade.cardsToBeTraded = tc;
    this.addTrade(this.trade);
    alert('Your offer has been submitted.');
  }

  setTradeUsers(lu: User, ou: User){
    this.loggedUser = lu;
    this.otherUser = ou;
  }

  getLoggedUser(): User {
    return this.loggedUser;
  }

  getOtherUser(): User {
    return this.otherUser;
  }
  
}
