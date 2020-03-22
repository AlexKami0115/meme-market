import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { CardService } from '../services/card.service';
import { Card } from '../card';
import { Comment } from '../comment';
import { OwnedCardsService } from '../services/owned-cards.service';
import { UserService } from '../services/user.service';
import Swal from 'sweetalert2';

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
        this.card.comment.push(this.comment);
        this.comment = new Comment;
      });;
    }
    else {
      alert('Please enter a comment')
    }
  }

  deleteCard(): void {
    this.cs.deleteCard(this.card.id).subscribe(
      resp => {
        Swal.fire({
          icon: 'success',
          text: 'Card Deleted!',
          showConfirmButton: false,
          timer: 2000
        })
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
        this.card.comment.pop();
      }
    )
  }
}
