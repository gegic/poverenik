import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PretragaService {

  constructor(private httpClient: HttpClient) { }

  pretragaResenja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/resenja/pretraga?upit=${upit}`);
  }

  pretragaZalbiCutanje(upit: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-cutanje/pretraga?upit=${upit}`);
  }

  pretragaZalbiNaOdluku(upit: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-na-odluku/pretraga?upit=${upit}`);
  }

  pretragaIzvestaja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/izvestaji/pretraga?upit=${upit}`);
  }

  naprednaPretragaResenja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/resenja/napredna-pretraga?upit=${upit}`);
  }

  naprednaPretragaZalbiCutanje(upit: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-cutanje/napredna-pretraga?upit=${upit}`);
  }

  naprednaPretragaZalbiNaOdluku(upit: string): Observable<any> {
    return this.httpClient.get(`/api/zalbe-na-odluku/napredna-pretraga?upit=${upit}`);
  }

  naprednaPretragaIzvestaja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/izvestaji/napredna-pretraga?upit=${upit}`);
  }
}
