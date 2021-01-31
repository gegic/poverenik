import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OdgovorService {

  constructor(private httpClient: HttpClient) { }

  send(body: any): Observable<any> {
    return this.httpClient.post('/api/obavestenja', body);
  }
}
