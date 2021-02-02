import {AfterViewInit, Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ZalbaCutanjeEditService} from '../../core/services/zalba-cutanje-edit.service';
import {MessageService} from 'primeng/api';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {Router} from '@angular/router';
import {zalbaCutanjeXml} from '../../utils/zalbaCutanjeXml';
import {ZalbaNaOdlukuEditService} from '../../core/services/zalba-na-odluku-edit.service';
import {ZalbaNaOdlukuService} from '../../core/services/zalba-na-odluku.service';
import {zalbaNaOdluku} from '../../utils/zalbaNaOdlukuXml';
import * as xml from 'xml-js';

@Component({
  selector: 'app-podnosenje-zalbe-na-odluku',
  templateUrl: './podnosenje-zalbe-na-odluku.component.html',
  styleUrls: ['./podnosenje-zalbe-na-odluku.component.css']
})
export class PodnosenjeZalbeNaOdlukuComponent implements AfterViewInit, OnDestroy {

  @ViewChild('zalbaNaOdluku', { static: false }) zalbaNaOdlukuXonomy: ElementRef;


  constructor(private editService: ZalbaNaOdlukuEditService,
              private messageService: MessageService,
              private zalbaNaOdlukuService: ZalbaNaOdlukuService,
              private router: Router) { }

  ngAfterViewInit(): void {
    if (!this.zalbaNaOdlukuService.zahtev || !this.zalbaNaOdlukuService.obavestenje) {
      this.router.navigate(['']);
      return;
    }
    this.editService.render(this.zalbaNaOdlukuXonomy.nativeElement, zalbaNaOdluku(this.zalbaNaOdlukuService.obavestenje));
  }

  submitZalba(): void {
    if (this.editService.warnings.length > 0) {
      this.messageService.add({severity: 'error', summary: 'Neuspešno podnošenje', detail: 'Prvo proverite sva upozorenja za žalbu.'});
    }

    const zalbaNaOdlukuString: string = this.editService.harvest();
    this.zalbaNaOdlukuService.create(zalbaNaOdlukuString).subscribe(() =>
      {
        this.messageService.add({severity: 'success', summary: 'Uspešno podneta žalba', detail: 'Vaša žalba je uspešno podneta'});
        this.router.navigate(['']);
      },
      () => {
        this.messageService.add({severity: 'error', summary: 'Neuspešno podnošenje'});
      }
    );
  }

  ngOnDestroy(): void {
    this.zalbaNaOdlukuService.zahtev = null;
  }
}
