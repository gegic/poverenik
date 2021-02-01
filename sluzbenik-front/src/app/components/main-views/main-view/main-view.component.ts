import { Component, OnInit } from '@angular/core';
import {MenuItem} from 'primeng/api';
import {AuthService} from '../../../core/services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements OnInit {

  items: MenuItem[] = [];

  constructor(public authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {

    if (this.authService.getKorisnikRole() === 'gradjanin') {
      this.items = [
        {
          label: 'Početna',
          routerLink: '/'
        },
        {
          label: 'Podnošenje zahteva',
          routerLink: '/podnosenje-zahteva'
        },
        {
          label: 'Pregled zahteva',
          routerLink: '/pregled-zahteva'
        },
        {
          label: 'Pregled obaveštenja',
          routerLink: '/pregled-obavestenja'
        }
      ];
    } else {
      this.items = [
        {
          label: 'Početna',
          routerLink: '/sluzbenik',
        },
        {
          label: 'Novi zahtevi',
          routerLink: '/novi-zahtevi'
        },
        {
          label: 'Pregled svih prethodnih dokumenata',
          routerLink: '/pregled-dokumenata'
        },
        {
          label: 'Izveštaj',
          routerLink: '/izvestaj'
        }

      ];
    }
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['prijava']);
  }

}
