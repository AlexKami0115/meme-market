import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Tag } from '../tag';

@Injectable({
  providedIn: 'root'
})
export class TagService {

  constructor(private http: HttpClient) { }

  getTags(): Observable<Tag[]> {
    return this.http.get('')
      .pipe( map(resp => resp as Tag[]) );
  }

  getTag(id: number|string): Observable<Tag> {
    return this.http.get(''+id)
      .pipe( map(resp => resp as Tag) );
  }
}
