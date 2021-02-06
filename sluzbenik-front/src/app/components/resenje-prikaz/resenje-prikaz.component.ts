import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ResenjeService} from '../../core/services/resenje.service';
import {ResenjeEditService} from '../../core/services/resenje-edit.service';
import * as xml from 'xml-js';

@Component({
  selector: 'app-resenje-prikaz',
  templateUrl: './resenje-prikaz.component.html',
  styleUrls: ['./resenje-prikaz.component.css']
})
export class ResenjePrikazComponent implements AfterViewInit {

  @ViewChild('resenjePrikaz', { static: false }) resenjePrikaz: ElementRef;

  resenje: any;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              public resenjeService: ResenjeService,
              public editService: ResenjeEditService) { }

  ngAfterViewInit(): void {
    this.activatedRoute.queryParams.subscribe(val => {
      if (!val.resenje) {
        this.router.navigate(['']);
      } else {
        this.resenjeService.getById(val.resenje).subscribe(resenje => {
          this.resenje = (xml.xml2js(resenje, {compact: true}) as any).resenje;
          resenje = resenje.replace(/<\?.+\?>/, '');
          this.editService.render(this.resenjePrikaz.nativeElement, resenje, true);
        });
      }
    });
  }

  pregledajZalbu(): void {
    if (this.resenje.zalba._attributes.tip === 'na-odluku') {
      this.router.navigate(['zalba-na-odluku'], {queryParams: {zalbaNaOdluku: this.resenje.zalba._attributes.id}});
    } else {
      this.router.navigate(['zalba-cutanje'], {queryParams: {zalbaCutanje: this.resenje.zalba._attributes.id}});
    }
  }

  generatePdf(): void {
    this.resenjeService.generatePdf(this.resenje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

  generateXHTML(): void {
    this.resenjeService.generateXHTML(this.resenje._attributes.id).subscribe(val => {
      window.location.href = `http://localhost:4200/${val}`;
    });
  }

}
