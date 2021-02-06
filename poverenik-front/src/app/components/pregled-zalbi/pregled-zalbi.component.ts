import {Component, OnDestroy, OnInit} from '@angular/core';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ResenjeEditService} from '../../core/services/resenje-edit.service';
import {ZalbaNaOdlukuService} from '../../core/services/zalba-na-odluku.service';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {ResenjeService} from '../../core/services/resenje.service';

@Component({
  selector: 'app-pregled-zalbi-na-odluku',
  templateUrl: './pregled-zalbi.component.html',
  styleUrls: ['./pregled-zalbi.component.css']
})
export class PregledZalbiComponent implements OnInit, OnDestroy {

  // ako ima protiv.donosilac -> zalba na odluku
  loading = false;
  tip: string;
  zalbe: any[] = [];

  constructor(public zalbaNaOdlukuService: ZalbaNaOdlukuService,
              public zalbaCutanjeService: ZalbaCutanjeService,
              public authService: AuthService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private resenjeService: ResenjeService,
              private editService: ResenjeEditService) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(value => {
      this.getZalbeNaOdluku(value.tip);
      this.tip = value.tip;
    });

  }

  getZalbeNaOdluku(tip: string): void {
    if (tip === 'korisnikove-zalbe') {
      this.zalbaNaOdlukuService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(zcXml => {
        const zalbaNaOdluku = (xml.xml2js(zcXml, {compact: true}) as any).entityList['zalba-na-odluku'];
        if (Array.isArray(zalbaNaOdluku)) {
          this.zalbe = this.zalbe.concat(zalbaNaOdluku);
        } else {
          if (!!zalbaNaOdluku) {
            this.zalbe = this.zalbe.concat([zalbaNaOdluku]);
          }
        }
        this.zalbaCutanjeService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(znoXml => {
          const zalbaCutanje = (xml.xml2js(znoXml, {compact: true}) as any).entityList['zalba-cutanje'];
          if (Array.isArray(zalbaCutanje)) {
            this.zalbe = this.zalbe.concat(zalbaCutanje);
          } else {
            if (!!zalbaCutanje) {
              this.zalbe = this.zalbe.concat([zalbaCutanje]);
            }
            this.loading = false;
          }
        });
      });
    } else if (tip === 'neresene-zalbe') {
      this.zalbaNaOdlukuService.getAllNeresene().subscribe(zcXml => {
        const zalbaNaOdluku = (xml.xml2js(zcXml, {compact: true}) as any).entityList['zalba-na-odluku'];
        if (Array.isArray(zalbaNaOdluku)) {
          this.zalbe = this.zalbe.concat(zalbaNaOdluku);
        } else {
          if (!!zalbaNaOdluku) {
            this.zalbe = this.zalbe.concat([zalbaNaOdluku]);
          }
        }
        this.zalbaCutanjeService.getAllNeresene().subscribe(znoXml => {
          const zalbaCutanje = (xml.xml2js(znoXml, {compact: true}) as any).entityList['zalba-cutanje'];
          if (Array.isArray(zalbaCutanje)) {
            this.zalbe = this.zalbe.concat(zalbaCutanje);
          } else {
            if (!!zalbaCutanje) {
              this.zalbe = this.zalbe.concat([zalbaCutanje]);
            }
            this.loading = false;
          }
        });
      });
    } else if (tip === 'sve-zalbe') {

      this.zalbaNaOdlukuService.getAll().subscribe(zcXml => {
        const zalbaNaOdluku = (xml.xml2js(zcXml, {compact: true}) as any).entityList['zalba-na-odluku'];
        if (Array.isArray(zalbaNaOdluku)) {
          this.zalbe = this.zalbe.concat(zalbaNaOdluku);
        } else {
          if (!!zalbaNaOdluku) {
            this.zalbe = this.zalbe.concat([zalbaNaOdluku]);
          }
        }
        this.zalbaCutanjeService.getAll().subscribe(znoXml => {
          const zalbaCutanje = (xml.xml2js(znoXml, {compact: true}) as any).entityList['zalba-cutanje'];
          if (Array.isArray(zalbaCutanje)) {
            this.zalbe = this.zalbe.concat(zalbaCutanje);
          } else {
            if (!!zalbaCutanje) {
              this.zalbe = this.zalbe.concat([zalbaCutanje]);
            }
            this.loading = false;
          }
        });
      });
    }
  }

  prihvati(zalba: any): void {
    this.editService.tip = 'prihvatanje';
    this.resenjeService.getOdgovor(zalba._attributes.id).subscribe(() => {
      this.resenjeService.odgovor = true;
      this.resenjeService.zalba = zalba;
      this.router.navigate(['prihvatanje']);
    }, () => {
      this.resenjeService.odgovor = false;
      this.resenjeService.zalba = zalba;
      this.router.navigate(['prihvatanje']);
    });
  }

  generatePdf(zalba: any): void {
    if (!zalba.protiv.donosilac) {
      this.zalbaCutanjeService.generateXHTML(zalba._attributes.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    } else {
      this.zalbaNaOdlukuService.generatePdf(zalba._attributes.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    }
  }

  generateXHTML(zalba: any): void {
    if (!zalba.protiv.donosilac) {
      this.zalbaCutanjeService.generateXHTML(zalba._attributes.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    } else {
      this.zalbaNaOdlukuService.generateXHTML(zalba._attributes.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    }
  }

  detalji(zalba: any): void {
    if (!zalba.protiv.donosilac) {
      this.router.navigate(['zalba-cutanje'], {queryParams: {zalbaCutanje: zalba._attributes.id}});
    } else {
      this.router.navigate(['zalba-na-odluku'], {queryParams: {zalbaNaOdluku: zalba._attributes.id}});
    }
  }

  odbij(zalba: any): void {
    this.editService.tip = 'odbijanje';
    this.resenjeService.getOdgovor(zalba._attributes.id).subscribe(() => {
      this.resenjeService.odgovor = true;
      this.resenjeService.zalba = zalba;
      this.router.navigate(['odbijanje']);
    }, () => {
      this.resenjeService.odgovor = false;
      this.resenjeService.zalba = zalba;
      this.router.navigate(['odbijanje']);
    });

  }

  otvoriReferenciraniZahtev(rezultat: any): void {
    this.router.navigate(['zahtev'], {queryParams: {zahtev: rezultat.id}});
  }

  otvoriReferenciranoObavestenje(rezultat: any): void {
    this.router.navigate(['obavestenje'], {queryParams: {obavestenje: rezultat.id}});
  }

  ngOnDestroy(): void {
    this.zalbe = [];
  }

}
