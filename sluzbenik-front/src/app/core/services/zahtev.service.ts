import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {

  constructor(private httpClient: HttpClient) { }

  create(body: any): Observable<any> {
    return this.httpClient.post('/api/zahtevi', body);
  }

}
