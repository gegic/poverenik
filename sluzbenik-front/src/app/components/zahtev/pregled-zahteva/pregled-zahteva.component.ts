import {Component, OnInit} from '@angular/core';
import {ZahtevService} from '../../../core/services/zahtev.service';
import * as xml from 'xml-js';
import {AuthService} from '../../../core/services/auth.service';

@Component({
  selector: 'app-pregled-zahteva',
  templateUrl: './pregled-zahteva.component.html',
  styleUrls: ['./pregled-zahteva.component.css']
})
export class PregledZahtevaComponent implements OnInit {

  constructor(public zahtevService: ZahtevService,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.zahtevService.getAllByKorisnikId(this.authService.korisnik.getValue()._attributes.id).subscribe(val => {

      this.zahtevService.zahtevi = (xml.xml2js(val, {compact: true}) as any).entityList.zahtev;
    });
  }

}
