import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {

  zahtevi: any[];

  constructor(private httpClient: HttpClient) { }

  getById(zahtevId: string): Observable<any> {
    return this.httpClient.get(`/api/zahtevi/${zahtevId}`);
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/zahtevi/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/zahtevi/generate-xhtml/${id}`, null);
  }
}
