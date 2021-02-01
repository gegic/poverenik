import { Component, OnInit } from '@angular/core';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {AuthService} from '../../core/services/auth.service';
import * as xml from 'xml-js';
import {ActivatedRoute, Router} from '@angular/router';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-izbor-zahteva',
  templateUrl: './izbor-zahteva.component.html',
  styleUrls: ['./izbor-zahteva.component.css']
})
export class IzborZahtevaComponent implements OnInit {

  loading = false;

  neodgovoreniZahtevi: any[];
  izabranZahtev: any = null;
  tip: string;

  constructor(private zalbaCutanjeService: ZalbaCutanjeService,
              public authService: AuthService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private messageService: MessageService) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.data.subscribe(val => {
      if (!val.tip) {
        this.router.navigate(['']);
      } else if (val.tip === 'neodgovoren') {
        this.getNeodgovoreniZahtevi();
      } else if (val.tip === 'odbijen') {
        this.getOdbijeniZahtevi();
      }
      this.tip = val.tip;
    });
  }

  getNeodgovoreniZahtevi(): void {
    this.zalbaCutanjeService.getAllNeodgovoreniZahtevi(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {
      const element = (xml.xml2js(val, {compact: true}) as any);

      if (!element['lista-zahteva'].zahtev) {
        this.neodgovoreniZahtevi = [];
      } else {
        const zahtev = element['lista-zahteva'].zahtev;
        if (Array.isArray(zahtev)) {
          this.neodgovoreniZahtevi = zahtev;
        } else {
          this.neodgovoreniZahtevi = [zahtev];
        }
      }
      this.loading = false;
    });

  }

  getOdbijeniZahtevi(): void {

  }

  zahtevIzabran(): void {
    if (!this.izabranZahtev) {
      this.messageService.add({severity: 'error', summary: 'Zahtev nije izabran', detail: 'Molimo izaberite zahtev'});
    }
    if (this.tip === 'neodgovoren') {
      this.zalbaCutanjeService.zahtev = this.izabranZahtev;
      this.router.navigate(['podnosenje-zalbe-cutanje']);
    }
  }

}
