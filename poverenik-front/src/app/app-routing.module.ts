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
import {ZalbaCutanjePrikazComponent} from './components/zalba-cutanje-prikaz/zalba-cutanje-prikaz.component';
import {PodnosenjeZalbeNaOdlukuComponent} from './components/podnosenje-zalbe-na-odluku/podnosenje-zalbe-na-odluku.component';
import {ZalbaNaOdlukuPrikazComponent} from './components/zalba-na-odluku-prikaz/zalba-na-odluku-prikaz.component';
import {PregledZalbiComponent} from './components/pregled-zalbi/pregled-zalbi.component';
import {SlanjeResenjaComponent} from './components/slanje-resenja/slanje-resenja.component';
import {PregledResenjaComponent} from './components/pregled-resenja/pregled-resenja.component';
import {ResenjePrikazComponent} from './components/resenje-prikaz/resenje-prikaz.component';

const routes: Route[] = [
  {path: 'prijava', component: PrijavaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: 'registracija', component: RegistracijaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: '', component: MainViewComponent, children: [
      {path: '', component: GradjaninViewComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'izbor-neodgovorenih-zahteva', component: IzborZahtevaComponent, data: {roles: ['gradjanin'], tip: 'neodgovoren'}, canActivate: [AuthGuard]},
      {path: 'podnosenje-zalbe-cutanje', component: PodnosenjeZalbeCutanjeComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'zalba-cutanje', component: ZalbaCutanjePrikazComponent, data: {roles: ['gradjanin', 'poverenik']}, canActivate: [AuthGuard]},
      {path: 'izbor-odbijenih-zahteva', component: IzborZahtevaComponent, data: {roles: ['gradjanin'], tip: 'odbijen'}, canActivate: [AuthGuard]},
      {path: 'zalba-na-odluku', component: ZalbaNaOdlukuPrikazComponent, data: {roles: ['gradjanin', 'poverenik']}, canActivate: [AuthGuard]},
      {path: 'podnosenje-zalbe-na-odluku', component: PodnosenjeZalbeNaOdlukuComponent, data: {roles: ['gradjanin']}, canActivate: [AuthGuard]},
      {path: 'pregled-zalbi', component: PregledZalbiComponent, data: {roles: ['gradjanin'], tip: 'korisnikove-zalbe'}, canActivate: [AuthGuard]},
      {path: 'resavanje-zalbi', component: PregledZalbiComponent, data: {roles: ['poverenik'], tip: 'neresene-zalbe'}, canActivate: [AuthGuard]},
      {path: 'sve-zalbe', component: PregledZalbiComponent, data: {roles: ['poverenik'], tip: 'sve-zalbe'}, canActivate: [AuthGuard]},
      {path: 'prihvatanje', component: SlanjeResenjaComponent, data: {roles: ['poverenik'], tip: 'prihvatanje'}, canActivate: [AuthGuard]},
      {path: 'odbijanje', component: SlanjeResenjaComponent, data: {roles: ['poverenik'], tip: 'odbijanje'}, canActivate: [AuthGuard]},
      {path: 'pregled-resenja', component: PregledResenjaComponent, data: {roles: ['gradjanin'], tip: 'korisnikova-resenja'}, canActivate: [AuthGuard]},
      {path: 'sva-resenja', component: PregledResenjaComponent, data: {roles: ['poverenik'], tip: 'sva-resenja'}, canActivate: [AuthGuard]},
      {path: 'resenje', component: ResenjePrikazComponent, data: {roles: ['gradjanin', 'poverenik']}, canActivate: [AuthGuard]},
      {path: 'poverenik', component: PoverenikViewComponent, data: {roles: ['poverenik']}, canActivate: [AuthGuard]}
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
