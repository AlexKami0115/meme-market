import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { User } from '../user';
import { TradeService } from '../services/trade.service';
import { OwnedCard } from '../owned-card';

@Component({
  selector: 'app-trade-select-cards',
  templateUrl: './trade-select-cards.component.html',
  styleUrls: ['./trade-select-cards.component.css']
})
export class TradeSelectCardsComponent implements OnInit {
  public cardsToBeTraded: OwnedCard[] = new Array();
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

  toggleInOutOfList(oc: OwnedCard){
    let alreadyInList: boolean = false;
    let index: number = 0;
    for(let ctbt of this.cardsToBeTraded){
      if(alreadyInList || ctbt.id === oc.id){
        alreadyInList = true;
        break;
      }
      index += 1;
    }
    if(!alreadyInList){
      this.cardsToBeTraded.push(oc);
      document.getElementById('ownedCard' + oc.id).style.opacity = '.5';
    }else{
      this.cardsToBeTraded.splice(index,1);
      document.getElementById('ownedCard' + oc.id).style.opacity = '1';
    }
    console.log(this.cardsToBeTraded);
  }

  submitTradeOffer(){
    if(this.cardsToBeTraded.length === 0){
      //show alert
    }else{
      
    }
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
