import {Component, OnInit} from '@angular/core';
import {OverlayPanel} from 'primeng/overlaypanel';
import {MessageService} from 'primeng/api';
import {IzvestajService} from '../../core/services/izvestaj.service';
import * as xml from 'xml-js';
import {Router} from '@angular/router';

@Component({
  selector: 'app-podnosenje-izvestaja',
  templateUrl: './podnosenje-izvestaja.component.html',
  styleUrls: ['./podnosenje-izvestaja.component.css']
})
export class PodnosenjeIzvestajaComponent implements OnInit {

  traziociInformacija: any[] = [];
  dodavanjeTrazioca: string;

  constructor(private messageService: MessageService,
              public izvestajService: IzvestajService,
              private router: Router) { }

  ngOnInit(): void {
    this.izvestajService.getGodisnjaStatistika().subscribe(val => {
      this.izvestajService.godisnjaStatistika = (xml.xml2js(val, {compact: true}) as any)['godisnja-statistika'];
      console.log(this.izvestajService.godisnjaStatistika);
      if (!this.izvestajService.godisnjaStatistika) {
        this.router.navigate(['']);
      }
    });
  }

  dodajTrazioca(panel: OverlayPanel): void {
    if (this.traziociInformacija.some(t => t.naziv === this.dodavanjeTrazioca)) {
      this.messageService.add({severity: 'error', summary: 'Već postoji ovaj tražilac', detail: 'Tražilac sa ovim imenom je već dodat.'});
      return;
    }
    this.traziociInformacija.push({
      naziv: this.dodavanjeTrazioca,
      prihvaceniZahtevi: 0,
      odbijeniZahtevi: 0,
      zalbeCutanje: 0,
      zalbeNaOdluku: 0
    });
    this.dodavanjeTrazioca = '';
    panel.hide();
  }

  obrisiTrazioca(trazilac: any): void {
    this.traziociInformacija = this.traziociInformacija.filter(val => val.naziv !== trazilac.naziv);
    trazilac = {};
  }

  cellEdited(event: any): any {
    this.checkCells(event.field);
  }

  checkCells(cellName: string): void {
    const sum = this.traziociInformacija.reduce((old, current) => old + parseInt(current[cellName], 10), 0);
    const field = this.kebabize(cellName);
    if (sum > parseInt(this.izvestajService.godisnjaStatistika._attributes[field], 10)) {
      this.messageService.add({severity: 'error', summary: 'Neispravan unos', detail: 'Više nego što je u stvari odrađeno po statistici'});
      this.messageService.add({severity: 'info', summary: 'Ukupan broj', detail: `Ukupan broj je ${parseInt(this.izvestajService.godisnjaStatistika._attributes[field], 10)}`});

    }
  }

  kebabize(str: string): string {
    return str.split('').map((letter, idx) => {
      return letter.toUpperCase() === letter
        ? `${idx !== 0 ? '-' : ''}${letter.toLowerCase()}`
        : letter;
    }).join('');
  }

  camelize(str): string {
    const arr = str.split('-');
    const capital = arr.map((item, index) => index ? item.charAt(0).toUpperCase() + item.slice(1).toLowerCase() : item.toLowerCase());
    return capital.join('');
  }

  podnesi(): void {
    const cells = ['prihvaceniZahtevi', 'odbijeniZahtevi', 'zalbeCutanje', 'zalbeNaOdluku'];
    cells.forEach(cell => {
      this.checkCells(cell);
    });

    const izvestaj = {
      _declaration: {
        _attributes: {
          version: '1.0',
          encoding: 'utf-8'
        }
      },
      izvestaj: {
        'godisnja-statistika': this.izvestajService.godisnjaStatistika,
        'trazilac-informacije': []
      }
    };

    this.traziociInformacija.forEach(trazilac => {
      izvestaj.izvestaj['trazilac-informacije'].push({
        naziv: {_text: trazilac.naziv},
        zahtevi: {_attributes: {prihvaceni: trazilac.prihvaceniZahtevi, odbijeni: trazilac.odbijeniZahtevi}},
        zalbe: {_attributes: {cutanje: trazilac.zalbeCutanje, 'na-odluku': trazilac.zalbeNaOdluku}}
      });
    });

    const izvestajXml = xml.js2xml(izvestaj, {compact: true});
    console.log(izvestajXml);

    this.izvestajService.post(izvestajXml).subscribe(() => {
      this.messageService.add({severity: 'success', summary: 'Uspešno podnet', detail: 'Uspešno podnet izveštaj'});
      this.router.navigate(['']);
    });
  }
}
