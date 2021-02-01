import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PrijavaComponent} from './components/auth/prijava/prijava.component';
import {AuthGuard} from './core/guards/auth.guard';
import {RegistracijaComponent} from './components/auth/registracija/registracija.component';
import {Route, RouterModule} from '@angular/router';
import {MainViewComponent} from './components/main-views/main-view/main-view.component';
import {GradjaninViewComponent} from './components/main-views/gradjanin-view/gradjanin-view.component';
import {PoverenikViewComponent} from './components/main-views/poverenik-view/poverenik-view.component';
import {IzborZahtevaComponent} from './components/izbor-zahteva/izbor-zahteva.component';
import {PodnosenjeZalbeCutanjeComponent} from './components/podnosenje-zalbe-cutanje/podnosenje-zalbe-cutanje.component';
import {PregledZalbiCutanjeComponent} from './components/pregled-zalbi-cutanje/pregled-zalbi-cutanje.component';

const routes: Route[] = [
  {path: 'prijava', component: PrijavaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: 'registracija', component: RegistracijaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: '', component: MainViewComponent, children: [
      {path: '', component: GradjaninViewComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'izbor-neodgovorenih-zahteva', component: IzborZahtevaComponent, data: {roles: ['gradjanin'], tip: 'neodgovoren'}, canActivate: [AuthGuard]},
      {path: 'podnosenje-zalbe-cutanje', component: PodnosenjeZalbeCutanjeComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'pregled-zalbi-cutanje', component: PregledZalbiCutanjeComponent, data: {roles: ['gradjanin'], tip: 'korisnikove-zalbe'}, canActivate: [AuthGuard]},
      {path: 'poverenik', component: PoverenikViewComponent, data: {roles: ['poverenik']}, canActivate: [AuthGuard]}
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
