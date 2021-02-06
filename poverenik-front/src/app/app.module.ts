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
import {TableModule} from 'primeng/table';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {PoverenikViewComponent} from './components/main-views/poverenik-view/poverenik-view.component';
import {CardModule} from 'primeng/card';
import {DropdownModule} from 'primeng/dropdown';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {IzborZahtevaComponent} from './components/izbor-zahteva/izbor-zahteva.component';
import { PodnosenjeZalbeCutanjeComponent } from './components/podnosenje-zalbe-cutanje/podnosenje-zalbe-cutanje.component';
import {ZalbaCutanjePrikazComponent} from './components/zalba-cutanje-prikaz/zalba-cutanje-prikaz.component';
import {PodnosenjeZalbeNaOdlukuComponent} from './components/podnosenje-zalbe-na-odluku/podnosenje-zalbe-na-odluku.component';
import {ZalbaNaOdlukuPrikazComponent} from './components/zalba-na-odluku-prikaz/zalba-na-odluku-prikaz.component';
import {PregledZalbiComponent} from './components/pregled-zalbi/pregled-zalbi.component';
import { SlanjeResenjaComponent } from './components/slanje-resenja/slanje-resenja.component';
import { PregledResenjaComponent } from './components/pregled-resenja/pregled-resenja.component';
import { ResenjePrikazComponent } from './components/resenje-prikaz/resenje-prikaz.component';
import { PregledIzvestajaComponent } from './components/pregled-izvestaja/pregled-izvestaja.component';
import {PrikazIzvestajaComponent} from './components/prikaz-izvestaja/prikaz-izvestaja.component';
import {ToolbarModule} from 'primeng/toolbar';
import {PregledPretragaComponent} from './components/pregled-pretraga/pregled-pretraga.component';
import {CheckboxModule} from 'primeng/checkbox';

@NgModule({
  declarations: [
    AppComponent,
    MainViewComponent,
    GradjaninViewComponent,
    PoverenikViewComponent,
    IzborZahtevaComponent,
    PodnosenjeZalbeCutanjeComponent,
    ZalbaCutanjePrikazComponent,
    PodnosenjeZalbeNaOdlukuComponent,
    PregledZalbiComponent,
    ZalbaNaOdlukuPrikazComponent,
    SlanjeResenjaComponent,
    PregledResenjaComponent,
    ResenjePrikazComponent,
    PregledIzvestajaComponent,
    PrikazIzvestajaComponent,
    PregledPretragaComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AuthModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    ToastModule,
    MenubarModule,
    ButtonModule,
    TableModule,
    InputTextModule,
    ScrollPanelModule,
    CardModule,
    DropdownModule,
    ProgressSpinnerModule,
    ToolbarModule,
    CheckboxModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
