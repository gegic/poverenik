import { Component, OnInit } from '@angular/core';
import {ZahtevService} from '../../../core/services/zahtev.service';
import * as xml from 'xml-js'
@Component({
  selector: 'app-pregled-zahteva',
  templateUrl: './pregled-zahteva.component.html',
  styleUrls: ['./pregled-zahteva.component.css']
})
export class PregledZahtevaComponent implements OnInit {

  constructor(public zahtevService: ZahtevService) { }

  ngOnInit(): void {
    this.zahtevService.getAll().subscribe(val => {
      console.log(val);
    });
  }

}
