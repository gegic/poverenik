import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrijavaComponent } from './prijava/prijava.component';
import { RegistracijaComponent } from './registracija/registracija.component';
import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {InputTextModule} from 'primeng/inputtext';
import {PasswordModule} from 'primeng/password';



@NgModule({
  declarations: [PrijavaComponent, RegistracijaComponent],
  imports: [
    CommonModule,
    CardModule,
    ButtonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    InputTextModule,
    PasswordModule
  ]
})
export class AuthModule { }
