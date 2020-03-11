import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../user';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators/map';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private appUrl = this.urlService.getUrl() + 'user';
  private headers = new HttpHeaders({
      'Content-Type': 'application/json'
  });

  constructor(
    public urlService: UrlService,
    public http: HttpClient
  ) { }

  registerUser(u: User): Observable<User>{
    const body = JSON.stringify(u);
    return this.http.post(this.appUrl, body,
        {headers: this.headers, withCredentials: true})
        .pipe(map(resp => resp as User))
  }
}
