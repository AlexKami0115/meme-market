import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { CardService } from '../services/card.service';
import { Card } from '../card';
import { Comment } from '../comment';
import { OwnedCardsService } from '../services/owned-cards.service';
import { UserService } from '../services/user.service';

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
    private location: Location,
    public us: UserService,
    private router: Router
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
        alert('Comment: ' + this.comment.commentText + ' added!');
        this.card.comment.push(this.comment);
      });;
    }
    else {
      alert('Please enter a comment')
    }
  }

  deleteCard(): void {
    this.cs.deleteCard(this.card.id).subscribe(
      resp => {
        this.router.navigate(['/admin-card']);
      }
    )
  }

  goBack(): void {
    this.location.back();
  }

  getTimestamp(timeOfComment: Date): String {
    let timestamp = new Date(timeOfComment);
    return timestamp.toLocaleString();
  }

  deleteComment(comment: Comment): void {
    this.ocs.deleteCardComment(comment).subscribe(
      resp => {
        alert('comment is deleted: ' + comment.commentText);
        this.card.comment.pop();
      }
    )
  }
}
