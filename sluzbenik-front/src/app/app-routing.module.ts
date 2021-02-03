import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PrijavaComponent} from './components/auth/prijava/prijava.component';
import {AuthGuard} from './core/guards/auth.guard';
import {RegistracijaComponent} from './components/auth/registracija/registracija.component';
import {Route, RouterModule} from '@angular/router';
import {MainViewComponent} from './components/main-views/main-view/main-view.component';
import {GradjaninViewComponent} from './components/main-views/gradjanin-view/gradjanin-view.component';
import {PodnosenjeZahtevaComponent} from './components/podnosenje-zahteva/podnosenje-zahteva.component';
import {PregledZahtevaComponent} from './components/pregled-zahteva/pregled-zahteva.component';
import {SluzbenikViewComponent} from './components/main-views/sluzbenik-view/sluzbenik-view.component';
import {SlanjeOdgovoraComponent} from './components/slanje-odgovora/slanje-odgovora.component';
import {PregledObavestenjaComponent} from './components/pregled-obavestenja/pregled-obavestenja.component';
import {ZahtevPrikazComponent} from './components/zahtev-prikaz/zahtev-prikaz.component';
import {ObavestenjePrikazComponent} from './components/obavestenje-prikaz/obavestenje-prikaz.component';
import {IzjasnjenjaComponent} from './components/izjasnjenja/izjasnjenja.component';
import {PodnosenjeIzvestajaComponent} from './components/podnosenje-izvestaja/podnosenje-izvestaja.component';
import {PregledIzvestajaComponent} from './components/pregled-izvestaja/pregled-izvestaja.component';
import {PrikazIzvestajaComponent} from './components/prikaz-izvestaja/prikaz-izvestaja.component';

const routes: Route[] = [
  {path: 'prijava', component: PrijavaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: 'registracija', component: RegistracijaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: '', component: MainViewComponent, children: [
      {path: '', component: GradjaninViewComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'podnosenje-zahteva', component: PodnosenjeZahtevaComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'pregled-zahteva', component: PregledZahtevaComponent, data: {roles: ['gradjanin'], tip: 'korisnikovi-zahtevi'}, canActivate: [AuthGuard]},
      {path: 'pregled-obavestenja', component: PregledObavestenjaComponent, data: {roles: ['gradjanin'], tip: 'korisnikova-obavestenja'}, canActivate: [AuthGuard]},
      {path: 'sva-obavestenja', component: PregledObavestenjaComponent, data: {roles: ['sluzbenik'], tip: 'sva-obavestenja'}, canActivate: [AuthGuard]},
      {path: 'zahtev', component: ZahtevPrikazComponent, data: {roles: ['gradjanin', 'sluzbenik']}, canActivate: [AuthGuard]},
      {path: 'obavestenje', component: ObavestenjePrikazComponent, data: {roles: ['gradjanin', 'sluzbenik']}, canActivate: [AuthGuard]},
      {path: 'novi-zahtevi', component: PregledZahtevaComponent, data: {roles: ['sluzbenik'], tip: 'neodgovoreni-zahtevi'}, canActivate: [AuthGuard]},
      {path: 'svi-zahtevi', component: PregledZahtevaComponent, data: {roles: ['sluzbenik'], tip: 'svi-zahtevi'}, canActivate: [AuthGuard]},
      {path: 'prihvatanje', component: SlanjeOdgovoraComponent, data: {roles: ['sluzbenik'], tip: 'prihvatanje'}, canActivate: [AuthGuard]},
      {path: 'odbijanje', component: SlanjeOdgovoraComponent, data: {roles: ['sluzbenik'], tip: 'odbijanje'}, canActivate: [AuthGuard]},
      {path: 'izjasnjenja', component: IzjasnjenjaComponent, data: {roles: ['sluzbenik']}, canActivate: [AuthGuard]},
      {path: 'izvestaj', component: PodnosenjeIzvestajaComponent, data: {roles: ['sluzbenik']}, canActivate: [AuthGuard]},
      {path: 'pregled-izvestaja', component: PregledIzvestajaComponent, data: {roles: ['sluzbenik']}, canActivate: [AuthGuard]},
      {path: 'prikaz-izvestaja', component: PrikazIzvestajaComponent, data: {roles: ['sluzbenik']}, canActivate: [AuthGuard]},
      {path: 'sluzbenik', component: SluzbenikViewComponent, data: {roles: ['sluzbenik']}, canActivate: [AuthGuard]}
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
