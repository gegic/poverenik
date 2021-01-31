import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Zahtev} from '../model/zahtev';

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {

  zahtevi: Zahtev[];

  constructor(private httpClient: HttpClient) { }

  create(body: any): Observable<any> {
    return this.httpClient.post('/api/zahtevi', body);
  }

  getAll(): Observable<any> {
    return this.httpClient.get('/api/zahtevi');
  }

}
