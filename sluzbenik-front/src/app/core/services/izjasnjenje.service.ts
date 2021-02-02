import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IzjasnjenjeService {

  izjasnjenja: any[];

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any> {
    return this.httpClient.get('/api/izjasnjenja');
  }

  odgovori(id: string, odgovor: any): Observable<any> {
    return this.httpClient.post(`/api/izjasnjenja/odgovori/${id}`, odgovor);
  }
}
