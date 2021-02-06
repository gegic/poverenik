import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {ZalbaCutanjeEditService} from '../../core/services/zalba-cutanje-edit.service';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ResenjeEditService} from '../../core/services/resenje-edit.service';
import {ResenjeService} from '../../core/services/resenje.service';

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
              public authService: AuthService,
              private resenjeEditService: ResenjeEditService,
              private resenjeService: ResenjeService) { }

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
    this.resenjeEditService.tip = 'prihvatanje';
    this.resenjeService.getOdgovor(this.zalbaCutanje._attributes.id).subscribe(() => {
      this.resenjeService.odgovor = true;
      this.resenjeService.zalba = this.zalbaCutanje;
      this.router.navigate(['prihvatanje']);
    }, () => {
      this.resenjeService.odgovor = false;
      this.resenjeService.zalba = this.zalbaCutanje;
      this.router.navigate(['prihvatanje']);
    });
  }

  odbij(): void {
    this.resenjeEditService.tip = 'odbijanje';
    this.resenjeService.getOdgovor(this.zalbaCutanje._attributes.id).subscribe(() => {
      this.resenjeService.odgovor = true;
      this.resenjeService.zalba = this.zalbaCutanje;
      this.router.navigate(['odbijanje']);
    }, () => {
      this.resenjeService.odgovor = false;
      this.resenjeService.zalba = this.zalbaCutanje;
      this.router.navigate(['odbijanje']);
    });
  }

  generateJson(): void {
    this.zalbaCutanjeService.generateJson(this.zalbaCutanje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateRdf(): void {
    this.zalbaCutanjeService.generateRdf(this.zalbaCutanje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }
}
