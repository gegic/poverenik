import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthService} from '../services/auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const korisnik = this.authService.korisnik.getValue();
    const token = this.authService.token.getValue();
    const isLoggedIn: boolean = !!korisnik && !!token;
    const isApiUrl = request.url.startsWith('/api') || request.url.startsWith('api');
    if (isLoggedIn && isApiUrl) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }
    request = request.clone({
      setHeaders: {
        'Content-Type': 'application/xml'
      },
      responseType: 'text'
    });
    return next.handle(request);
  }
}
