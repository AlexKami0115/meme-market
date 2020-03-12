import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OwnedCardsService } from '../services/owned-cards.service';
import { OwnedCard } from '../owned-card';
 
@Component({
  selector: 'app-view-collection',
  templateUrl: './view-collection.component.html',
  styleUrls: ['./view-collection.component.css']
})
export class ViewCollectionComponent implements OnInit {
  public ownedCardCollection: OwnedCard[];

  constructor(
    private ocs: OwnedCardsService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.ownedCardCollection = this.ocs.getOwnedCards();
  }

}
