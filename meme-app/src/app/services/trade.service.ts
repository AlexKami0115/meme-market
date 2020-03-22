import { Injectable } from '@angular/core';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class TradeService {
  public loggedUser: User;
  public otherUser: User;
  

  constructor() { }

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
