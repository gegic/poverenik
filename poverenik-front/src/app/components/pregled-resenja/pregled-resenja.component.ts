import {AfterViewInit, Component, OnInit} from '@angular/core';
import {ResenjeService} from '../../core/services/resenje.service';
import {AuthService} from '../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ResenjeEditService} from '../../core/services/resenje-edit.service';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import * as xml from 'xml-js';

@Component({
  selector: 'app-pregled-resenja',
  templateUrl: './pregled-resenja.component.html',
  styleUrls: ['./pregled-resenja.component.css']
})
export class PregledResenjaComponent implements OnInit {

  loading = false;
  tip: string;

  constructor(public resenjeService: ResenjeService,
              public authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private resenjeEditService: ResenjeEditService,
              private zalbaCutanjeService: ZalbaCutanjeService) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(value => {
      if (value.tip === 'korisnikova-resenja') {
        this.resenjeService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {
          const z = (xml.xml2js(val, {compact: true}) as any).entityList.resenje;
          if (Array.isArray(z)) {
            this.resenjeService.resenja = z;
          } else {
            if (!z) {
              this.resenjeService.resenja = [];
            } else {
              this.resenjeService.resenja = [z];
            }
          }
          this.loading = false;
        });
      } else {
        this.resenjeService.getAll().subscribe(val => {
          const z = (xml.xml2js(val, {compact: true}) as any).entityList.resenje;
          if (Array.isArray(z)) {
            this.resenjeService.resenja = z;
          } else {
            if (!z) {
              this.resenjeService.resenja = [];
            } else {
              this.resenjeService.resenja = [z];
            }
          }
          this.loading = false;
        });
        this.tip = value.tip;
      }
    });
  }

  pregledajZalbu(idZalbe: string, tipZalbe: string): void {
    if (tipZalbe === 'na-odluku') {
      this.router.navigate(['zalba-na-odluku'], {queryParams: {zalbaNaOdluku: idZalbe}});
    } else {
      this.router.navigate(['zalba-cutanje'], {queryParams: {zalbaCutanje: idZalbe}});
    }
  }

  pregledajResenje(id: string): void {
    console.log(id);
    this.router.navigate(['resenje'], {queryParams: {resenje: id}});
  }

  generatePdf(zahtev: any): void {
    this.resenjeService.generatePdf(zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  generateXHTML(zahtev: any): void {
    this.resenjeService.generateXHTML(zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

}
