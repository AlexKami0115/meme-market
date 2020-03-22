import { Injectable } from '@angular/core';
import { User } from '../user';
import { UrlService } from './url.service';
import { Trade } from '../trade';
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
  

  constructor(
    private urlService: UrlService,
    private http: HttpClient
  ) { }

  addCard(c: Card): Observable<Card> {
    const body = JSON.stringify(c);
    return this.http.post(this.appUrl, body, 
    {headers: this.headers, withCredentials: true})
    .pipe( 
      map(resp => resp as Card) 
    );
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
