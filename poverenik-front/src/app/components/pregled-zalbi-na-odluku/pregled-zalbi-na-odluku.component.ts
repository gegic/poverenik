import {Component, OnInit} from '@angular/core';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';
import {ZalbaNaOdlukuService} from '../../core/services/zalba-na-odluku.service';

@Component({
  selector: 'app-pregled-zalbi-na-odluku',
  templateUrl: './pregled-zalbi-na-odluku.component.html',
  styleUrls: ['./pregled-zalbi-na-odluku.component.css']
})
export class PregledZalbiNaOdlukuComponent implements OnInit {

  loading = false;
  tip: string;

  constructor(public zalbaNaOdlukuService: ZalbaNaOdlukuService,
              public authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(value => {
      this.getZalbeNaOdluku(value.tip);
      this.tip = value.tip;
    });

  }

  getZalbeNaOdluku(tip: string): void {
    if (tip === 'korisnikove-zalbe') {
      this.zalbaNaOdlukuService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList['zalba-na-odluku'];
        if (Array.isArray(z)) {
          this.zalbaNaOdlukuService.zalbeNaOdluku = z;
        } else {
          if (!z) {
            this.zalbaNaOdlukuService.zalbeNaOdluku = [];
          } else {
            this.zalbaNaOdlukuService.zalbeNaOdluku = [z];
          }
        }
        this.loading = false;
      });
    } else if (tip === 'neresene-zalbe') {
      this.zalbaNaOdlukuService.getAllNeresene().subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList['zalba-na-odluku'];
        if (Array.isArray(z)) {
          this.zalbaNaOdlukuService.zalbeNaOdluku = z;
        } else {
          if (!z) {
            this.zalbaNaOdlukuService.zalbeNaOdluku = [];
          } else {
            this.zalbaNaOdlukuService.zalbeNaOdluku = [z];
          }
        }
        this.loading = false;
      });
    } else if (tip === 'sve-zalbe') {
      this.zalbaNaOdlukuService.getAll().subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList['zalba-na-odluku'];
        if (Array.isArray(z)) {
          this.zalbaNaOdlukuService.zalbeNaOdluku = z;
        } else {
          if (!z) {
            this.zalbaNaOdlukuService.zalbeNaOdluku = [];
          } else {
            this.zalbaNaOdlukuService.zalbeNaOdluku = [z];
          }
        }
        this.loading = false;
      });
    }
  }

  resi(zalbaNaOdluku: any): void {
    // this.odgovorEditService.zalbaNaOdluku.next(zalbaNaOdluku);
    // this.router.navigate(['slanje-odgovora']);
  }

  generatePdf(zalbaNaOdluku: any): void {
    this.zalbaNaOdlukuService.generatePdf(zalbaNaOdluku._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  generateXHTML(zalbaNaOdluku: any): void {
    this.zalbaNaOdlukuService.generateXHTML(zalbaNaOdluku._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  detalji(zalbaNaOdluku: any): void {
    this.router.navigate(['zalba-na-odluku'], {queryParams: {zalbaNaOdluku: zalbaNaOdluku._attributes.id}});
  }

  odbij(id: any): void {
    // this.zalbaNaOdlukuService.odbij(id).subscribe(() => {
    //   this.getzalbaNaOdlukui(this.tip);
    // });
  }

}
