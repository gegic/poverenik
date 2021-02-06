import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {MessageService} from 'primeng/api';
import {PretragaService} from '../../core/services/pretraga.service';
import * as xml from 'xml-js';
import {ZahtevService} from '../../core/services/zahtev.service';
import {ObavestenjeService} from '../../core/services/obavestenje.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-pregled-pretraga',
  templateUrl: './pregled-pretraga.component.html',
  styleUrls: ['./pregled-pretraga.component.css']
})
export class PregledPretragaComponent implements OnInit {

  rezultati: any[] = [];
  resultsSet = false;
  upit: FormControl = new FormControl('');
  loading = false;
  napredno = false;

  constructor(private messageService: MessageService,
              private pretragaService: PretragaService,
              private zahtevService: ZahtevService,
              private obavestenjeService: ObavestenjeService,
              private router: Router) { }

  ngOnInit(): void {
  }

  search(): void {
    if (!this.upit.value) {
      this.messageService.add({severity: 'error', summary: 'Nema upita', detail: 'Potrebno je uneti upit.'});
      this.resultsSet = false;
      return;
    }
    if (!this.napredno) {
      this.obicnaPretraga();
    } else {
      this.naprednaPretraga();
    }
  }

  naprednaPretraga(): void {
    this.rezultati = [];
    this.loading = true;
    this.pretragaService.naprednaPretragaObavestenja(this.upit.value).subscribe(obavestenjaXml => {
      const ob = (xml.xml2js(obavestenjaXml, {compact: true}) as any).entityList.obavestenje;
      let obavestenja: any[];
      if (Array.isArray(ob)) {
        obavestenja = ob;
      } else {
        if (!ob) {
          obavestenja = [];
        } else {
          obavestenja = [ob];
        }
      }
      this.rezultati = this.rezultati.concat(obavestenja.map(o => {
        return {
          tip: 'obavestenje',
          id: o._attributes.id,
          podnosilac: o.podnosilac['ime-prezime']._text,
          organ: o.organ.naziv._text,
          zahtev: o.zahtev._attributes.id,
          element: o
        };
      }));
      this.naprednaPretragaZahteva()
    });
  }

  naprednaPretragaZahteva(): void {
    this.pretragaService.naprednaPretragaZahteva(this.upit.value).subscribe(zahteviXml => {
      const za = (xml.xml2js(zahteviXml, {compact: true}) as any).entityList.zahtev;
      let zahtevi: any[] = [];
      if (Array.isArray(za)) {
        zahtevi = za;
      } else {
        if (!za) {
          zahtevi = [];
        } else {
          zahtevi = [za];
        }
      }
      this.rezultati = this.rezultati.concat(zahtevi.map(o => {
        return {
          tip: 'zahtev',
          id: o._attributes.id,
          podnosilac: o['trazilac-informacije']['ime-prezime']._text,
          organ: o.organ.naziv._text,
          element: o
        };
      }));
      this.loading = false;
      this.resultsSet = true;
      if (this.upit.value.includes('pred:zahtev')) {
        this.naprednaPretragaZalbiCutanje();
      } else if (this.upit.value.includes('pred:obavestenje')) {
        this.naprednaPretragaZalbiNaOdluku();
      }
    });
  }

  naprednaPretragaResenja(): void {
    this.pretragaService.naprednaPretragaResenja(this.upit.value).subscribe(resenjaXml => {
      const ob = (xml.xml2js(resenjaXml, {compact: true}) as any)['lista-resenja'].resenje;
      let resenja: any[];
      if (Array.isArray(ob)) {
        resenja = ob;
      } else {
        if (!ob) {
          resenja = [];
        } else {
          resenja = [ob];
        }
      }
      this.rezultati = this.rezultati.concat(resenja.map(o => {
        return {
          tip: 'resenje',
          podtip: o.zalba._attributes.tip,
          id: o._attributes.id,
          podnosilac: o.zalilac['ime-prezime']._text,
          organ: o.protiv.naziv._text,
          zahtev: o.zahtev._attributes.id,
          zalba: o.zalba._attributes.id,
          obavestenje: !o.zalba.obavestenje ? undefined : o.zalba.obavestenje._attributes.id,
          element: o
        };
      }));
    });
  }

