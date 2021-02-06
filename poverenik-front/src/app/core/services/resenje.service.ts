import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResenjeService {

  resenja: any[];
  zalba: any;
  odgovor: any;

  constructor(private httpClient: HttpClient) { }

  send(body: any): Observable<any> {
    return this.httpClient.post('/api/resenja', body);
  }

  getAllByKorisnikId(korisnikId: string): Observable<any> {
    return this.httpClient.get(`/api/resenja/korisnik/${korisnikId}`);
  }

  getAll(): Observable<any> {
    return this.httpClient.get(`/api/resenja/`);
  }

  getById(id: string): Observable<any> {
    return this.httpClient.get(`/api/resenja/${id}`);
  }

  getOdgovor(idZalbe: string) : Observable<any> {
    return this.httpClient.get(`/api/odgovori/zalba/${idZalbe}`);
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/resenja/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/resenja/generate-xhtml/${id}`, null);
  }

  generateJson(id: string): Observable<any> {
    return this.httpClient.post(`/api/resenja/generate-json/${id}`, null);
  }

  generateRdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/resenja/generate-rdf/${id}`, null);
  }
}
