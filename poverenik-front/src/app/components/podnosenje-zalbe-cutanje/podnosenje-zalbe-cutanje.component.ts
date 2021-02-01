import {AfterViewInit, Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ZalbaCutanjeEditService} from '../../core/services/zalba-cutanje-edit.service';
import {MessageService} from 'primeng/api';
import {ZalbaCutanjeService} from '../../core/services/zalba-cutanje.service';
import {Router} from '@angular/router';
import {zalbaCutanjeXml} from '../../utils/zalbaCutanjeXml';

@Component({
  selector: 'app-podnosenje-zalbe-cutanje',
  templateUrl: './podnosenje-zalbe-cutanje.component.html',
  styleUrls: ['./podnosenje-zalbe-cutanje.component.css']
})
export class PodnosenjeZalbeCutanjeComponent implements AfterViewInit, OnDestroy {

  @ViewChild('zalbaCutanjeXonomy', { static: false }) zalbaCutanjeXonomy: ElementRef;

  constructor(private editService: ZalbaCutanjeEditService,
              private messageService: MessageService,
              private zalbaCutanjeService: ZalbaCutanjeService,
              private router: Router) { }

  ngAfterViewInit(): void {
    if (!this.zalbaCutanjeService.zahtev) {
      this.router.navigate(['']);
    }
    this.editService.render(this.zalbaCutanjeXonomy.nativeElement, zalbaCutanjeXml(this.zalbaCutanjeService.zahtev));
  }

  submitZalba(): void {
    if (this.editService.warnings.length > 0) {
      this.messageService.add({severity: 'error', summary: 'Neuspešno podnošenje', detail: 'Prvo proverite sva upozorenja za žalbu.'})
    }

    const zalbaCutanjeString: string = this.editService.harvest();
    this.zalbaCutanjeService.create(zalbaCutanjeString).subscribe(() =>
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
    this.zalbaCutanjeService.zahtev = null;
  }
}
