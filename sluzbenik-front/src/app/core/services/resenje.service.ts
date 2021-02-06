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

  getById(id: string): Observable<any> {
    return this.httpClient.get(`/api/resenja/${id}`);
  }

  generatePdf(id: string): Observable<any> {
    return this.httpClient.post(`/api/resenja/generate-pdf/${id}`, null);
  }

  generateXHTML(id: string): Observable<any> {
    return this.httpClient.post(`/api/resenja/generate-xhtml/${id}`, null);
  }
}
