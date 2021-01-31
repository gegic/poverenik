import {Component, OnInit} from '@angular/core';
import {ZahtevService} from '../../../core/services/zahtev.service';
import * as xml from 'xml-js';
import {AuthService} from '../../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {OdgovorEditService} from '../../../core/services/odgovor-edit.service';

@Component({
  selector: 'app-pregled-zahteva',
  templateUrl: './pregled-zahteva.component.html',
  styleUrls: ['./pregled-zahteva.component.css']
})
export class PregledZahtevaComponent implements OnInit {

  constructor(public zahtevService: ZahtevService,
              private authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private odgovorEditService: OdgovorEditService) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(value => {
      if (!value.neodgovoreni) {
        this.zahtevService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {
          const z = (xml.xml2js(val, {compact: true}) as any).entityList.zahtev;
          if (Array.isArray(z)) {
            this.zahtevService.zahtevi = z;
          } else {
            this.zahtevService.zahtevi = [z];
          }
        });
      } else {
        this.zahtevService.getAllNeodgovoreni().subscribe(val => {
          const z = (xml.xml2js(val, {compact: true}) as any).entityList.zahtev;
          console.log(z);
          if (Array.isArray(z)) {
            this.zahtevService.zahtevi = z;
          } else {
            this.zahtevService.zahtevi = [z];
          }
        });
      }
    });

  }

  odgovori(zahtev: any): void {
    this.odgovorEditService.zahtev.next(zahtev);
    this.router.navigate(['slanje-odgovora']);
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
