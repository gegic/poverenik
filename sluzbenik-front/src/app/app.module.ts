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
import {ZahtevModule} from './components/zahtev/zahtev.module';
import { SluzbenikViewComponent } from './components/main-views/sluzbenik-view/sluzbenik-view.component';
import {OdgovorModule} from './components/odgovor/odgovor.module';

@NgModule({
  declarations: [
    AppComponent,
    MainViewComponent,
    GradjaninViewComponent,
    SluzbenikViewComponent
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
    ZahtevModule,
    OdgovorModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
