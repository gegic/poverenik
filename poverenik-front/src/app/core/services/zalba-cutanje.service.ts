import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ZalbaCutanjeService {

  zalbeCutanje: any[];
  zahtev: any;

  constructor(private httpClient: HttpClient) { }

  create(body: any): Observable<any> {
    return this.httpClient.post('/api/zalbe-cutanje', body);
  }

  getAllByKorisnikId(korisnikId: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-cutanje/korisnik/${korisnikId}`);
  }

  getAllNeodgovoreniZahtevi(korisnikId: string): Observable<any> {
    return this.httpClient.get(`/api/zahtevi/neodgovoreni/${korisnikId}`);
  }

  getAllNeresene(): Observable<any> {
    return this.httpClient.get(`/api/zalbe-cutanje/neresene`);
  }

  getAll(): Observable<any> {
    return this.httpClient.get('/api/zalbe-cutanje');
  }

  getById(zalbaCutanjeId: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-cutanje/${zalbaCutanjeId}`);
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-cutanje/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-cutanje/generate-xhtml/${id}`, null);
  }

  generateJson(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-cutanje/generate-json/${id}`, null);
  }

  generateRdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-cutanje/generate-rdf/${id}`, null);
  }
}
