import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { CardService } from '../services/card.service';
import { Card } from '../card';
import { Comment } from '../comment';

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit {
  CardService: any;
  public card: Card;
  public comment: Comment;

  constructor(
    private cs: CardService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getCard();
  }

  getCard(): void {
  const id = +this.route.snapshot.paramMap.get('id');
  this.cs.getCard(id)
    .subscribe(Card => this.card = Card);
  }

  addComment(): void {
    
  }

  goBack(): void {
    this.location.back();
  }
}
