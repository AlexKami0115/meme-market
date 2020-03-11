import { Injectable } from '@angular/core';
import { Card } from '../card';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class CardService {
  private appUrl = this.urlService.getUrl() + 'card';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });

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
}
