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

  private user: User;

  

  constructor(
    public urlService: UrlService,
    public http: HttpClient
  ) { }

  checkLogin(username: string, password: string): Observable<User>{
    let u = new User;
    u.username = username;
    u.password = password;
    const body = JSON.stringify(u);
    console.log(body);
    return this.http.post(this.urlService.getUrl() + 'login', body, 
      {headers: this.headers, withCredentials: true})
      .pipe(
        map(resp => {
          const user: User = resp as User;
          if (user) {
            this.user = user;
          }
          return user;
        })
      )
  }

  registerUser(u: User): Observable<User>{
    const body = JSON.stringify(u);
    console.log(body);
    return this.http.post(this.appUrl, body,
        {headers: this.headers, withCredentials: true})
        .pipe(map(resp => resp as User))
  }

  getUser(): User {
    return this.user;
  }
  isAdmin(): boolean {
    return !(this.user !== undefined && this.user.patron !== undefined && this.user.patron !== null);
  }
  isUser(): boolean {
    return (this.user !== undefined && this.user.patron !== undefined && this.user.patron !== null);
  }

  logOut(): User {
    return this.user = null;
  }
}
