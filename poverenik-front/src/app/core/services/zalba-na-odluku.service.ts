import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ZalbaNaOdlukuService {

  zalbeNaOdluku: any[];
  zahtev: any;
  obavestenje: any;

  constructor(private httpClient: HttpClient) { }

  create(body: any): Observable<any> {
    return this.httpClient.post('/api/zalbe-na-odluku', body);
  }

  getAllByKorisnikId(korisnikId: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-na-odluku/korisnik/${korisnikId}`);
  }

  getAllOdbijeniZahtevi(korisnikId: string): Observable<any> {
    return this.httpClient.get(`/api/zahtevi/odbijeni/${korisnikId}`);
  }

  getObavestenjeByZahtevId(zahtevId: string): Observable<any> {
    return this.httpClient.get(`/api/obavestenja/zahtev/${zahtevId}`);
  }
  getAllNeresene(): Observable<any> {
    return this.httpClient.get(`/api/zalbe-na-odluku/neresene`);
  }

  getAll(): Observable<any> {
    return this.httpClient.get('/api/zalbe-na-odluku');
  }

  getById(zalbaCutanjeId: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-na-odluku/${zalbaCutanjeId}`);
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-na-odluku/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-na-odluku/generate-xhtml/${id}`, null);
  }
}
