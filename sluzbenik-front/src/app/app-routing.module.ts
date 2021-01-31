import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PrijavaComponent} from './components/auth/prijava/prijava.component';
import {AuthGuard} from './core/guards/auth.guard';
import {RegistracijaComponent} from './components/auth/registracija/registracija.component';
import {RouterModule} from '@angular/router';

const routes = [
  {path: 'prijava', component: PrijavaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]},
  {path: 'registracija', component: RegistracijaComponent, data: {roles: ['UNREGISTERED']}, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
