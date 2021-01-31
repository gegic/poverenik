import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PodnosenjeZahtevaComponent } from './podnosenje-zahteva/podnosenje-zahteva.component';
import {ButtonModule} from 'primeng/button';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import { PregledZahtevaComponent } from './pregled-zahteva/pregled-zahteva.component';
import {DataViewModule} from 'primeng/dataview';
import {InputTextModule} from 'primeng/inputtext';



@NgModule({
  declarations: [PodnosenjeZahtevaComponent, PregledZahtevaComponent],
  imports: [
    CommonModule,
    ButtonModule,
    ScrollPanelModule,
    DataViewModule,
    InputTextModule
  ]
})
export class ZahtevModule { }
