import { Component, OnInit } from '@angular/core';
import {ObavestenjeService} from '../../core/services/obavestenje.service';
import * as xml from 'xml-js';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {AuthService} from '../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';

@Component({
  selector: 'app-pregled-odgovora',
  templateUrl: './pregled-obavestenja.component.html',
  styleUrls: ['./pregled-obavestenja.component.css']
})
export class PregledObavestenjaComponent implements OnInit {

  loading = false;
  tip: string;

  constructor(public obavestenjeService: ObavestenjeService,
              public authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private obavestenjeEditService: ObavestenjeEditService,
              private zahtevService: ZalbaCutanjeService) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(value => {
      if (value.tip === 'korisnikova-obavestenja') {
        this.obavestenjeService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {
          const z = (xml.xml2js(val, {compact: true}) as any).entityList.obavestenje;
          if (Array.isArray(z)) {
            this.obavestenjeService.obavestenja = z;
          } else {
            if (!z) {
              this.obavestenjeService.obavestenja = [];
            } else {
              this.obavestenjeService.obavestenja = [z];
            }
          }
          this.loading = false;
        });
      } else {
        this.obavestenjeService.getAll().subscribe(val => {
          const z = (xml.xml2js(val, {compact: true}) as any).entityList.obavestenje;
          if (Array.isArray(z)) {
            this.obavestenjeService.obavestenja = z;
          } else {
            if (!z) {
              this.obavestenjeService.obavestenja = [];
            } else {
              this.obavestenjeService.obavestenja = [z];
            }
          }
          this.loading = false;
        });
        this.tip = value.tip;
      }
    });
  }

  pregledajZahtev(idZahteva: string): void {
    this.router.navigate(['zahtev'], {queryParams: {zahtev: idZahteva}});
  }

  pregledajObavestenje(id: string): void {
    this.router.navigate(['obavestenje'], {queryParams: {obavestenje: id}});
  }

  generatePdf(zahtev: any): void {
    this.obavestenjeService.generatePdf(zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateXHTML(zahtev: any): void {
    this.obavestenjeService.generateXHTML(zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }
}
