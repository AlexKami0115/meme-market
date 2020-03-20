import { Injectable } from '@angular/core';
import { Card } from '../card';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class CardService {
  private appUrl = this.urlService.getUrl() + 'card';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });
  messageService: any;

  constructor(
    public urlService: UrlService,
    public http: HttpClient
    ) { }

  addCard(c: Card): Observable<Card> {
    const body = JSON.stringify(c);
    return this.http.post(this.appUrl, body, 
    {headers: this.headers, withCredentials: true})
    .pipe( 
      map(resp => resp as Card) 
    );
  }

  getCard(id: number): Observable<Card>{
    return this.http.get(this.appUrl + "/" + id)
      .pipe( 
        map(resp => resp as Card) 
      );
  }

  getCards(): Observable<Card[]>{
    return this.http.get(this.appUrl)
      .pipe( 
        map(resp => resp as Card[]) 
      );
  }

  deleteCard(id: number | string): Observable<Card> {
    return this.http.delete(this.appUrl + '/' + id,
    {headers: this.headers, withCredentials: true})
    .pipe( 
      map(resp => resp as Card) 
    );
  }
}
