import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ResenjeEditService} from '../../core/services/resenje-edit.service';
import {MessageService} from 'primeng/api';
import {ResenjeService} from '../../core/services/resenje.service';
import {ActivatedRoute, Router} from '@angular/router';
import {
  xmlResenjeOdbijanje_cutanje,
  xmlResenjeOdbijanje_naOdluku,
  xmlResenjePrihvatanje_cutanje,
  xmlResenjePrihvatanje_naOdluku
} from '../../utils/resenjeXml';

@Component({
  selector: 'app-slanje-resenja',
  templateUrl: './slanje-resenja.component.html',
  styleUrls: ['./slanje-resenja.component.css']
})
export class SlanjeResenjaComponent implements OnInit, AfterViewInit {


  @ViewChild('resenjeXonomy', { static: false }) resenjeXonomy: ElementRef;

  tip: string;
  xmlString: string;
  constructor(public editService: ResenjeEditService,
              private messageService: MessageService,
              public resenjeService: ResenjeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    if (!this.resenjeService.zalba) {
      this.router.navigate(['']);
      return;
    }
    this.activatedRoute.data.subscribe(val => {
      if (!val.tip) {
        this.router.navigate(['']);
        return;
      } else if (val.tip === 'prihvatanje') {
        const zalba = this.resenjeService.zalba;
        const odgovor = this.resenjeService.odgovor;
        if (!zalba.protiv.donosilac) {
          this.xmlString = xmlResenjePrihvatanje_cutanje(zalba, !!odgovor);
        } else {
          this.xmlString = xmlResenjePrihvatanje_naOdluku(zalba, !!odgovor);
        }
      } else {
        const zalba = this.resenjeService.zalba;
        const odgovor = this.resenjeService.odgovor;
        if (!zalba.protiv.donosilac) {
          this.xmlString = xmlResenjeOdbijanje_cutanje(zalba, !!odgovor);
        } else {
          this.xmlString = xmlResenjeOdbijanje_naOdluku(zalba, !!odgovor);
        }
      }
      this.tip = val.tip;
    });
  }

  ngAfterViewInit(): void {
    this.editService.render(this.resenjeXonomy.nativeElement, this.xmlString);
  }

  submitResenje(): void {
    if (this.editService.warnings.length > 0) {
      this.messageService.add({severity: 'error', summary: 'Neuspešno slanje', detail: 'Prvo proverite sva upozorenja za rešenje.'});
      return;
    }

    const resenjeString: string = this.editService.harvest();

    this.resenjeService.send(resenjeString).subscribe(() =>
      {
        this.messageService.add({severity: 'success', summary: 'Uspešno poslano rešenje', detail: 'Vaše rešenje je uspešno poslano'});
        this.router.navigate(['']);
      },
      () => {
        this.messageService.add({severity: 'error', summary: 'Neuspešno slanje'});
      }
    );
  }

}
