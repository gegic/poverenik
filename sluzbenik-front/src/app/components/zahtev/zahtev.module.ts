import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PodnosenjeZahtevaComponent } from './podnosenje-zahteva/podnosenje-zahteva.component';
import {ButtonModule} from 'primeng/button';
import {ScrollPanelModule} from 'primeng/scrollpanel';



@NgModule({
  declarations: [PodnosenjeZahtevaComponent],
  imports: [
    CommonModule,
    ButtonModule,
    ScrollPanelModule
  ]
})
export class ZahtevModule { }
