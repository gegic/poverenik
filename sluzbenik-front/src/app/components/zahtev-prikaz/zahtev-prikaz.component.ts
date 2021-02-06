import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ZahtevService} from '../../core/services/zahtev.service';
import {ZahtevEditService} from '../../core/services/zahtev-edit.service';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';
import {ObavestenjeService} from '../../core/services/obavestenje.service';

@Component({
  selector: 'app-zahtev-prikaz',
  templateUrl: './zahtev-prikaz.component.html',
  styleUrls: ['./zahtev-prikaz.component.css']
})
export class ZahtevPrikazComponent implements AfterViewInit {

  @ViewChild('zahtevPrikaz', { static: false }) zahtevXonomy: ElementRef;

  zahtev: any;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              public zahtevService: ZahtevService,
              public editService: ZahtevEditService,
              public authService: AuthService,
              private obavestenjeService: ObavestenjeService) { }

  ngAfterViewInit(): void {
    this.activatedRoute.queryParams.subscribe(val => {
      if (!val.zahtev) {
        this.router.navigate(['']);
      } else {
        this.zahtevService.getById(val.zahtev).subscribe(zahtev => {
          this.zahtev = (xml.xml2js(zahtev, {compact: true}) as any).zahtev;
          zahtev = zahtev.replace(/<\?.+\?>/, '');
          this.editService.render(this.zahtevXonomy.nativeElement, zahtev, true);
        });
      }
    });
  }

  generatePdf(): void {
    this.zahtevService.generatePdf(this.zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateXHTML(): void {
    this.zahtevService.generateXHTML(this.zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateJson(): void {
    this.zahtevService.generateJson(this.zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateRdf(): void {
    this.zahtevService.generateRdf(this.zahtev._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  prihvati(): void {
    this.obavestenjeService.zahtev.next(this.zahtev);
    this.router.navigate(['prihvatanje']);
  }

  odbij(): void {
    this.obavestenjeService.zahtev.next(this.zahtev);
    this.router.navigate(['odbijanje']);
  }
}
