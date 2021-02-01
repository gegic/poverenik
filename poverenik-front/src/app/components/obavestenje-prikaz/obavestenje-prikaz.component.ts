import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import * as xml from 'xml-js';
import {ActivatedRoute, Router} from '@angular/router';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {ZalbaCutanjeEditService} from '../../core/services/zalba-cutanje-edit.service';
import {ObavestenjeService} from '../../core/services/obavestenje.service';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';

@Component({
  selector: 'app-obavestenje-prikaz',
  templateUrl: './obavestenje-prikaz.component.html',
  styleUrls: ['./obavestenje-prikaz.component.css']
})
export class ObavestenjePrikazComponent implements AfterViewInit {

  @ViewChild('obavestenjePrikaz', { static: false }) obavestenjePrikaz: ElementRef;

  obavestenje: any;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              public obavestenjeService: ObavestenjeService,
              public editService: ObavestenjeEditService) { }

  ngAfterViewInit(): void {
    this.activatedRoute.queryParams.subscribe(val => {
      if (!val.obavestenje) {
        this.router.navigate(['']);
      } else {
        this.obavestenjeService.getById(val.obavestenje).subscribe(obavestenje => {
          this.obavestenje = (xml.xml2js(obavestenje, {compact: true}) as any).obavestenje;
          obavestenje = obavestenje.replace(/<\?.+\?>/, '');
          this.editService.render(this.obavestenjePrikaz.nativeElement, obavestenje, true);
        });
      }
    });
  }

  pregledajZahtev(): void {
    this.router.navigate(['zahtev'], {queryParams: {zahtev: this.obavestenje.zahtev._attributes.id}});
  }

  generatePdf(): void {
    this.obavestenjeService.generatePdf(this.obavestenje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateXHTML(): void {
    this.obavestenjeService.generateXHTML(this.obavestenje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

}
