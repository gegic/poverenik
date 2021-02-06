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

  getById(zalbaCutanjeId: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-cutanje/${zalbaCutanjeId}`);
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-cutanje/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/zalbe-cutanje/generate-xhtml/${id}`, null);
  }
}
