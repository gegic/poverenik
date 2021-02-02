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
          label: 'Pregled',
          icon: 'pi pi-align-justify',
          items: [
            {
              label: 'Žalbe zbog ćutanja',
              routerLink: '/pregled-zalbi-cutanje'
            },
            {
              label: 'Žalbe na odluku',
              routerLink: '/pregled-zalbi-na-odluku'
            },
            {
              label: 'Rešenja',
              routerLink: '/pregled-resenja'
            }
          ]
        },
        {
          label: 'Podnošenje',
          icon: 'pi pi-pencil',
          items: [
            {
              label: 'Žalba na ćutanje',
              routerLink: '/izbor-neodgovorenih-zahteva'
            },
            {
              label: 'Žalba na odluku',
              routerLink: '/izbor-odbijenih-zahteva'
            },
          ]
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
