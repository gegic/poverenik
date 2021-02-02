import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ObavestenjeService {

  obavestenja: any[];
  zahtev: BehaviorSubject<any> = new BehaviorSubject<any>(null);

  constructor(private httpClient: HttpClient) { }

  send(body: any): Observable<any> {
    return this.httpClient.post('/api/obavestenja', body);
  }

  getAllByKorisnikId(korisnikId: string): Observable<any> {
    return this.httpClient.get(`/api/obavestenja/korisnik/${korisnikId}`);
  }

  getAll(): Observable<any> {
    return this.httpClient.get(`/api/obavestenja/`);
  }

  getById(id: string): Observable<any> {
    return this.httpClient.get(`/api/obavestenja/${id}`);
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/obavestenja/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/obavestenja/generate-xhtml/${id}`, null);
  }
}
