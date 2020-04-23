import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Link } from './link';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LinkService {

  constructor(private http: HttpClient) { }

  public getLinks(url:string): Observable <Link []> {
    const httpOptions={
      headers: new HttpHeaders({
        'Accept': 'application/json'
      })
    }

    return this.http.post<Link[]>(`http://localhost:8090/link/${url}`, httpOptions );
  }

}
