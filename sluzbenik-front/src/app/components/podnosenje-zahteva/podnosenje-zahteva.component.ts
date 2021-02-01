import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ZahtevEditService} from '../../core/services/zahtev-edit.service';
import {MessageService} from 'primeng/api';
import {ZahtevService} from '../../core/services/zahtev.service';
import {Router, RouterOutlet} from '@angular/router';
import {zahtevXmlString} from '../../utils/zahtevXml';

@Component({
  selector: 'app-podnosenje-zahteva',
  templateUrl: './podnosenje-zahteva.component.html',
  styleUrls: ['./podnosenje-zahteva.component.scss']
})
export class PodnosenjeZahtevaComponent implements AfterViewInit {
  @ViewChild('zahtevXonomy', { static: false }) zahtevXonomy: ElementRef;

  constructor(private editService: ZahtevEditService,
              private messageService: MessageService,
              private zahtevService: ZahtevService,
              private router: Router) { }
              
  ngAfterViewInit(): void {
    this.editService.render(this.zahtevXonomy.nativeElement, zahtevXmlString);
  }

  submitZahtev(): void {
    if (this.editService.warnings.length > 0) {
      this.messageService.add({severity: 'error', summary: 'Neuspešno podnošenje', detail: 'Prvo proverite sva upozorenja za zahtev.'})
    }

    const zahtevString: string = this.editService.harvest();

    this.zahtevService.create(zahtevString).subscribe(() =>
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
