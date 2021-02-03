import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IzvestajService {

  godisnjaStatistika: any;
  izvestaji: any[];

  constructor(private httpClient: HttpClient) { }

  getGodisnjaStatistika(): Observable<any> {
    return this.httpClient.get('/api/izvestaji/godisnja-statistika');
  }

  post(izvestaj: any): Observable<any> {
    return this.httpClient.post('/api/izvestaji', izvestaj);
  }

  getAll(): Observable<any> {
    return this.httpClient.get('/api/izvestaji');
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/izvestaji/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/izvestaji/generate-xhtml/${id}`, null);
  }

  getById(id: string): Observable<any> {
    return this.httpClient.get(`/api/izvestaji/${id}`);
  }
}
