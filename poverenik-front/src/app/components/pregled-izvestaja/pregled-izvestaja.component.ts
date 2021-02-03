import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import * as xml from 'xml-js';
import {IzvestajService} from '../../core/services/izvestaj.service';

@Component({
  selector: 'app-pregled-izvestaja',
  templateUrl: './pregled-izvestaja.component.html',
  styleUrls: ['./pregled-izvestaja.component.css']
})
export class PregledIzvestajaComponent implements OnInit {


  loading = false;
  tip: string;

  constructor(public izvestajService: IzvestajService,
              public authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(value => {
      this.izvestajService.getAll().subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList.izvestaj;
        if (Array.isArray(z)) {
          this.izvestajService.izvestaji = z;
        } else {
          if (!z) {
            this.izvestajService.izvestaji = [];
          } else {
            this.izvestajService.izvestaji = [z];
          }
        }
        this.loading = false;
      });
    });
  }

  pregledajIzvestaj(idIzvestaja: string): void {
    this.router.navigate(['prikaz-izvestaja'], {queryParams: {izvestaj: idIzvestaja}});
  }

  generatePdf(izvestaj: any): void {
    this.izvestajService.generatePdf(izvestaj._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateXHTML(izvestaj: any): void {
    this.izvestajService.generateXHTML(izvestaj._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  getBrojZahteva(izvestaj: any): number {
    return parseInt(izvestaj['godisnja-statistika']._attributes['prihvaceni-zahtevi'], 10) +
      parseInt(izvestaj['godisnja-statistika']._attributes['odbijeni-zahtevi'], 10);
  }

  getBrojZalbi(izvestaj: any): number {
    return parseInt(izvestaj['godisnja-statistika']._attributes['zalbe-cutanje'], 10) +
      parseInt(izvestaj['godisnja-statistika']._attributes['zalbe-na-odluku'], 10);
  }
}