  naprednaPretragaZalbiCutanje(): void {
    this.pretragaService.naprednaPretragaZalbiCutanje(this.upit.value).subscribe(zalbeXml => {
      const ob = (xml.xml2js(zalbeXml, {compact: true}) as any)['lista-zalbi-cutanje']['zalba-cutanje'];
      let zalbe: any[];
      if (Array.isArray(ob)) {
        zalbe = ob;
      } else {
        if (!ob) {
          zalbe = [];
        } else {
          zalbe = [ob];
        }
      }
      this.rezultati = this.rezultati.concat(zalbe.map(o => {
        return {
          tip: 'zalba-cutanje',
          id: o._attributes.id,
          podnosilac: o.podnosilac['ime-prezime']._text,
          organ: o.protiv.naziv._text,
          zahtev: o.zahtev._attributes.id,
          element: o
        };
      }));
      this.naprednaPretragaZalbiNaOdluku();
    });
  }

  naprednaPretragaZalbiNaOdluku(): void {
    this.pretragaService.naprednaPretragaZalbiNaOdluku(this.upit.value).subscribe(zalbeXml => {
      const ob = (xml.xml2js(zalbeXml, {compact: true}) as any)['lista-zalbi-na-odluku']['zalba-na-odluku'];
      let zalbe: any[];
      if (Array.isArray(ob)) {
        zalbe = ob;
      } else {
        if (!ob) {
          zalbe = [];
        } else {
          zalbe = [ob];
        }
      }
      this.rezultati = this.rezultati.concat(zalbe.map(o => {
        return {
          tip: 'zalba-na-odluku',
          id: o._attributes.id,
          podnosilac: o.podnosilac['ime-prezime']._text,
          organ: o.protiv.donosilac.naziv._text,
          obavestenje: o.protiv._attributes.id,
          zahtev: o.zahtev._attributes.id,
          element: o
        };
      }));
      this.naprednaPretragaResenja();
    });
  }

  generateXHTML(rezultat: any): void {
    if (rezultat.tip === 'zahtev') {
      this.zahtevService.generateXHTML(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4200/${val}`;
      });
    } else {
      this.obavestenjeService.generateXHTML(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4200/${val}`;
      });
    }
  }

  generatePdf(rezultat: any): void {
    if (rezultat.tip === 'zahtev') {
      this.zahtevService.generatePdf(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4200/${val}`;
      });
    } else {
      this.obavestenjeService.generatePdf(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4200/${val}`;
      });
    }
  }

  detalji(rezultat: any): void {
    if (rezultat.tip === 'obavestenje') {
      this.router.navigate(['obavestenje'], {queryParams: {obavestenje: rezultat.id}});
    } else {
      this.router.navigate(['zahtev'], {queryParams: {zahtev: rezultat.id}});
    }
  }

  otvoriReferenciraniZahtev(rezultat: any): void {
    this.router.navigate(['zahtev'], {queryParams: {zahtev: rezultat.zahtev}});
  }

  obicnaPretraga(): void {
    this.rezultati = [];
    this.loading = true;
    this.pretragaService.pretragaObavestenja(this.upit.value).subscribe(obavestenjaXml => {
      const ob = (xml.xml2js(obavestenjaXml, {compact: true}) as any).entityList.obavestenje;
      let obavestenja: any[];
      if (Array.isArray(ob)) {
        obavestenja = ob;
      } else {
        if (!ob) {
          obavestenja = [];
        } else {
          obavestenja = [ob];
        }
      }
      this.rezultati = this.rezultati.concat(obavestenja.map(o => {
        return {
          tip: 'obavestenje',
          id: o._attributes.id,
          podnosilac: o.podnosilac['ime-prezime']._text,
          organ: o.organ.naziv._text,
          zahtev: o.zahtev._attributes.id,
          element: o
        };
      }));
      this.pretragaService.pretragaZahteva(this.upit.value).subscribe(zahteviXml => {
        const za = (xml.xml2js(zahteviXml, {compact: true}) as any).entityList.zahtev;
        let zahtevi: any[] = [];
        if (Array.isArray(za)) {
          zahtevi = za;
        } else {
          if (!za) {
            zahtevi = [];
          } else {
            zahtevi = [za];
          }
        }
        this.rezultati = this.rezultati.concat(zahtevi.map(o => {
          return {
            tip: 'zahtev',
            id: o._attributes.id,
            podnosilac: o['trazilac-informacije']['ime-prezime']._text,
            organ: o.organ.naziv._text,
            element: o
          };
        }));
        this.loading = false;
      });
      this.resultsSet = true;
    });
  }

  copyId(rezultat): void {
    const selBox = document.createElement('textarea');
    selBox.style.position = 'fixed';
    selBox.style.left = '0';
    selBox.style.top = '0';
    selBox.style.opacity = '0';
    selBox.value = rezultat.id;
    document.body.appendChild(selBox);
    selBox.focus();
    selBox.select();
    document.execCommand('copy');
    document.body.removeChild(selBox);
    this.messageService.add({severity: 'info', summary: 'Kopirano', detail: `Vrijednost ${rezultat.id} je kopirana`});
  }
}
