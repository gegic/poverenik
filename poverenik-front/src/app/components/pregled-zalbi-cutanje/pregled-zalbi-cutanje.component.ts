import {Component, OnInit} from '@angular/core';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';

@Component({
  selector: 'app-pregled-zalbi-cutanje',
  templateUrl: './pregled-zalbi-cutanje.component.html',
  styleUrls: ['./pregled-zalbi-cutanje.component.css']
})
export class PregledZalbiCutanjeComponent implements OnInit {

  loading = false;
  tip: string;

  constructor(public zalbaCutanjeService: ZalbaCutanjeService,
              public authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(value => {
      this.getZalbeCutanje(value.tip);
      this.tip = value.tip;
    });

  }

  getZalbeCutanje(tip: string): void {
    if (tip === 'korisnikove-zalbe') {
      this.zalbaCutanjeService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList['zalba-cutanje'];
        if (Array.isArray(z)) {
          this.zalbaCutanjeService.zalbeCutanje = z;
        } else {
          if (!z) {
            this.zalbaCutanjeService.zalbeCutanje = [];
          } else {
            this.zalbaCutanjeService.zalbeCutanje = [z];
          }
        }
        this.loading = false;
      });
    } else if (tip === 'neresene-zalbe') {
      this.zalbaCutanjeService.getAllNeresene().subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList.zalbaCutanje;
        if (Array.isArray(z)) {
          this.zalbaCutanjeService.zalbeCutanje = z;
        } else {
          if (!z) {
            this.zalbaCutanjeService.zalbeCutanje = [];
          } else {
            this.zalbaCutanjeService.zalbeCutanje = [z];
          }
        }
        this.loading = false;
      });
    } else if (tip === 'sve-zalbe') {
      this.zalbaCutanjeService.getAll().subscribe(val => {
        const z = (xml.xml2js(val, {compact: true}) as any).entityList.zalbaCutanje;
        if (Array.isArray(z)) {
          this.zalbaCutanjeService.zalbeCutanje = z;
        } else {
          if (!z) {
            this.zalbaCutanjeService.zalbeCutanje = [];
          } else {
            this.zalbaCutanjeService.zalbeCutanje = [z];
          }
        }
        this.loading = false;
      });
    }
  }

  resi(zalbaCutanje: any): void {
    // this.odgovorEditService.zalbaCutanje.next(zalbaCutanje);
    // this.router.navigate(['slanje-odgovora']);
  }

  generatePdf(zalbaCutanje: any): void {
    this.zalbaCutanjeService.generatePdf(zalbaCutanje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  generateXHTML(zalbaCutanje: any): void {
    this.zalbaCutanjeService.generateXHTML(zalbaCutanje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  detalji(zalbaCutanje: any): void {
    this.router.navigate(['zalba-cutanje'], {queryParams: {zalbaCutanje: zalbaCutanje._attributes.id}});
  }

  odbij(id: any): void {
    // this.zalbaCutanjeService.odbij(id).subscribe(() => {
    //   this.getzalbaCutanjei(this.tip);
    // });
  }

}
