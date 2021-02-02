import {Component, OnInit} from '@angular/core';
import {ZahtevService} from '../../core/services/zahtev.service';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';
import {ObavestenjeService} from '../../core/services/obavestenje.service';

@Component({
  selector: 'app-pregled-zahteva',
  templateUrl: './pregled-zahteva.component.html',
  styleUrls: ['./pregled-zahteva.component.css']
})
export class PregledZahtevaComponent implements OnInit {

  loading = false;
  tip: string;

  constructor(public zahtevService: ZahtevService,
              public authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private obavestenjeService: ObavestenjeService) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(value => {
      this.getZahtevi(value.tip);
      this.tip = value.tip;
    });

  }

  getZahtevi(tip: string): void {
    if (tip === 'korisnikovi-zahtevi') {
      this.zahtevService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList.zahtev;
        if (Array.isArray(z)) {
          this.zahtevService.zahtevi = z;
        } else {
          if (!z) {
            this.zahtevService.zahtevi = [];
          } else {
            this.zahtevService.zahtevi = [z];
          }
        }
        this.loading = false;
      });
    } else if (tip === 'neodgovoreni-zahtevi'){
      this.zahtevService.getAllNeodgovoreni().subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList.zahtev;
        if (Array.isArray(z)) {
          this.zahtevService.zahtevi = z;
        } else {
          if (!z) {
            this.zahtevService.zahtevi = [];
          } else {
            this.zahtevService.zahtevi = [z];
          }
        }
        this.loading = false;
      });
    } else if (tip === 'svi-zahtevi') {
      this.zahtevService.getAll().subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList.zahtev;
        if (Array.isArray(z)) {
          this.zahtevService.zahtevi = z;
        } else {
          if (!z) {
            this.zahtevService.zahtevi = [];
          } else {
            this.zahtevService.zahtevi = [z];
          }
        }
        this.loading = false;
      });
    }
  }
  prihvati(zahtev: any): void {
    this.obavestenjeService.zahtev.next(zahtev);
    this.router.navigate(['prihvatanje']);
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

  detalji(zahtev: any): void {
    this.router.navigate(['zahtev'], {queryParams: {zahtev: zahtev._attributes.id}});
  }

  odbij(zahtev: any): void {
    this.obavestenjeService.zahtev.next(zahtev);
    this.router.navigate(['odbijanje']);
  }

}
