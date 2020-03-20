import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { CardService } from '../services/card.service';
import { Card } from '../card';
import { Comment } from '../comment';
import { OwnedCardsService } from '../services/owned-cards.service';

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
    private ocs: OwnedCardsService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getCard();
    this.comment = new Comment;
  }

  getCard(): void {
  const id = +this.route.snapshot.paramMap.get('id');
  this.cs.getCard(id)
    .subscribe(Card => this.card = Card);
  }

  addComment(): void {
    const cardId = +this.route.snapshot.paramMap.get('id');

    if(this.comment.commentText) {
      this.ocs.addCardComment(cardId, this.comment.commentText).subscribe((resp)=>{
        this.comment = resp;
      });;
    }
    else {
      alert('Please enter a comment')
    }
  }

  goBack(): void {
    this.location.back();
  }
}
