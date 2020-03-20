import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Card } from '../card';
import { CardService } from '../services/card.service';

@Component({
  selector: 'app-admin-card',
  templateUrl: './admin-card.component.html',
  styleUrls: ['./admin-card.component.css']
})
export class AdminCardComponent implements OnInit {
  public cards: Card[];

  constructor(
    public userService: UserService,
    public cardService: CardService
  ) { }

  ngOnInit(): void {
    this.cardService.getCards().subscribe(
      resp => {
        this.cards = resp;
      }
    )
  }

}
