import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {Router} from '@angular/router';
import {Korisnik} from '../model/korisnik';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  korisnik: BehaviorSubject<Korisnik | undefined>;
  token: BehaviorSubject<string | undefined>;

  constructor(private httpClient: HttpClient,
              private router: Router) {
    this.korisnik = new BehaviorSubject<Korisnik | undefined>(JSON.parse(localStorage.getItem('korisnik') as string));
    this.token = new BehaviorSubject<string | undefined>(localStorage.getItem('token') as string);
  }

  login(xml: string): Observable<any> {
    return this.httpClient.post('/auth/prijava', xml);
  }

  register(xml: string): Observable<any> {
    return this.httpClient.post('/auth/registracija', xml);
  }

  loggedIn(token: string, korisnik: Korisnik): void {
    this.korisnik.next(korisnik);
    this.token.next(token);
    localStorage.setItem('korisnik', JSON.stringify(korisnik));
    localStorage.setItem('token', token);
  }

  logout(): void {
    this.korisnik.next(null);
    this.token.next(null);
    localStorage.removeItem('korisnik');
    localStorage.removeItem('token');
    this.router.navigateByUrl('/login');
  }

  getKorisnikRole(): string {
    return this.korisnik.getValue().uloga._text;
  }

  isLoggedIn(): boolean {
    return !!this.korisnik.getValue();
  }

  updateKorisnikData(korisnik: Korisnik): void {
    this.korisnik.next(korisnik);
    localStorage.setItem('korisnik', JSON.stringify(korisnik));
  }
}
