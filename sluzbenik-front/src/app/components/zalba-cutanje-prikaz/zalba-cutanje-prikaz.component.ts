import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {ZalbaCutanjeEditService} from '../../core/services/zalba-cutanje-edit.service';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ResenjeEditService} from '../../core/services/resenje-edit.service';

@Component({
  selector: 'app-zalba-cutanje-prikaz',
  templateUrl: './zalba-cutanje-prikaz.component.html',
  styleUrls: ['./zalba-cutanje-prikaz.component.css']
})
export class ZalbaCutanjePrikazComponent implements AfterViewInit {

  @ViewChild('zalbaCutanjePrikaz', { static: false }) zalbaCutanjeXonomy: ElementRef;

  zalbaCutanje: any;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              public zalbaCutanjeService: ZalbaCutanjeService,
              public editService: ZalbaCutanjeEditService,
              public authService: AuthService) { }

  ngAfterViewInit(): void {
    this.activatedRoute.queryParams.subscribe(val => {
      if (!val.zalbaCutanje) {
        this.router.navigate(['']);
      } else {
        this.zalbaCutanjeService.getById(val.zalbaCutanje).subscribe(zalbaCutanje => {
          this.zalbaCutanje = (xml.xml2js(zalbaCutanje, {compact: true}) as any)['zalba-cutanje'];
          zalbaCutanje = zalbaCutanje.replace(/<\?.+\?>/, '');
          this.editService.render(this.zalbaCutanjeXonomy.nativeElement, zalbaCutanje, true);
        });
      }
    });
  }

  generatePdf(): void {
    this.zalbaCutanjeService.generatePdf(this.zalbaCutanje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  generateXHTML(): void {
    this.zalbaCutanjeService.generateXHTML(this.zalbaCutanje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  resi(): void {
    // this.obavestenjeEditService.zahtev.next(this.zahtev);
    // this.router.navigate(['slanje-odgovora']);
  }

  odbij(): void {
    // this.zahtevService.odbij(this.zahtev._attributes.id).subscribe(zahtev => {
    //   this.zahtev = (xml.xml2js(zahtev, {compact: true}) as any).zahtev;
    //   zahtev = zahtev.replace(/<\?.+\?>/, '');
    //   this.editService.render(this.zahtevXonomy.nativeElement, zahtev, true);
    // });
  }
}
