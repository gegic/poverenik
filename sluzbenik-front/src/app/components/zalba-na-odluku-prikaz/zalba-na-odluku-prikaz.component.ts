import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ZalbaNaOdlukuService} from '../../core/services/zalba-na-odluku.service';
import {ZalbaNaOdlukuEditService} from '../../core/services/zalba-na-odluku-edit.service';
import * as xml from 'xml-js';
import {AuthService} from '../../core/services/auth.service';
import {ResenjeEditService} from '../../core/services/resenje-edit.service';

@Component({
  selector: 'app-zalba-na-odluku-prikaz',
  templateUrl: './zalba-na-odluku-prikaz.component.html',
  styleUrls: ['./zalba-na-odluku-prikaz.component.css']
})
export class ZalbaNaOdlukuPrikazComponent implements AfterViewInit {

  @ViewChild('zalbaNaOdlukuPrikaz', { static: false }) zalbaNaOdlukuXonomy: ElementRef;

  zalbaNaOdluku: any;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              public zalbaNaOdlukuService: ZalbaNaOdlukuService,
              public editService: ZalbaNaOdlukuEditService,
              public authService: AuthService) { }

  ngAfterViewInit(): void {
    this.activatedRoute.queryParams.subscribe(val => {
      if (!val.zalbaNaOdluku) {
        this.router.navigate(['']);
      } else {
        this.zalbaNaOdlukuService.getById(val.zalbaNaOdluku).subscribe(zalbaNaOdluku => {
          this.zalbaNaOdluku = (xml.xml2js(zalbaNaOdluku, {compact: true}) as any)['zalba-na-odluku'];
          zalbaNaOdluku = zalbaNaOdluku.replace(/<\?.+\?>/, '');
          this.editService.render(this.zalbaNaOdlukuXonomy.nativeElement, zalbaNaOdluku, true);
        });
      }
    });
  }

  generatePdf(): void {
    this.zalbaNaOdlukuService.generatePdf(this.zalbaNaOdluku._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4201/${val}`;
    });
  }

  generateXHTML(): void {
    this.zalbaNaOdlukuService.generateXHTML(this.zalbaNaOdluku._attributes.id).subscribe(val => {
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
