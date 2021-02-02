import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import {AuthModule} from './components/auth/auth.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {JwtInterceptor} from './core/interceptors/jwt.interceptor';
import {ToastModule} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {MenubarModule} from 'primeng/menubar';
import { MainViewComponent } from './components/main-views/main-view/main-view.component';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import { GradjaninViewComponent } from './components/main-views/gradjanin-view/gradjanin-view.component';
import { SluzbenikViewComponent } from './components/main-views/sluzbenik-view/sluzbenik-view.component';
import {TableModule} from 'primeng/table';
import {PregledZahtevaComponent} from './components/pregled-zahteva/pregled-zahteva.component';
import {SlanjeOdgovoraComponent} from './components/slanje-odgovora/slanje-odgovora.component';
import {PodnosenjeZahtevaComponent} from './components/podnosenje-zahteva/podnosenje-zahteva.component';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {PregledObavestenjaComponent} from './components/pregled-obavestenja/pregled-obavestenja.component';
import { ZahtevPrikazComponent } from './components/zahtev-prikaz/zahtev-prikaz.component';
import { ObavestenjePrikazComponent } from './components/obavestenje-prikaz/obavestenje-prikaz.component';
import { IzjasnjenjaComponent } from './components/izjasnjenja/izjasnjenja.component';
import {OverlayPanelModule} from 'primeng/overlaypanel';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { PodnosenjeIzvestajaComponent } from './components/podnosenje-izvestaja/podnosenje-izvestaja.component';
import {InputNumberModule} from 'primeng/inputnumber';
import {ToolbarModule} from 'primeng/toolbar';

@NgModule({
  declarations: [
    AppComponent,
    MainViewComponent,
    GradjaninViewComponent,
    SluzbenikViewComponent,
    PregledObavestenjaComponent,
    PregledZahtevaComponent,
    SlanjeOdgovoraComponent,
    PodnosenjeZahtevaComponent,
    ZahtevPrikazComponent,
    ObavestenjePrikazComponent,
    IzjasnjenjaComponent,
    PodnosenjeIzvestajaComponent
  ],
    imports: [
      BrowserModule,
      BrowserAnimationsModule,
      AppRoutingModule,
      AuthModule,
      HttpClientModule,
      RouterModule,
      ToastModule,
      MenubarModule,
      ButtonModule,
      TableModule,
      InputTextModule,
      ScrollPanelModule,
      OverlayPanelModule,
      FormsModule,
      ReactiveFormsModule,
      InputTextareaModule,
      InputNumberModule,
      ToolbarModule
    ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
