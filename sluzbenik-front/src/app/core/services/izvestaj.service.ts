import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IzvestajService {

  godisnjaStatistika: any;

  constructor(private httpClient: HttpClient) { }

  getGodisnjaStatistika(): Observable<any> {
    return this.httpClient.get('/api/izvestaji/godisnja-statistika');
  }

  post(izvestaj: any): Observable<any> {
    return this.httpClient.post('/api/izvestaji', izvestaj);
  }
}
