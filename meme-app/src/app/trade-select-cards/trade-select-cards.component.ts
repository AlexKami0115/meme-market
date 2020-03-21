import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { User } from '../user';
import { TradeService } from '../services/trade.service';

@Component({
  selector: 'app-trade-select-cards',
  templateUrl: './trade-select-cards.component.html',
  styleUrls: ['./trade-select-cards.component.css']
})
export class TradeSelectCardsComponent implements OnInit {
  public loggedUser: User;
  public otherUser: User;

  constructor(
    private location: Location,
    public ts: TradeService
  ) { }

  ngOnInit(): void {
    this.loggedUser = this.ts.getLoggedUser();
    this.otherUser = this.ts.getOtherUser();
    
    document.getElementById('otherUsersCardDiv').style.display = 'block';
    document.getElementById('loggedUsersCardDiv').style.display = 'none';
  }

  viewLoggedCollection(){
    document.getElementById('otherUsersCardDiv').style.display = 'none';
    document.getElementById('loggedUsersCardDiv').style.display = 'block';
  }

  viewOtherCollection(){
    document.getElementById('otherUsersCardDiv').style.display = 'block';
    document.getElementById('loggedUsersCardDiv').style.display = 'none';
  }

  goBack(): void {
    this.location.back();
  }
}
