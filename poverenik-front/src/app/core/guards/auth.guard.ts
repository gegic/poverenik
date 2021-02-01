import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {JwtHelperService} from '@auth0/angular-jwt';
import {Korisnik} from '../model/korisnik';
import {AuthService} from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  private jwtHelper: JwtHelperService = new JwtHelperService();

  constructor(private authService: AuthService,
              private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const korisnik = this.authService.korisnik.getValue();
    const token: string | null = this.authService.token.getValue();
    const isTokenExpired: boolean = !!token ? this.jwtHelper.isTokenExpired(token) : true;
    const isAuthenticated = !isTokenExpired && !!korisnik._attributes.id;

    let accessRoles: string[] = [];
    if (route.data.hasOwnProperty('roles')) {
      accessRoles = route.data.roles as string[];
    } else {
      return true;
    }
    if (accessRoles.length === 0) {
      return false;
    }
    if (!isAuthenticated && accessRoles.includes('UNREGISTERED')) {
      return true;
    } else if (!isAuthenticated && !accessRoles.includes('UNREGISTERED')) {
      this.router.navigate(['prijava']);
      return false;
    } else {
      const auth = this.authorize(accessRoles, korisnik) ?? false;
      if (!auth) {
        if (korisnik.uloga._text === 'gradjanin') {
          this.router.navigate(['']);
          return false;
        } else {
          this.router.navigate(['poverenik']);
          return false;
        }
      }
    }

    return true;
  }

  private authorize(accessRoles: string[], korisnik: Korisnik | null): boolean {
    console.log(accessRoles);
    console.log(korisnik.uloga._text);
    if (!korisnik) {
      return false;
    }
    return accessRoles.includes(korisnik.uloga._text);
  }
}
