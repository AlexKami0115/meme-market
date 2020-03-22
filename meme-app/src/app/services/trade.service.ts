import { Injectable } from '@angular/core';
import { User } from '../user';
import { Trade } from '../trade';

@Injectable({
  providedIn: 'root'
})
export class TradeService {
  public loggedUser: User;
  public otherUser: User;
  public trade: Trade;


  constructor() { }

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
