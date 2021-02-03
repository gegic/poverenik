import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../../core/services/auth.service';
import {ObavestenjeService} from '../../core/services/obavestenje.service';
import * as xml from 'xml-js';
import {IzvestajService} from '../../core/services/izvestaj.service';

@Component({
  selector: 'app-prikaz-izvestaja',
  templateUrl: './prikaz-izvestaja.component.html',
  styleUrls: ['./prikaz-izvestaja.component.css']
})
export class PrikazIzvestajaComponent implements OnInit {

  izvestaj: any;
  traziociInformacije: any[];

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              public izvestajService: IzvestajService,
              public authService: AuthService) { }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(val => {
      if (!val.izvestaj) {
        this.router.navigate(['']);
      } else {
        this.izvestajService.getById(val.izvestaj).subscribe(izvestaj => {
          this.izvestaj = (xml.xml2js(izvestaj, {compact: true}) as any).izvestaj;
          if (Array.isArray(this.izvestaj['trazilac-informacije'])) {
            this.traziociInformacije = this.izvestaj['trazilac-informacije'];
          } else {
            this.traziociInformacije = [this.izvestaj['trazilac-informacije']];
          }

        });
      }
    });
  }

  generatePdf(): void {
    this.izvestajService.generatePdf(this.izvestaj._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateXHTML(): void {
    this.izvestajService.generateXHTML(this.izvestaj._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  getZbirPrihvacenih(): number {
    return this.traziociInformacije.reduce((old, curr) => old + parseInt(curr.zahtevi._attributes.prihvaceni, 10), 0);
  }

  getZbirOdbijenih(): number {
    return this.traziociInformacije.reduce((old, curr) => old + parseInt(curr.zahtevi._attributes.odbijeni, 10), 0);
  }

  getZbirCutanje(): number {
    return this.traziociInformacije.reduce((old, curr) => old + parseInt(curr.zalbe._attributes.cutanje, 10), 0);
  }

  getZbirNaOdluku(): number {
    return this.traziociInformacije.reduce((old, curr) => old + parseInt(curr.zalbe._attributes['na-odluku'], 10), 0);
  }

}
