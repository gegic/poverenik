import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../../core/services/auth.service';
import {MessageService} from 'primeng/api';
import {KorisnikElement} from '../../../core/model/korisnik-element';
import {Korisnik} from '../../../core/model/korisnik';
import * as xml from 'xml-js';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  registrationForm: FormGroup;
  loading = false;

  constructor(private authService: AuthService,
              private formBuilder: FormBuilder,
              private messageService: MessageService,
              private router: Router) {
    this.registrationForm = this.formBuilder.group({
      imePrezime: ['', [Validators.required, Validators.pattern(/^\p{L}+(\s+\p{L}+)+$/u)]],
      email: ['', [Validators.required, Validators.email]],
      lozinka: ['', [Validators.required, Validators.minLength(6)]],
      potvrda: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmitRegister(): void {
    if (this.registrationForm.get('imePrezime').invalid) {
      this.messageService.add({severity: 'error', summary: 'Neuspešna registracija', detail: 'Neispravno ime i prezime'});
      return;
    }
    if (this.registrationForm.get('email').invalid) {
      this.messageService.add({severity: 'error', summary: 'Neuspešna registracija', detail: 'Neispravan email'});
      return;
    }
    if (this.registrationForm.get('lozinka').invalid) {
      this.messageService.add({severity: 'error', summary: 'Neuspešna registracija', detail: 'Lozinka mora imati preko 6 karaktera'});
      return;
    }
    if (this.registrationForm.get('lozinka').invalid) {
      this.messageService.add({severity: 'error', summary: 'Neuspešna registracija', detail: 'Lozinka mora imati preko 6 karaktera'});
      return;
    }
    if (this.registrationForm.get('lozinka').value !== this.registrationForm.get('potvrda').value) {
      this.messageService.add({severity: 'error', summary: 'Neuspešna registracija', detail: 'Lozinka mora biti ispravno potvrđena'});
      return;
    }

    const korisnik: Korisnik = new Korisnik();
    korisnik.email._text = this.registrationForm.get('email').value;
    korisnik['ime-prezime']._text = this.registrationForm.get('imePrezime').value;
    korisnik.lozinka._text = this.registrationForm.get('lozinka').value;

    const korisnikElement: KorisnikElement = new KorisnikElement();
    korisnikElement.korisnik = korisnik;
    const xmlKorisnik = xml.js2xml(korisnikElement, {compact: true, ignoreComment: true, spaces: 2});
    this.loading = true;
    this.authService.register(xmlKorisnik).subscribe(val => {
      this.messageService.add({severity: 'success', summary: 'Uspešna registracija', detail: 'Sada možete pristupiti prijavi'});
      this.router.navigate(['/prijava']);
      this.loading = false;
    }, error => {
      this.loading = false;
      if (error.status === 409) {
        this.messageService.add({severity: 'error', summary: 'Neuspešna registracija', detail: 'Korisnik sa ovim emailom već postoji'});
        return;
      }
    });

  }
}
