import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PrijavaComponent} from './components/auth/prijava/prijava.component';
import {AuthGuard} from './core/guards/auth.guard';
import {RegistracijaComponent} from './components/auth/registracija/registracija.component';
import {Route, RouterModule} from '@angular/router';
import {MainViewComponent} from './components/main-views/main-view/main-view.component';
import {GradjaninViewComponent} from './components/main-views/gradjanin-view/gradjanin-view.component';
import {PodnosenjeZahtevaComponent} from './components/zahtev/podnosenje-zahteva/podnosenje-zahteva.component';
import {PregledZahtevaComponent} from './components/zahtev/pregled-zahteva/pregled-zahteva.component';
import {SluzbenikViewComponent} from './components/main-views/sluzbenik-view/sluzbenik-view.component';
import {SlanjeOdgovoraComponent} from './components/odgovor/slanje-odgovora/slanje-odgovora.component';

const routes: Route[] = [
  {path: 'prijava', component: PrijavaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: 'registracija', component: RegistracijaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: '', component: MainViewComponent, children: [
      {path: '', component: GradjaninViewComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'podnosenje-zahteva', component: PodnosenjeZahtevaComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'pregled-zahteva', component: PregledZahtevaComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'novi-zahtevi', component: PregledZahtevaComponent, data: {roles: ['sluzbenik'], neodgovoreni: true}, canActivate: [AuthGuard]},
      {path: 'slanje-odgovora', component: SlanjeOdgovoraComponent, data: {roles: ['sluzbenik']}, canActivate: [AuthGuard]},
      {path: 'sluzbenik', component: SluzbenikViewComponent, data: {roles: ['sluzbenik']}, canActivate: [AuthGuard]}
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
