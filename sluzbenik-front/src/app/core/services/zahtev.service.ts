import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {

  zahtevi: any[];

  constructor(private httpClient: HttpClient) { }

  create(body: any): Observable<any> {
    return this.httpClient.post('/api/zahtevi', body);
  }

  getAllByKorisnikId(korisnikId: string): Observable<any> {
    return this.httpClient.get(`/api/zahtevi/korisnik/${korisnikId}`);
  }

  getAllNeodgovoreni(): Observable<any> {
    return this.httpClient.get('/api/zahtevi/neodgovoreni');
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/zahtevi/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/zahtevi/generate-xhtml/${id}`, null);
  }
}
