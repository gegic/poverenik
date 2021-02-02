import {Component, OnInit, ViewChild} from '@angular/core';
import {IzjasnjenjeService} from '../../core/services/izjasnjenje.service';
import * as xml from 'xml-js';
import {Router} from '@angular/router';
import {OverlayPanel} from 'primeng/overlaypanel';
import {OdgovorElement} from '../../core/model/odgovor-element';

@Component({
  selector: 'app-izjasnjenja',
  templateUrl: './izjasnjenja.component.html',
  styleUrls: ['./izjasnjenja.component.css']
})
export class IzjasnjenjaComponent implements OnInit {

  @ViewChild('op') panel: OverlayPanel;
  loading = false;
  tekstOdgovora: string;
  izabranoIzjasnjenje: any;

  constructor(public izjasnjenjeService: IzjasnjenjeService,
              private router: Router) { }

  ngOnInit(): void {
    this.loading = true;
    this.getIzjasnjenja();
  }

  getIzjasnjenja(): void {
    this.izjasnjenjeService.getAll().subscribe(val => {
      const z = (xml.xml2js(val, {compact: true}) as any).entityList.izjasnjenje;
      if (Array.isArray(z)) {
        this.izjasnjenjeService.izjasnjenja = z;
      } else {
        if (!z) {
          this.izjasnjenjeService.izjasnjenja = [];
        } else {
          this.izjasnjenjeService.izjasnjenja = [z];
        }
      }
      this.loading = false;
    });
  }
  vidiZahtev(izjasnjenje: any): void {
    this.router.navigate(['zahtev'], {queryParams: {zahtev: izjasnjenje._attributes['id-zahteva']}});
  }

  odgovori(): void {
    const odgovor: OdgovorElement = {
      _declaration: {
        _attributes: {
          version: '1.0',
          encoding: 'utf-8'
        }
      },
      'odgovor-izjasnjenje': {
        _attributes: {
          'id-zalbe': this.izabranoIzjasnjenje._attributes['id-zalbe'],
          'tip-zalbe': this.izabranoIzjasnjenje._attributes['tip-zalbe']
        },
        _text: this.tekstOdgovora
      }
    };
    const odgovorXml = xml.js2xml(odgovor, {compact: true});
    this.izjasnjenjeService.odgovori(this.izabranoIzjasnjenje._attributes.id, odgovorXml).subscribe(() => {
      this.tekstOdgovora = '';
      this.izabranoIzjasnjenje = null;
      this.panel.hide();
      this.getIzjasnjenja();
    });

  }

  otvoriPanel(event: any, izjasnjenje: any): void {
    this.izabranoIzjasnjenje = izjasnjenje;
    this.panel.toggle(event);
  }

}
