import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { OwnedCard } from '../owned-card';
import { User } from '../user';
import { Comment } from '../comment';
import { CardService } from './card.service';
import { Card } from '../card';
import { map } from 'rxjs/operators';
 
@Injectable({
  providedIn: 'root'
})
export class OwnedCardsService {
  private appUrl = this.urlService.getUrl() + 'ownedCards';
  private headers = new HttpHeaders({
      'Content-Type': 'application/json'
  });

  private u: User;
  private comment: Comment;
  private card: Card;

  constructor(
    public cs: CardService,
    public urlService: UrlService,
    public http: HttpClient,
    private us: UserService
    ) { }

  getOwnedCards(): OwnedCard[]{
    this.us.getLoggedUser();
    return this.us.getUserObject().patron.ownedCards;
  }

  addCardComment(cardId: number, commentText: string): Observable<Comment> {
    this.us.getLoggedUser();
    let c = new Comment;

    // ADDING TO COMMENT
    this.cs.getCard(cardId).subscribe((card)=>{
      c.card = card;
    });
    c.commentText = commentText;
    c.patron = this.us.getUserObject().patron;

    console.log(c);
    
    const body = JSON.stringify(c);

    return this.http.post(this.urlService.getUrl() + 'addComment', body, 
      {headers: this.headers, withCredentials: true})
      .pipe(
        map(resp => {
          const comment: Comment = resp as Comment;
          this.comment = comment;
          return comment;
        })
      )
  }
}
