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
              label: 'Žalbe',
              routerLink: '/pregled-zalbi'
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
          label: 'Žalbe',
          icon: 'pi pi-align-justify',
          items: [
            {
              label: 'Nerešene žalbe',
              routerLink: '/resavanje-zalbi'
            },
            {
              label: 'Sve žalbe',
              routerLink: '/sve-zalbe'
            },
          ]
        },
        {
          label: 'Dokumenta',
          icon: 'pi pi-align-justify',
          items: [
            {
              label: 'Pregled svih rešenja',
              routerLink: '/sva-resenja'
            },
            {
              label: 'Pretraga',
              routerLink: '/pretraga'
            }
          ]
        },


      ];
    }
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['prijava']);
  }

}
