import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ZahtevEditService} from '../../core/services/zahtev-edit.service';
import {MessageService} from 'primeng/api';
import {ZahtevService} from '../../core/services/zahtev.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';
import {ObavestenjeService} from '../../core/services/obavestenje.service';
import {xmlObavestenjeOdbijanje, xmlObavestenjePrihvatanje} from '../../utils/obavestenjeXml';

@Component({
  selector: 'app-slanje-odgovora',
  templateUrl: './slanje-odgovora.component.html',
  styleUrls: ['./slanje-odgovora.component.css']
})
export class SlanjeOdgovoraComponent implements OnInit, AfterViewInit {

  @ViewChild('odgovorXonomy', { static: false }) odgovorXonomy: ElementRef;
  tip: string;
  xmlString: string;
  constructor(public editService: ObavestenjeEditService,
              private messageService: MessageService,
              public obavestenjeService: ObavestenjeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    if (!this.obavestenjeService.zahtev.getValue()) {
      this.router.navigate(['']);
      return;
    }
    this.activatedRoute.data.subscribe(val => {
      if (!val.tip) {
        this.router.navigate(['']);
        return;
      } else if (val.tip === 'prihvatanje') {
        this.xmlString = xmlObavestenjePrihvatanje(this.obavestenjeService.zahtev.getValue());
      } else {
        this.xmlString = xmlObavestenjeOdbijanje(this.obavestenjeService.zahtev.getValue());
      }
      this.tip = val.tip;
    });
  }

  ngAfterViewInit(): void {
    this.editService.render(this.odgovorXonomy.nativeElement, this.xmlString);
  }

  submitOdgovor(): void {
    if (this.editService.warnings.length > 0) {
      this.messageService.add({severity: 'error', summary: 'Neuspešno slanje', detail: 'Prvo proverite sva upozorenja za obaveštenje.'});
      return;
    }

    const odgovorString: string = this.editService.harvest();

    this.obavestenjeService.send(odgovorString).subscribe(() =>
      {
        this.messageService.add({severity: 'success', summary: 'Uspešno poslan odgovor', detail: 'Vaše obaveštenje je uspešno poslano'});
        this.router.navigate(['']);
      },
      () => {
        this.messageService.add({severity: 'error', summary: 'Neuspešno slanje'});
      }
    );
  }

}
