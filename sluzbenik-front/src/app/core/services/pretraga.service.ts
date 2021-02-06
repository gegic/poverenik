import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PretragaService {

  constructor(private httpClient: HttpClient) { }

  pretragaZahteva(upit: string): Observable<any> {
    return this.httpClient.get(`/api/zahtevi/pretraga?upit=${upit}`);
  }

  pretragaObavestenja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/obavestenja/pretraga?upit=${upit}`);
  }

  pretragaIzvestaja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/izvestaji/pretraga?upit=${upit}`);
  }

  naprednaPretragaZahteva(upit: string): Observable<any> {
    return this.httpClient.get(`/api/zahtevi/napredna-pretraga?upit=${upit}`);
  }

  naprednaPretragaObavestenja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/obavestenja/napredna-pretraga?upit=${upit}`);
  }

  naprednaPretragaIzvestaja(upit: string): Observable<any> {
    return this.httpClient.get(`/api/izvestaji/napredna-pretraga?upit=${upit}`);
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
}
