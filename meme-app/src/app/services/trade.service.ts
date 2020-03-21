import { Injectable } from '@angular/core';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class TradeService {
  public loggedUser: User;
  public otherUser: User;

  constructor() { }

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
