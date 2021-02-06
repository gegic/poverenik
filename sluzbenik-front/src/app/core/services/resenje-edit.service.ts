import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class ResenjeEditService {

  tip = 'prihvatanje';

  specification = {
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
      resenje: {
        attributes: {
          tip: {
            asker: Xonomy.askPicklist,
            askerParameter: [],
            validate(jsAttribute: any): void {
            }
          }
        }
      },
      zalilac: {
        isReadOnly: true,
        attributes: {
          id: {
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
        }
      },
      adresa: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
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
        hasText: true,
        asker: Xonomy.askString
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
        hasText: true,
        asker: Xonomy.askString
      },
      'ime-prezime': {
        hasText: true,
      },
      protiv: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        isReadOnly: true
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
        hasText: true,
        asker: Xonomy.askString
      },
      zalba: {
        isReadOnly: true,
        attributes: {
          id: {
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
        }
      },
      obavestenje: {
        isReadOnly: true
      },
      nepostupanje: {
        isReadOnly: true,
        attributes: {
          id: {
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
        }
      },
      zahtev: {
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
        attributes: {
          id: {
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
        }
      },
      'opis-zahteva': {
        hasText: true,
        isReadOnly: true
      },
      osnov: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
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
        },
        menu: [
          {
            caption: 'Append a <zakon>',
            action: Xonomy.newElementChild,
            actionParameter: '<zakon></zakon>'
          },
        ]
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
          },
          {
            caption: 'Delete this <item>',
            action: Xonomy.deleteElement
          },
        ]
      },
      clan: {
        validate(jsElement: any): void {
          if (!jsElement.hasAttribute('broj')) {
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
          if (!jsElement.hasAttribute('broj')) {
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
          if (!jsElement.hasAttribute('broj')) {
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
        hasText: true,
        asker: Xonomy.askString,
      },
      telo: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        }
      },
      nalog: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        }
      },
      akcija: {
        hasText: true
      },
      obavestiti: {
        attributes: {
          rok: {
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
      odbijanje: {},
      obrazlozenje: {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        }
      },
      izjasnjenje: {
        isReadOnly: true,
        attributes: {
          odgovor: {}
        },
      },
      'pravno-sredstvo': {
        validate(jsElement: any): void {
          if (!jsElement.hasElements()) {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
        attributes: {
          rok: {
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
          },
          taksa: {
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
      sud: {
        validate(jsElement: any): void {
          if (jsElement.getText() === '') {
            Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: 'This element must not be empty.'
              }
            );
          }
        },
      },
      poverenik: {},
      datum: {
        hasText: true,
        isReadOnly: true
      }
    }
  };


  constructor() { }

  render(element: any,  xmlString: string, readOnly?: boolean): void {
    (this.specification.elements.resenje as any).isReadOnly = !!readOnly;
    if (this.tip === 'prihvatanje') {
      this.specification.elements.resenje.attributes.tip.askerParameter = ['prihvatanje'];
      this.specification.elements.resenje.attributes.tip.validate = jsAttribute => {
        if (jsAttribute.value !== 'prihvatanje') {
          Xonomy.warnings.push({
              htmlID: jsAttribute.htmlID,
              text: 'This attribute must be \'prihvatanje\'.'
            }
          );
        }
      };
    } else if (this.tip === 'odbijanje') {
      this.specification.elements.resenje.attributes.tip.askerParameter = ['odbijanje-zalbe', 'odbijanje-zahteva'];
      this.specification.elements.resenje.attributes.tip.validate = jsAttribute => {
        if (jsAttribute.value !== 'odbijanje-zalbe' && jsAttribute.value !== 'odbijanje-zahteva') {
          Xonomy.warnings.push({
              htmlID: jsAttribute.htmlID,
              text: 'This attribute must be either \'odbijanje-zalbe\' or \'odbijanje-zahteva\'.'
            }
          );
        }
      };
    }
    Xonomy.render(xmlString, element, {
      validate: this.specification.validate,
      elements: this.specification.elements
    });
    Xonomy.setMode('nerd');
  }

  harvest(): string {
    return Xonomy.harvest();
  }

  get warnings(): any[] {
    return Xonomy.warnings;
  }
}
