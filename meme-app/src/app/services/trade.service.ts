import { Injectable } from '@angular/core';
import { User } from '../user';
import { Trade } from '../trade';
import { UrlService } from './url.service';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

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

  addTrade(t: Trade): Observable<Card> {
    const body = JSON.stringify(t);
    return this.http.post(this.appUrl, body, 
    {headers: this.headers, withCredentials: true})
    .pipe( 
      map(resp => resp as Card) 
    );
  }

  setTradeCards()

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
