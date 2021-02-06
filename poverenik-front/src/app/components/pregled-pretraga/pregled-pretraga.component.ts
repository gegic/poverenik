import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {MessageService} from 'primeng/api';
import {PretragaService} from '../../core/services/pretraga.service';
import * as xml from 'xml-js';
import {ResenjeService} from '../../core/services/resenje.service';
import {Router} from '@angular/router';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {ZalbaNaOdlukuService} from '../../core/services/zalba-na-odluku.service';

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
              private resenjeService: ResenjeService,
              private zalbaCutanjeService: ZalbaCutanjeService,
              private zalbaNaOdlukuService: ZalbaNaOdlukuService,
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
    this.pretragaService.naprednaPretragaResenja(this.upit.value).subscribe(resenjaXml => {
      const ob = (xml.xml2js(resenjaXml, {compact: true}) as any).entityList.resenje;
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
          id: o._attributes.id,
          podnosilac: o.podnosilac['ime-prezime']._text,
          organ: o.organ.naziv._text,
          zahtev: o.zahtev._attributes.id,
          element: o
        };
      }));
      this.resultsSet = true;
    });
  }

  generateXHTML(rezultat: any): void {
    if (rezultat.tip === 'zalba-na-odluku') {
      this.zalbaNaOdlukuService.generateXHTML(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    } else if (rezultat.tip === 'zalba-cutanje') {
      this.zalbaCutanjeService.generateXHTML(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    } else {
      this.resenjeService.generateXHTML(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    }
  }

  generatePdf(rezultat: any): void {
    if (rezultat.tip === 'zalba-na-odluku') {
      this.zalbaNaOdlukuService.generatePdf(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    } else if (rezultat.tip === 'zalba-cutanje') {
      this.zalbaCutanjeService.generatePdf(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    } else {
      this.resenjeService.generatePdf(rezultat.id).subscribe(val => {
        window.location.href = `http://localhost:4201/${val}`;
      });
    }
  }

  detalji(rezultat: any): void {
    if (rezultat.tip === 'zalba-na-odluku') {
      this.router.navigate(['zalba-na-odluku'], {queryParams: {zalbaNaOdluku: rezultat.id}});

    } else if (rezultat.tip === 'zalba-cutanje') {
      this.router.navigate(['zalba-cutanje'], {queryParams: {zalbaCutanje: rezultat.id}});

    } else {
      this.router.navigate(['resenje'], {queryParams: {resenje: rezultat.id}});

    }
  }

  otvoriReferenciranuZalbu(rezultat: any): void {
    if (rezultat.podtip === 'cutanje') {
      this.router.navigate(['zalba-cutanje'], {queryParams: {zalbaCutanje: rezultat.zalba}});
    } else {
      this.router.navigate(['zalba-na-odluku'], {queryParams: {zalbaNaOdluku: rezultat.zalba}});
    }
  }

  obicnaPretraga(): void {
    this.rezultati = [];
    this.loading = true;
    this.pretragaService.pretragaResenja(this.upit.value).subscribe(resenjaXml => {
      const ob = (xml.xml2js(resenjaXml, {compact: true}) as any).entityList.resenje;
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
      this.pretragaZalbiCutanje();
    });
  }

  pretragaZalbiCutanje(): void {
    this.pretragaService.pretragaZalbiCutanje(this.upit.value).subscribe(zalbeXml => {
      const ob = (xml.xml2js(zalbeXml, {compact: true}) as any).entityList['zalba-cutanje'];
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
      this.pretragaZalbiNaOdluku();
    });
  }

  pretragaZalbiNaOdluku(): void {
    this.pretragaService.pretragaZalbiNaOdluku(this.upit.value).subscribe(zalbeXml => {
      const ob = (xml.xml2js(zalbeXml, {compact: true}) as any).entityList['zalba-na-odluku'];
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
      this.resultsSet = true;
      this.loading = false;
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
