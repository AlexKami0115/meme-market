import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Card } from '../card';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PackService {
  private appUrl = this.urlService.getUrl() + 'pick-card-pack';
  private headers = new HttpHeaders({
      'Content-Type': 'application/json'
  });
  private cardsInPack: Card[];

  getCardPack(tier: number): Observable<Card[]>{
    return this.http.get(this.appUrl + '/' + tier, 
      {headers: this.headers, withCredentials: true})
      .pipe(
        map(resp => resp as Card[])
      )
  }




  constructor(
    public urlService: UrlService,
    public http: HttpClient
  ){}
}