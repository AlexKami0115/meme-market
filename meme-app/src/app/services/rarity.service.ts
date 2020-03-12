import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rarity } from '../rarity';
import { map } from 'rxjs/operators';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class RarityService {
  private appUrl = this.urlService.getUrl() + 'rarity';

  constructor(
    private http: HttpClient,
    private urlService: UrlService
    ) { }

  getRarities(): Observable<Rarity[]> {
    return this.http.get(this.appUrl)
      .pipe( map(resp => resp as Rarity[]) );
  }

  getRarity(id: number|string): Observable<Rarity> {
    return this.http.get(this.appUrl + '/' + id)
      .pipe( map(resp => resp as Rarity) );
  }
}
