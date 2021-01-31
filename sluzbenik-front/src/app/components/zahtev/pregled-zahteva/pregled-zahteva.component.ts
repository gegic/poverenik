import {Component, OnInit} from '@angular/core';
import {ZahtevService} from '../../../core/services/zahtev.service';
import * as xml from 'xml-js';
import {AuthService} from '../../../core/services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-pregled-zahteva',
  templateUrl: './pregled-zahteva.component.html',
  styleUrls: ['./pregled-zahteva.component.css']
})
export class PregledZahtevaComponent implements OnInit {

  constructor(public zahtevService: ZahtevService,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
    this.zahtevService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {

      this.zahtevService.zahtevi = (xml.xml2js(val, {compact: true}) as any).entityList.zahtev;
    });
  }

  generatePdf(zahtev: any): void {
    this.zahtevService.generatePdf(zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateXHTML(zahtev: any): void {
    this.zahtevService.generateXHTML(zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

}
