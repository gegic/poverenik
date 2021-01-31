import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../../core/services/auth.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MessageService} from 'primeng/api';
import {Prijava} from '../../../core/model/prijava';
import * as xml from 'xml-js';
import {PrijavaElement} from '../../../core/model/prijava-element';
import {TokenOdgovor} from '../../../core/model/token-odgovor';
import {ElementCompact} from 'xml-js';
import {Token} from '@angular/compiler';
import {Router} from '@angular/router';
@Component({
  selector: 'app-prijava',
  templateUrl: './prijava.component.html',
  styleUrls: ['./prijava.component.css']
})
export class PrijavaComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private authService: AuthService,
              private formBuilder: FormBuilder,
              private messageService: MessageService,
              private router: Router) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      lozinka: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmitLogin(): void {
    if (this.loginForm.invalid) {
      this.messageService.add({severity: 'error', summary: 'Neuspešna prijava', detail: 'Prijava nije bila uspešna'});
      return;
    }

    const prijava = new Prijava();
    prijava.email._text = this.loginForm.get('email').value;
    prijava.lozinka._text = this.loginForm.get('lozinka').value;

    const element = new PrijavaElement();
    element.prijava = prijava;
    const xmlPrijava = xml.js2xml(element, {compact: true, ignoreComment: true, spaces: 2});

    this.authService.login(xmlPrijava).subscribe(val => {
      console.log(val);
      const tokenOdgovor = xml.xml2js(val, {compact: true}) as TokenOdgovor;
      this.authService.loggedIn(tokenOdgovor.odgovor.token._text, tokenOdgovor.odgovor.korisnik);
      this.router.navigate(['']);
    });
  }

}
