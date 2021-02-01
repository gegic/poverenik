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
          routerLink: '/',
          routerLinkActiveOptions: {exact: true}
        },
        {
          label: 'Podnošenje žalbe na ćutanje',
          routerLink: '/izbor-neodgovorenih-zahteva'
        },
        {
          label: 'Podnošenje žalbe na odluku',
          routerLink: '/podnosenje-zalbe-na-odluku'
        },
        {
          label: 'Pregled podnetih žalbi na ćutanje',
          routerLink: '/pregled-zalbi-cutanje'
        },
        {
          label: 'Pregled podnetih žalbi na odluku',
          routerLink: '/pregled-zalbi-na-odluku'
        },
        {
          label: 'Pregled donetih rešenja',
          routerLink: '/pregled-resenja'
        }
      ];
    } else {
      this.items = [
        {
          label: 'Početna',
          routerLink: '/poverenik',
        },
        {
          label: 'Novi zahtevi',
          routerLink: '/novi-zahtevi'
        },
        {
          label: 'Pregled svih zahteva',
          routerLink: '/svi-zahtevi'
        },
        {
          label: 'Pregled svih obaveštenja',
          routerLink: '/sva-obavestenja'
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
