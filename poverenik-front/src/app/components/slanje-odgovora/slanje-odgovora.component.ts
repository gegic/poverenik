import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ZahtevEditService} from '../../core/services/zahtev-edit.service';
import {MessageService} from 'primeng/api';
import {ZahtevService} from '../../core/services/zahtev.service';
import {Router} from '@angular/router';
import {ObavestenjeEditService} from '../../core/services/obavestenje-edit.service';
import {ObavestenjeService} from '../../core/services/obavestenje.service';
import {xmlObavestenje} from '../../utils/obavestenjeXml';

@Component({
  selector: 'app-slanje-odgovora',
  templateUrl: './slanje-odgovora.component.html',
  styleUrls: ['./slanje-odgovora.component.css']
})
export class SlanjeOdgovoraComponent implements OnInit, AfterViewInit {

  @ViewChild('odgovorXonomy', { static: false }) odgovorXonomy: ElementRef;

  constructor(public editService: ObavestenjeEditService,
              private messageService: MessageService,
              private odgovorService: ObavestenjeService,
              private router: Router) { }

  ngOnInit(): void {
    if (!this.editService.zahtev.getValue()) {
      this.router.navigate(['']);
    }
  }

  ngAfterViewInit(): void {
    this.editService.render(this.odgovorXonomy.nativeElement, xmlObavestenje(this.editService.zahtev.getValue()));
  }

  submitOdgovor(): void {
    if (this.editService.warnings.length > 0) {
      this.messageService.add({severity: 'error', summary: 'Neuspešno slanje', detail: 'Prvo proverite sva upozorenja za obaveštenje.'})
      return;
    }

    const odgovorString: string = this.editService.harvest();

    this.odgovorService.send(odgovorString).subscribe(() =>
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
