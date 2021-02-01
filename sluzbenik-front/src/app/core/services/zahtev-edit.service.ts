import { Injectable } from '@angular/core';
import {AuthService} from './auth.service';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class ZahtevEditService {

  public specification = {
    validate(jsElement: any): void {
      const elementSpec = this.elements[jsElement.name];
      if (elementSpec.validate) {
        elementSpec.validate(jsElement);
      }
      // Cycle through the element's attributes:
      for (const jsAttribute of jsElement.attributes) {
        const attributeSpec = elementSpec.attributes[jsAttribute.name];
        if (attributeSpec.validate) {
          attributeSpec.validate(jsAttribute);
        }
      }
      // Cycle through the element's children:
      for (const jsChild of jsElement.children) {
        if (jsChild.type === 'element') {
          this.validate(jsChild);
        }
      }
    },
    elements: {
      zahtev: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
          if (!jsElement.hasChildElement('organ')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element orgam.'
              }
            );
          }
          if (!jsElement.hasChildElement('zakon')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element zakon.'
              }
            );
          }
          if (!jsElement.hasChildElement('tip-zahteva')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element tip-zahteva.'
              }
            );
          }

          if (!jsElement.hasChildElement('opis-zahteva')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element opis-zahteva.'
              }
            );
          }
          if (!jsElement.hasChildElement('mesto')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element mesto.'
              }
            );
          }
          if (!jsElement.hasChildElement('datum')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element datum.'
              }
            );
          }
          if (!jsElement.hasChildElement('trazilac-informacije')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element trazilac-informacije.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Append an <organ>',
            action: Xonomy.newElementChild,
            actionParameter: `<organ/>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('organ');
            }
          },
          {
            caption: 'Append an <zakon>',
            action: Xonomy.newElementChild,
            actionParameter: `<zakon/>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('zakon');
            }
          },
          {
            caption: 'Append an <tip-zahteva>',
            action: Xonomy.newElementChild,
            actionParameter: `<tip-zahteva/>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('tip-zahteva');
            }
          },
          {
            caption: 'Append an <opis-zahteva>',
            action: Xonomy.newElementChild,
            actionParameter: `<opis-zahteva></opis-zahteva>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('opis-zahteva');
            }
          },
          {
            caption: 'Append an <mesto>',
            action: Xonomy.newElementChild,
            actionParameter: `<mesto></mesto>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('mesto');
            }
          },
          {
            caption: 'Append an <datum>',
            action: Xonomy.newElementChild,
            actionParameter: `<datum>${new Date().toISOString().slice(0, 10)}</datum>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('datum');
            }
          },
          {
            caption: 'Append an <trazilac-informacije>',
            action: Xonomy.newElementChild,
            actionParameter: `<trazilac-informacije></trazilac-informacije>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('trazilac-informacije');
            }
          },
        ],
        attributes: {}
      },
      organ: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
          if (!jsElement.hasChildElement('adresa')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element adresa.'
              }
            );
          }
          if (!jsElement.hasChildElement('naziv')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element naziv.'
              }
            );
          }
        },
        mustBeBefore: ['zakon', 'tip-zahteva', 'opis-zahteva', 'trazilac-informacije', 'mesto', 'datum'],
        hasText: false,
        menu: [
          {
            caption: 'Append an <adresa>',
            action: Xonomy.newElementChild,
            actionParameter: '<adresa></adresa>',
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('adresa');
            }
          },
          {
            caption: 'Append an <naziv>',
            action: Xonomy.newElementChild,
            actionParameter: '<naziv></naziv>',
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('naziv');
            }
          }
        ]
      },
      adresa: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Append an <mesto>',
            action: Xonomy.newElementChild,
            actionParameter: '<mesto></mesto>',
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('mesto');
            }
          },
          {
            caption: 'Append an <ulica>',
            action: Xonomy.newElementChild,
            actionParameter: `<ulica></ulica>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('ulica');
            }
          }
        ],
        mustBeBefore: ['naziv', 'ime-prezime'],
      },
      mesto: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        mustBeBefore: ['ulica'],
        hasText: true
      },
      ulica: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        menu: [],
        hasText: true
      },
      naziv: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        menu: [{
          caption: 'Delete this <item>',
          action: Xonomy.deleteElement
        }
        ],
        hasText: true
      },
      zakon: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
          if (!jsElement.hasChildElement('naziv')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element naziv.'
              }
            );
          }
          if (!jsElement.hasChildElement('clan')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element clan.'
              }
            );
          }
          if (!jsElement.hasChildElement('sluzbeni-glasnik')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element sluzbeni-glasnik.'
              }
            );
          }
        },
        mustBeBefore: ['tip-zahteva', 'opis-zahteva', 'mesto', 'datum', 'trazilac-informacije'],
        menu: [
          {
            caption: 'Append an <clan>',
            action: Xonomy.newElementChild,
            actionParameter: '<clan></clan>',
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('adresa');
            }
          },
          {
            caption: 'Append an <naziv>',
            action: Xonomy.newElementChild,
            actionParameter: '<naziv></naziv>',
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('naziv');
            }
          },
          {
            caption: 'Append an <sluzbeni-glasnik>',
            action: Xonomy.newElementChild,
            actionParameter: '<sluzbeni-glasnik></sluzbeni-glasnik>',
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('sluzbeni-glasnik');
            }
          }
        ]
      },
      clan: {
        validate(jsElement: any): void {
          if (jsElement.hasAttribute('broj') === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have an attribute broj.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Delete this <item>',
            action: Xonomy.deleteElement
          },
          {
            caption: 'Add @broj',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'broj', value: '' },
            hideIf(jsElement: any): void {
              return jsElement.hasAttribute('broj');
            }
          },
          {
            caption: 'Append an <stav>',
            action: Xonomy.newElementChild,
            actionParameter: '<stav></stav>',
          }
        ],
        attributes: {
          broj: {
            asker: Xonomy.askString,
            validate(jsAttribute: any): void {
              if (jsAttribute.value === '') {
                Xonomy.warnings.push({
                    htmlID: jsAttribute.htmlID,
                    text: 'This attribute must not be empty.'
                  }
                );
              }
            }
          }
        },
        mustBeBefore: ['sluzbeni-glasnik'],
        mustBeAfter: ['naziv']
      },
      stav: {
        validate(jsElement: any): void {
          if (jsElement.hasAttribute('broj') === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have an attribute broj.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Delete this <item>',
            action: Xonomy.deleteElement
          },
          {
            caption: 'Add @broj',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'broj', value: '' },
            hideIf(jsElement: any): void {
              return jsElement.hasAttribute('broj');
            }
          },
          {
            caption: 'Append an <tacka>',
            action: Xonomy.newElementChild,
            actionParameter: '<tacka></tacka>',
          }
        ],
        attributes: {
          broj: {
            asker: Xonomy.askString,
            validate(jsAttribute: any): void {
              if (jsAttribute.value === '') {
                Xonomy.warnings.push({
                    htmlID: jsAttribute.htmlID,
                    text: 'This attribute must not be empty.'
                  }
                );
              }
            }
          }
        },
      },
      tacka: {
        validate(jsElement: any): void {
          if (jsElement.hasAttribute('broj') === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have an attribute broj.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Delete this <item>',
            action: Xonomy.deleteElement
          },
          {
            caption: 'Add @broj',
            action: Xonomy.newAttribute,
            actionParameter: { name: 'broj', value: '' },
            hideIf(jsElement: any): void {
              return jsElement.hasAttribute('broj');
            }
          }
        ],
        attributes: {
          broj: {
            asker: Xonomy.askString,
            validate(jsAttribute: any): void {
              if (jsAttribute.value === '') {
                Xonomy.warnings.push({
                    htmlID: jsAttribute.htmlID,
                    text: 'This attribute must not be empty.'
                  }
                );
              }
            }
          }
        },
      },
      'sluzbeni-glasnik': {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
          if (!jsElement.hasChildElement('broj')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have at least one element naziv.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Append an <broj>',
            action: Xonomy.newElementChild,
            actionParameter: '<broj></broj>',
          },
          {
            caption: 'Delete this <item>',
            action: Xonomy.deleteElement
          }
        ],
      },
      broj: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        menu: [{
          caption: 'Delete this <item>',
          action: Xonomy.deleteElement
        }
        ],
        hasText: true
      },
      'tip-zahteva': {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        mustBeBefore: ['opis-zahteva', 'mesto', 'datum'],
        menu: [
          {
            caption: 'Append an <obavestenje-posedovanja-informacije>',
            action: Xonomy.newElementChild,
            actionParameter: `<obavestenje-posedovanja-informacije></obavestenje-posedovanja-informacije>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('obavestenje-posedovanja-informacije');
            }
          },
          {
            caption: 'Append an <uvid-u-dokument>',
            action: Xonomy.newElementChild,
            actionParameter: `<uvid-u-dokument></uvid-u-dokument>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('uvid-u-dokument');
            }
          },
          {
            caption: 'Append an <kopiju-dokumenta>',
            action: Xonomy.newElementChild,
            actionParameter: `<kopiju-dokumenta></kopiju-dokumenta>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('kopiju-dokumenta');
            }
          },
          {
            caption: 'Append an <dostavljanje-kopije>',
            action: Xonomy.newElementChild,
            actionParameter: `<dostavljanje-kopije></dostavljanje-kopije>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('dostavljanje-kopije');
            }
          },
        ]
      },
      'obavestenje-posedovanja-informacije': {
        mustBeBefore: ['uvid-u-dokument', 'kopiju-dokumenta', 'dostavljanje-kopije']
      },
      'uvid-u-dokument': {
        mustBeBefore: ['kopiju-dokumenta', 'dostavljanje-kopije']
      },
      'kopiju-dokumenta': {
        mustBeBefore: ['dostavljanje-kopije']
      },
      'dostavljanje-kopije': {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Append an <posta>',
            action: Xonomy.newElementChild,
            actionParameter: `<posta></posta>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('posta');
            }
          },
          {
            caption: 'Append an <faks>',
            action: Xonomy.newElementChild,
            actionParameter: `<faks></faks>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('faks');
            }
          },
          {
            caption: 'Append an <eposta>',
            action: Xonomy.newElementChild,
            actionParameter: `<eposta></eposta>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('eposta');
            }
          },
          {
            caption: 'Append an <drugi-nacin>',
            action: Xonomy.newElementChild,
            actionParameter: `<drugi-nacin><opis-dostave></opis-dostave></drugi-nacin>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('drugi-nacin');
            }
          },
        ]
      },
      posta: {
        mustBeBefore: ['faks', 'eposta', 'drugi-nacin']
      },
      faks: {
        mustBeBefore: ['eposta', 'drugi-nacin']
      },
      eposta: {
        mustBeBefore: ['drugi-nacin']
      },
      'drugi-nacin': {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Append an <opis-dostave>',
            action: Xonomy.newElementChild,
            actionParameter: `<opis-dostave></opis-dostave>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('opis-dostave');
            }
          },
        ]
      },
      'opis-dostave': {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        hasText: true
      },
      'opis-zahteva': {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        mustBeBefore: ['mesto', 'datum', 'trazilac-informacije'],
        hasText: true
      },
      datum: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        isReadOnly: true,
        mustBeBefore: ['trazilac-informacije']
      },
      'trazilac-informacije': {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
          if (!jsElement.hasChildElement('adresa')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element adresa.'
              }
            );
          }
          if (!jsElement.hasChildElement('ime-prezime')) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element needs to have element adresa.'
              }
            );
          }
        },
        menu: [
          {
            caption: 'Append an <adresa>',
            action: Xonomy.newElementChild,
            actionParameter: '<adresa></adresa>',
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('adresa');
            }
          },
          {
            caption: 'Append an <ime-prezime>',
            action: Xonomy.newElementChild,
            actionParameter: `<ime-prezime>${this.authService.korisnik.getValue()['ime-prezime']._text}</ime-prezime>`,
            hideIf(jsElement: any): void {
              return jsElement.hasChildElement('ime-prezime');
            }
          }
        ],
        mustBeAfter: ['datum', 'mesto', 'opis-zahteva', 'tip-zahteva', 'zakon', 'organ']
      },
      'ime-prezime': {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        isReadOnly: true,
        hasText: true
      },
    },
  };

  constructor(private authService: AuthService) { }

  render(element: any): void {
    const xmlString = `
<zahtev xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" rdfa_z="http://team14.xml.com/rdf/zahtevi" rdfa_pred="http://team14.xml.com/rdf/zahtevi/predicate/"><organ><adresa/><naziv></naziv></organ><zakon><naziv></naziv><sluzbeni-glasnik></sluzbeni-glasnik></zakon><tip-zahteva/><opis-zahteva></opis-zahteva><mesto></mesto><datum>${new Date().toISOString().slice(0, 10)}</datum><trazilac-informacije/></zahtev>`;
    Xonomy.render(xmlString, element, {
      validate: this.specification.validate,
      elements: this.specification.elements
    });
    Xonomy.setMode('laic');
  }

  harvest(): string {
    return Xonomy.harvest();
  }

  get warnings(): any[] {
    return Xonomy.warnings;
  }
}
