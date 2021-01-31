import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SlanjeOdgovoraComponent } from './slanje-odgovora/slanje-odgovora.component';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {ButtonModule} from 'primeng/button';



@NgModule({
  declarations: [SlanjeOdgovoraComponent],
  imports: [
    CommonModule,
    ScrollPanelModule,
    ButtonModule
  ]
})
export class OdgovorModule { }
