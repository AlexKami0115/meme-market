import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../user';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators/map';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private appUrl = this.urlService.getUrl() + 'login';
  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });


  constructor(
    public urlService: UrlService,
    public http: HttpClient
  ) { }

  checkLogin(u: User): Observable<User>{
    const body = JSON.stringify(u);
    return this.http.post(this.appUrl, body, 
      {headers: this.headers, withCredentials: true})
      .pipe(
        map(resp => resp as User)
      )
  }
}
