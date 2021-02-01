import {Korisnik} from './korisnik';
import {ElementCompact} from 'xml-js';

export class TokenOdgovor {

  odgovor: {
    token: {
      _text: string
    },

    korisnik: Korisnik
  };

}
