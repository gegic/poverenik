import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ZahtevEditService} from '../../../core/services/zahtev-edit.service';
import {MessageService} from 'primeng/api';
import {ZahtevService} from '../../../core/services/zahtev.service';
import {Router} from '@angular/router';
import {OdgovorEditService} from '../../../core/services/odgovor-edit.service';
import {OdgovorService} from '../../../core/services/odgovor.service';

@Component({
  selector: 'app-slanje-odgovora',
  templateUrl: './slanje-odgovora.component.html',
  styleUrls: ['./slanje-odgovora.component.css']
})
export class SlanjeOdgovoraComponent implements OnInit, AfterViewInit {

  @ViewChild('odgovorXonomy', { static: false }) odgovorXonomy: ElementRef;

  constructor(public editService: OdgovorEditService,
              private messageService: MessageService,
              private odgovorService: OdgovorService,
              private router: Router) { }

  ngOnInit(): void {
    if (!this.editService.zahtev.getValue()) {
      this.router.navigate(['']);
    }
  }

  ngAfterViewInit(): void {
    this.editService.render(this.odgovorXonomy.nativeElement);
  }

  submitOdgovor(): void {
    if (this.editService.warnings.length > 0) {
      this.messageService.add({severity: 'error', summary: 'Neuspešno podnošenje', detail: 'Prvo proverite sva upozorenja za zahtev.'})
    }

    const odgovorString: string = this.editService.harvest();

    this.odgovorService.send(odgovorString).subscribe(() =>
      {
        this.messageService.add({severity: 'success', summary: 'Uspešno podnet zahtev', detail: 'Vaš zahtev je uspešno podnet'});
        this.router.navigate(['']);
      },
      () => {
        this.messageService.add({severity: 'error', summary: 'Neuspešno podnošenje'});
      }
    );
  }

}
